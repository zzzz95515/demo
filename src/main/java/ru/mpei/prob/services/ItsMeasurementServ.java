package ru.mpei.prob.services;

import ru.mpei.prob.entity.postgres.ItsMeasurementsPostgresVersion;
import ru.mpei.prob.repositories.postgres.ItsMeasRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ItsMeasurementServ {
    private final ItsMeasRepo itsMeasRepo;

    public ItsMeasurementServ(ItsMeasRepo itsMeasRepo) {
        this.itsMeasRepo = itsMeasRepo;
    }

    public Double getOneItsBeforeDate(String equipId, LocalDate date){
        ItsMeasurementsPostgresVersion itsMeasurement = itsMeasRepo.getFirstByEquipmentIdAndMeasurmentDateBeforeOrderByMeasurmentDateDesc(equipId, date);
        return itsMeasurement.getIts();
    }

    public Double getOneItsAfterDate(String equipId, LocalDate date){
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

    public Double getLastIts(String equipId, LocalDate date){
        return itsMeasRepo.getFirstByEquipmentIdAndMeasurmentDateAfterOrderByMeasurmentDateDesc(equipId, date).getIts();
    }

    public Double getItsByDate(String eqipId, LocalDate date){
        return itsMeasRepo.findByEquipmentIdAndMeasurmentDate(eqipId,date).getIts();
    }
}
