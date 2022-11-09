package com.example.demo.services;

import com.example.demo.entity.postgres.EquipmentEnt;
import com.example.demo.entity.postgres.ItsMeasurementsPostgresVersion;
import com.example.demo.entity.postgres.PredictedProbMeas;
import com.example.demo.entity.postgres.ProbabilityEnt;
import com.example.demo.repositories.postgres.*;
import org.springframework.stereotype.Service;

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


    public CalculateP0Service(EquipmentRepo equipmentRepo, EquipTypeRepo equipTypeRepo, ItsMeasurementServ itsService, ProbabilityRepo probabilityRepo, PredictedItsRepo predictedItsRepo, ItsMeasRepo itsMeasRepo, CalculateAlphaService alphaService, PredictedProbRepo predictedProbRepo) {
        this.equipmentRepo = equipmentRepo;
        this.equipTypeRepo = equipTypeRepo;
        this.itsService = itsService;
        this.probabilityRepo = probabilityRepo;
        this.predictedItsRepo = predictedItsRepo;
        this.itsMeasRepo = itsMeasRepo;
        this.alphaService = alphaService;
        this.predictedProbRepo = predictedProbRepo;
    }

    public Double calculateP0(Long id, List<LocalDate> dateTime, Integer var){
        EquipmentEnt equipment = equipmentRepo.findById(id).get();
        Double its_after0;
        Double its_before0;
        if (dateTime.get(0)==null){
            dateTime.set(0, equipment.getLastFixionDate());
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
                Logger.getLogger(CalculateP0Service.class.getSimpleName()).info("предсказанные ИТС для  оборудования id= " + equipment.getId() + " и номером плана " + var + " не найден");
            }
            Double alpha= alphaService.getAlpha(equipment);
            Double predictedP=1 - (its_after0/100)*its_before0/its_after0*Math.exp(-alpha*24*ChronoUnit.DAYS.between(dateTime.get(0),dateTime.get(1)));
            p0= predictedP-p;
        }
        else{
            Logger.getLogger(CalculateP0Service.class.getSimpleName()).info("оборудование с id = " + equipment.getId() + " и номером плана " + var + " не найден");
        }

        return p0;
    }

    public Map<LocalDate,Double> calculateP0ForPredicted(Long id, LocalDate dateTime){
        EquipmentEnt equipment = equipmentRepo.findById(id).get();
        Map<LocalDate,Double> resultMap= new HashMap<>();
        if (equipment!=null){
            LocalDate lastFixDate = equipment.getLastFixionDate();
            ItsMeasurementsPostgresVersion before = itsMeasRepo.getFirstByEquipmentIdAndMeasurmentDateBeforeOrderByMeasurmentDateDesc(id,equipment.getLastFixionDate());
            ItsMeasurementsPostgresVersion after = itsMeasRepo.getFirstByEquipmentIdAndMeasurmentDateAfterOrderByMeasurmentDateAsc(id,equipment.getLastFixionDate());
            Double its_after = itsMeasRepo.getFirstByEquipmentIdAndMeasurmentDateAfterOrderByMeasurmentDateAsc(id,equipment.getLastFixionDate()).getIts();
            Double its_before =itsMeasRepo.getFirstByEquipmentIdAndMeasurmentDateBeforeOrderByMeasurmentDateDesc(id,equipment.getLastFixionDate()).getIts();
            Double alpha= alphaService.getAlpha(equipment);
            Long dif = ChronoUnit.DAYS.between(lastFixDate,dateTime);
            for (Long i=1L;i<=dif;i++){
                Double p = 1 - (its_after/100)*its_before/its_after*Math.exp(-alpha*24*i);
                LocalDate date = lastFixDate.plusDays(i);
                resultMap.put(date,p);
            }
        }
        else{
            Logger.getLogger(CalculateP0Service.class.getSimpleName()).info("оборудование с id = " + equipment.getId() + " не найден");
        }
        return resultMap;
    }

    public Double calculatePForReal(EquipmentEnt equipment, LocalDate localDateTime){
        Double its_before= itsService.getOneItsBeforeDate(equipment.getId(),localDateTime);
        Double its= itsService.getItsByDate(equipment.getId(),localDateTime);
        Double p=null;
        if (its!=null && its_before!=null){
            p=(its/100)*its_before/its;
        }

        return p;
    }

    public void calcPForEquipment(Long equip_id, LocalDate date){
        EquipmentEnt equip = equipmentRepo.findById(equip_id).get();
        if (equip!=null){
            Double p=calculatePForReal(equip, date);
            if (p!=null) {
                ProbabilityEnt probabilityEnt = new ProbabilityEnt(equip, date, p);
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


    public Map<LocalDate,Double> calculateP0ForPredictedSec(Long id, List<LocalDate> lastFixDate, LocalDate dateTime, Integer var){
        EquipmentEnt equipment = equipmentRepo.findById(id).get();
        Map<LocalDate,Double> resultMap= new HashMap<>();
        if (equipment!=null){
            Integer len = lastFixDate.size();
            LocalDate realFixDate = equipment.getLastFixionDate();
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


    private Map<LocalDate,Double> calculation (EquipmentEnt equipment, LocalDate date1, LocalDate date2,Integer var, Boolean flag){
        Map<LocalDate,Double> resultMap= new HashMap<>();
        Double alpha = alphaService.getAlpha(equipment);
        Long dif = ChronoUnit.DAYS.between(date1,date2);
        Double its_after;
        Double its_before;
        if (flag){
            its_after = predictedItsRepo.getFirstByEquipmentAndPredDateAfterAndPlanNumberOrderByPredDateAsc(equipment,date1,var).getIts();
            its_before =predictedItsRepo.getFirstByEquipmentAndPredDateBeforeAndPlanNumberOrderByPredDateDesc(equipment,date1,var).getIts();
        }else {
            its_after = itsMeasRepo.getFirstByEquipmentIdAndMeasurmentDateAfterOrderByMeasurmentDateAsc(equipment.getId(),date1).getIts();
            its_before =itsMeasRepo.getFirstByEquipmentIdAndMeasurmentDateBeforeOrderByMeasurmentDateDesc(equipment.getId(),date1).getIts();
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
