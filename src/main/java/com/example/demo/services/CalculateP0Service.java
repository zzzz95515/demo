package com.example.demo.services;

import com.example.demo.entity.postgres.EquipmentEnt;
import com.example.demo.repositories.postgres.EquipTypeRepo;
import com.example.demo.repositories.postgres.EquipmentRepo;
import com.example.demo.repositories.postgres.ItsMeasRepo;
import org.influxdb.InfluxDB;
import org.springframework.stereotype.Service;

@Service
public class CalculateP0Service {



    private final EquipmentRepo equipmentRepo;

    private final EquipTypeRepo equipTypeRepo;

    private final ItsMeasurementServ itsService;


    public CalculateP0Service(EquipmentRepo equipmentRepo, EquipTypeRepo equipTypeRepo, ItsMeasurementServ itsService) {
        this.equipmentRepo = equipmentRepo;
        this.equipTypeRepo = equipTypeRepo;
        this.itsService = itsService;
    }

    public Double calculateP0(EquipmentEnt equipment, Long version, InfluxDB influxDB){
        Double its_before= itsService.getOneItsBeforeDate(equipment.getId(),equipment.getLastFixionDate(),version,influxDB);
        Double its_after= itsService.getOneItsAfterDate(equipment.getId(),equipment.getLastFixionDate(),version,influxDB);
        Double p0=1-(1-its_after/100)*its_before/its_after;
        return p0;
    }
}
