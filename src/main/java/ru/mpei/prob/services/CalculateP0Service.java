package ru.mpei.prob.services;

import ru.mpei.prob.entity.postgres.EquipmentEnt;
import ru.mpei.prob.entity.postgres.ItsMeasurementsPostgresVersion;
import ru.mpei.prob.entity.postgres.PredictedProbMeas;
import ru.mpei.prob.entity.postgres.ProbabilityEnt;
import ru.mpei.prob.repositories.postgres.*;
import org.springframework.stereotype.Service;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.ConductingEquipment;
import ru.mpei.prob.repositories.postgres.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Service
public class CalculateP0Service {



    private final EquipmentRepo equipmentRepo;

    private final EquipTypeRepo equipTypeRepo;

    private final ItsMeasurementServ itsService;

    private final ProbabilityRepo probabilityRepo;
    private final PredictedItsRepo predictedItsRepo;

    private final ItsMeasRepo itsMeasRepo;

    private final CalculateAlphaService alphaService;

    private final PredictedProbRepo predictedProbRepo;

    private final ConductingEquipmentRepo conductingEquipmentRepo;


    public CalculateP0Service(EquipmentRepo equipmentRepo, EquipTypeRepo equipTypeRepo, ItsMeasurementServ itsService, ProbabilityRepo probabilityRepo, PredictedItsRepo predictedItsRepo, ItsMeasRepo itsMeasRepo, CalculateAlphaService alphaService, PredictedProbRepo predictedProbRepo, ConductingEquipmentRepo conductingEquipmentRepo) {
        this.equipmentRepo = equipmentRepo;
        this.equipTypeRepo = equipTypeRepo;
        this.itsService = itsService;
        this.probabilityRepo = probabilityRepo;
        this.predictedItsRepo = predictedItsRepo;
        this.itsMeasRepo = itsMeasRepo;
        this.alphaService = alphaService;
        this.predictedProbRepo = predictedProbRepo;
        this.conductingEquipmentRepo = conductingEquipmentRepo;
    }

    public Double calculateP0(String id, List<LocalDate> dateTime, Integer var){
        ConductingEquipment equipment = conductingEquipmentRepo.getReferenceById(id);
        Double its_after0;
        Double its_before0;
        if (dateTime.get(0)==null){
            dateTime.set(0, equipment.getLastFixDate());
            its_after0 = itsMeasRepo.getFirstByEquipmentIdAndMeasurmentDateAfterOrderByMeasurmentDateAsc(id,dateTime.get(0)).getIts();
            its_before0 =itsMeasRepo.getFirstByEquipmentIdAndMeasurmentDateBeforeOrderByMeasurmentDateDesc(id,dateTime.get(0)).getIts();
        }
        else {
            its_after0 = predictedItsRepo.getFirstByEquipmentAndPredDateAfterAndPlanNumberOrderByPredDateAsc(equipment,dateTime.get(0),var).getIts();
            its_before0 = predictedItsRepo.getFirstByEquipmentAndPredDateBeforeAndPlanNumberOrderByPredDateDesc(equipment,dateTime.get(0),var).getIts();
        }
        Double p0=0.0;
        Double p=0.0;
        if (equipment!=null){
            Double its_after = predictedItsRepo.getFirstByEquipmentAndPredDateAfterAndPlanNumberOrderByPredDateAsc(equipment,dateTime.get(1),var).getIts();
            Double its_before = predictedItsRepo.getFirstByEquipmentAndPredDateBeforeAndPlanNumberOrderByPredDateDesc(equipment,dateTime.get(1),var).getIts();
            if (its_after!=null && its_before!=null) {
                p=1-(its_after/100)*its_before/its_after;
            }
            else {
                Logger.getLogger(CalculateP0Service.class.getSimpleName()).info("предсказанные ИТС для  оборудования id= " + equipment.getMRID() + " и номером плана " + var + " не найден");
            }
            Float alpha= equipment.getAlphaFailure();
            Double predictedP=1 - (its_after0/100)*its_before0/its_after0*Math.exp(-alpha*24*ChronoUnit.DAYS.between(dateTime.get(0),dateTime.get(1)));
            p0= predictedP-p;
        }
        else{
            Logger.getLogger(CalculateP0Service.class.getSimpleName()).info("оборудование с id = " + equipment.getMRID() + " и номером плана " + var + " не найден");
        }

        return p0;
    }

    public Map<LocalDate,Double> calculateP0ForPredicted(String id, LocalDate dateTime){
        ConductingEquipment equipment = conductingEquipmentRepo.getReferenceById(id);
        Map<LocalDate,Double> resultMap= new HashMap<>();
        if (equipment!=null){
            LocalDate lastFixDate = equipment.getLastFixDate();
            ItsMeasurementsPostgresVersion before = itsMeasRepo.getFirstByEquipmentIdAndMeasurmentDateBeforeOrderByMeasurmentDateDesc(id,equipment.getLastFixDate());
            ItsMeasurementsPostgresVersion after = itsMeasRepo.getFirstByEquipmentIdAndMeasurmentDateAfterOrderByMeasurmentDateAsc(id,equipment.getLastFixDate());
            Double its_after = itsMeasRepo.getFirstByEquipmentIdAndMeasurmentDateAfterOrderByMeasurmentDateAsc(id,equipment.getLastFixDate()).getIts();
            Double its_before =itsMeasRepo.getFirstByEquipmentIdAndMeasurmentDateBeforeOrderByMeasurmentDateDesc(id,equipment.getLastFixDate()).getIts();
            Float alpha=equipment.getAlphaFailure();
            Long dif = ChronoUnit.DAYS.between(lastFixDate,dateTime);
            for (Long i=1L;i<=dif;i++){
                Double p = 1 - (its_after/100)*its_before/its_after*Math.exp(-alpha*24*i);
                LocalDate date = lastFixDate.plusDays(i);
                resultMap.put(date,p);
            }
        }
        else{
            Logger.getLogger(CalculateP0Service.class.getSimpleName()).info("оборудование с id = " + equipment.getMRID() + " не найден");
        }
        return resultMap;
    }

    public Double calculatePForReal(ConductingEquipment equipment, LocalDate localDateTime){
        Double its_before= itsService.getOneItsBeforeDate(equipment.getMRID(),localDateTime);
        Double its= itsService.getItsByDate(equipment.getMRID(),localDateTime);
        Double p=null;
        if (its!=null && its_before!=null){
            p=(its/100)*its_before/its;
        }

        return p;
    }

    public void calcPForEquipment(String equip_id, LocalDate date){
        ConductingEquipment equipment = conductingEquipmentRepo.getReferenceById(equip_id);
        if (equipment!=null){
            Double p=calculatePForReal(equipment, date);
            if (p!=null) {
                ProbabilityEnt probabilityEnt = new ProbabilityEnt(equipment, date, p);
                probabilityRepo.save(probabilityEnt);
            }
            else {
                Logger.getLogger(CalculateP0Service.class.getSimpleName()).info("рассчитанный ИТС для даты = " + date + " не найден");
            }
        }
        else{
            Logger.getLogger(CalculateP0Service.class.getSimpleName()).info("оборудование с id = " + equip_id + " не найдено");
        }
    }


    public Map<LocalDate,Double> calculateP0ForPredictedSec(String id, List<LocalDate> lastFixDate, LocalDate dateTime, Integer var){
        ConductingEquipment equipment = conductingEquipmentRepo.getReferenceById(id);
        Map<LocalDate,Double> resultMap= new HashMap<>();
        if (equipment!=null){
            Integer len = lastFixDate.size();
            LocalDate realFixDate = equipment.getLastFixDate();
            resultMap.putAll(calculation(equipment,realFixDate,lastFixDate.get(0),var,false));
            for (Integer i=1;i<len;i++){
                resultMap.putAll(calculation(equipment,lastFixDate.get(i-1),lastFixDate.get(i),var,true));
            }
            resultMap.putAll(calculation(equipment,lastFixDate.get(len-1),dateTime,var,true));
        }
        else {
            Logger.getLogger(CalculateP0Service.class.getSimpleName()).info("оборудование с id = " + id + " не найдено");
        }
        return resultMap;
    }


    private Map<LocalDate,Double> calculation (ConductingEquipment equipment, LocalDate date1, LocalDate date2,Integer var, Boolean flag){
        Map<LocalDate,Double> resultMap= new HashMap<>();
        Float alpha = equipment.getAlphaFailure();
        Long dif = ChronoUnit.DAYS.between(date1,date2);
        Double its_after;
        Double its_before;
        if (flag){
            its_after = predictedItsRepo.getFirstByEquipmentAndPredDateAfterAndPlanNumberOrderByPredDateAsc(equipment,date1,var).getIts();
            its_before =predictedItsRepo.getFirstByEquipmentAndPredDateBeforeAndPlanNumberOrderByPredDateDesc(equipment,date1,var).getIts();
        }else {
            its_after = itsMeasRepo.getFirstByEquipmentIdAndMeasurmentDateAfterOrderByMeasurmentDateAsc(equipment.getMRID(),date1).getIts();
            its_before =itsMeasRepo.getFirstByEquipmentIdAndMeasurmentDateBeforeOrderByMeasurmentDateDesc(equipment.getMRID(),date1).getIts();
        }
        for (Long i=0L;i<dif;i++){
            Double p = 1 - (its_after/100)*its_before/its_after*Math.exp(-alpha*24*i);
            LocalDate date = date1.plusDays(i);
            resultMap.put(date,p);
            PredictedProbMeas prob = new PredictedProbMeas();
            prob.setPredDate(date);
            prob.setEquipment(equipment);
            prob.setPlanNumber(var);
            prob.setProbability(p);
            predictedProbRepo.save(prob);
        }
        return resultMap;
    }
}
