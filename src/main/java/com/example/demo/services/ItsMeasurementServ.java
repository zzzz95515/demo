package com.example.demo.services;

import com.example.demo.entity.postgres.ItsMeasurementsPostgresVersion;
import com.example.demo.repositories.postgres.ItsMeasRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class ItsMeasurementServ {
    private final ItsMeasRepo itsMeasRepo;

    public ItsMeasurementServ(ItsMeasRepo itsMeasRepo) {
        this.itsMeasRepo = itsMeasRepo;
    }

    public Double getOneItsBeforeDate(Long equipId, LocalDate date){
        ItsMeasurementsPostgresVersion itsMeasurement = itsMeasRepo.getFirstByEquipmentIdAndMeasurmentDateBeforeOrderByMeasurmentDateDesc(equipId, date);
        return itsMeasurement.getIts();
    }

    public Double getOneItsAfterDate(Long equipId, LocalDate date){
        ItsMeasurementsPostgresVersion itsMeasurement = itsMeasRepo.getFirstByEquipmentIdAndMeasurmentDateAfterOrderByMeasurmentDateAsc(equipId, date);
        return itsMeasurement.getIts();
    }

//    public Double getDifferentialOfIts(Long equipId, LocalDateTime date){
//        ItsMeasurementsPostgresVersion lastIts = itsMeasRepo.getFirstByEquipmentIdAndMeasurmentDateAfterOrderByMeasurmentDateDesc(equipId, date);
//        ItsMeasurementsPostgresVersion firstIts = itsMeasRepo.getFirstByEquipmentIdAndMeasurmentDateAfterOrderByMeasurmentDateAsc(equipId, date);
//        Long difTime = (lastIts.getMeasurmentDate().t-date.getTime())/(1000*60*60);
//        Double difIts= lastIts.getIts()-firstIts.getIts();
//        return difTime/difIts;
//    }

    public Double getLastIts(Long equipId, LocalDate date){
        return itsMeasRepo.getFirstByEquipmentIdAndMeasurmentDateAfterOrderByMeasurmentDateDesc(equipId, date).getIts();
    }

    public Double getItsByDate(Long eqipId, LocalDate date){
        return itsMeasRepo.findByEquipmentIdAndMeasurmentDate(eqipId,date).getIts();
    }
}
