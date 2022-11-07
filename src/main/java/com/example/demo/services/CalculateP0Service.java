package com.example.demo.services;

import com.example.demo.entity.postgres.EquipmentEnt;
import com.example.demo.entity.postgres.PredictedProbMeas;
import com.example.demo.entity.postgres.ProbabilityEnt;
import com.example.demo.repositories.postgres.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
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

    public Double calculateP0(Long id, LocalDate dateTime,Integer var){
        EquipmentEnt equipment = equipmentRepo.findById(id).get();
        if (dateTime==null){
            dateTime = equipment.getLastFixionDate();
        }
        Double p0=0.0;
        if (equipment!=null){
            Double its_after = predictedItsRepo.findByEquipmentAndDateAfterAndAndPlanNumber(equipment,dateTime,var).getIts();
            Double its_before = predictedItsRepo.findByEquipmentAndDateBeforeAndAndPlanNumber(equipment,dateTime,var).getIts();
            if (its_after!=null && its_before!=null) {
                p0=1-(1-its_after/100)*its_before/its_after;
            }
            else {
                Logger.getLogger(CalculateP0Service.class.getSimpleName()).info("предсказанные ИТС для  оборудования id= " + equipment.getId() + " и номером плана " + var + " не найден");
            }
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
            Double its_after = itsMeasRepo.getFirstByEquipmentIdAndMeasurmentDateAfterOrderByMeasurmentDateAsc(id,dateTime).getIts();
            Double its_before =itsMeasRepo.getFirstByEquipmentIdAndMeasurmentDateBeforeOrderByMeasurmentDateDesc(id,dateTime).getIts();
            Double alpha= alphaService.getAlpha(equipment);
            Long dif = ChronoUnit.DAYS.between(lastFixDate,dateTime);
            for (Long i=1L;i<=dif;i++){
                Double p = 1 - (1-its_after/100)*its_before/its_after*Math.exp(-alpha*24*i);
                LocalDate date = lastFixDate.plusDays(i);
                resultMap.put(date,p);
            }
        }
        return resultMap;
    }

    public Double calculatePForReal(EquipmentEnt equipment, LocalDate localDateTime){
        Double its_before= itsService.getOneItsBeforeDate(equipment.getId(),localDateTime);
        Double its= itsService.getItsByDate(equipment.getId(),localDateTime);
        Double p=null;
        if (its!=null && its_before!=null){
            p=(1-its/100)*its_before/its;
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


    public Map<LocalDate,Double> calculateP0ForPredictedSec(Long id, LocalDate lastFixDate, LocalDate dateTime, Integer var){
        EquipmentEnt equipment = equipmentRepo.findById(id).get();
        Map<LocalDate,Double> resultMap= new HashMap<>();
        if (equipment!=null){

            Double its_after = predictedItsRepo.findByEquipmentAndDateAfterAndAndPlanNumber(equipment,dateTime,var).getIts();
            Double its_before =predictedItsRepo.findByEquipmentAndDateBeforeAndAndPlanNumber(equipment,dateTime,var).getIts();
            Double alpha= alphaService.getAlpha(equipment);
            Long dif = ChronoUnit.DAYS.between(lastFixDate,dateTime);
            for (Long i=1L;i<=dif;i++){
                Double p = 1 - (1-its_after/100)*its_before/its_after*Math.exp(-alpha*24*i);
                LocalDate date = lastFixDate.plusDays(i);
                resultMap.put(date,p);
                PredictedProbMeas prob = new PredictedProbMeas();
                prob.setDate(lastFixDate.plusDays(i));
                prob.setEquipment(equipment);
                prob.setPlanNumber(var);
                prob.setProbability(p);
                predictedProbRepo.save(prob);
            }
        }
        return resultMap;
    }
}
