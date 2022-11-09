package com.example.demo.repositories.postgres;

import com.example.demo.entity.postgres.EquipmentEnt;
import com.example.demo.entity.postgres.ItsMeasurementsPostgresVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;


@Repository
public interface ItsMeasRepo extends JpaRepository<ItsMeasurementsPostgresVersion,Long> {
    ItsMeasurementsPostgresVersion getFirstByEquipmentIdAndMeasurmentDateBeforeOrderByMeasurmentDateDesc(Long equipmentId, LocalDate fixionDate);

    ItsMeasurementsPostgresVersion getFirstByEquipmentIdAndMeasurmentDateAfterOrderByMeasurmentDateAsc(Long equipmentId, LocalDate fixionDate);

    ItsMeasurementsPostgresVersion getFirstByEquipmentIdAndMeasurmentDateAfterOrderByMeasurmentDateDesc(Long equipmentId, LocalDate fixionDate);

    ItsMeasurementsPostgresVersion findByEquipmentIdAndMeasurmentDate(Long equipmentId,LocalDate dateTime);
}
