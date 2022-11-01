package com.example.demo.services;

import com.example.demo.entity.postgres.EquipmentEnt;
import com.example.demo.entity.postgres.ProbabilityEnt;
import com.example.demo.repositories.postgres.EquipTypeRepo;
import com.example.demo.repositories.postgres.EquipmentRepo;
import com.example.demo.repositories.postgres.PredictedItsRepo;
import com.example.demo.repositories.postgres.ProbabilityRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.logging.Logger;

@Service
public class CalculateP0Service {



    private final EquipmentRepo equipmentRepo;

    private final EquipTypeRepo equipTypeRepo;

    private final ItsMeasurementServ itsService;

    private final ProbabilityRepo probabilityRepo;
    private final PredictedItsRepo predictedItsRepo;



    public CalculateP0Service(EquipmentRepo equipmentRepo, EquipTypeRepo equipTypeRepo, ItsMeasurementServ itsService, ProbabilityRepo probabilityRepo, PredictedItsRepo predictedItsRepo) {
        this.equipmentRepo = equipmentRepo;
        this.equipTypeRepo = equipTypeRepo;
        this.itsService = itsService;
        this.probabilityRepo = probabilityRepo;
        this.predictedItsRepo = predictedItsRepo;
    }

    public Double calculateP0(Long id, LocalDateTime dateTime,Integer var){
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

    public Double calculateP0ForPredicted(EquipmentEnt equipment, Long version){
//        Double its_before= itsService.getOneItsBeforeDate(equipment.getId(),equipment.getLastFixionDate());
//        Double its_after= itsService.getOneItsAfterDate(equipment.getId(),equipment.getLastFixionDate());
//        Double p0=1-(1-its_after/100)*its_before/its_after;
        return null;
    }

    public Double calculatePForReal(EquipmentEnt equipment, LocalDateTime localDateTime){
        Double its_before= itsService.getOneItsBeforeDate(equipment.getId(),localDateTime);
        Double its= itsService.getItsByDate(equipment.getId(),localDateTime);
        Double p=null;
        if (its!=null && its_before!=null){
            p=(1-its/100)*its_before/its;
        }

        return p;
    }

    public void calcPForEquipment(Long equip_id, LocalDateTime date){
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
}
