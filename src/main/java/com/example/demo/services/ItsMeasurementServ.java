package com.example.demo.services;

import com.example.demo.entity.influx.ItsMeasurementsInflux;
import com.example.demo.entity.postgres.ItsMeasurementsPostgresVersion;
import com.example.demo.repositories.influx.ItsMeasRepo;
import org.influxdb.InfluxDB;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ItsMeasurementServ {
    private final ItsMeasRepo itsMeasRepo;

    public ItsMeasurementServ(ItsMeasRepo itsMeasRepo) {
        this.itsMeasRepo = itsMeasRepo;
    }

    public Double getOneItsBeforeDate(Long equipId, Date date, Long planId, InfluxDB influxDB){
        ItsMeasurementsInflux itsMeasurement = itsMeasRepo.getFirstByEquipmentIdAndMeasurmentDateBeforeOrderByMeasurmentDateDesc(equipId, date,planId,influxDB);
        return itsMeasurement.getIts();
    }

    public Double getOneItsAfterDate(Long equipId, Date date, Long planId, InfluxDB influxDB){
        ItsMeasurementsInflux itsMeasurement = itsMeasRepo.getFirstByEquipmentIdAndMeasurmentDateAfterOrderByMeasurmentDateAsc(equipId, date,planId,influxDB);
        return itsMeasurement.getIts();
    }

    public Double getDifferentialOfIts(Long equipId, Date date, Long planId, InfluxDB influxDB){
        ItsMeasurementsInflux lastIts = itsMeasRepo.getFirstByEquipmentIdAndMeasurmentDateAfterOrderByMeasurmentDateDesc(equipId, date,planId,influxDB);
        ItsMeasurementsInflux firstIts = itsMeasRepo.getFirstByEquipmentIdAndMeasurmentDateAfterOrderByMeasurmentDateAsc(equipId, date,planId,influxDB);
        Long difTime = (lastIts.getTime().toEpochMilli()-date.getTime())/(1000*60*60);
        Double difIts= lastIts.getIts()-firstIts.getIts();
        return difTime/difIts;
    }

    public Double getLastIts(Long equipId, Date date, Long planId, InfluxDB influxDB){
        return itsMeasRepo.getFirstByEquipmentIdAndMeasurmentDateAfterOrderByMeasurmentDateDesc(equipId, date,planId,influxDB).getIts();
    }
}
