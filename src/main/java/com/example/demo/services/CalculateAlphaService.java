package com.example.demo.services;

import com.example.demo.entity.postgres.AlphaParamsEnt;
import com.example.demo.entity.postgres.EquipmentEnt;
import com.example.demo.repositories.postgres.AlphaRepo;
import org.influxdb.InfluxDB;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CalculateAlphaService {
    private final AlphaRepo alphaRepo;

    private final ItsMeasurementServ itsService;


    public CalculateAlphaService(AlphaRepo alphaRepo, ItsMeasurementServ itsService) {
        this.alphaRepo = alphaRepo;
        this.itsService = itsService;
    }

    public Double calcAlpha(EquipmentEnt equipment, Long version, InfluxDB influxDB){
        Date FixDate = equipment.getLastFixionDate();
        AlphaParamsEnt params = alphaRepo.findByEquipment(equipment);
        Double difIts= itsService.getDifferentialOfIts(equipment.getId(),equipment.getLastFixionDate(),version,influxDB);
        Double lastIts=itsService.getLastIts(equipment.getId(),equipment.getLastFixionDate(),version,influxDB);
        Double alpha = 0.0005;
        return alpha;
    }


}