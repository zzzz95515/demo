package com.example.demo.repositories.postgres;

import com.example.demo.entity.postgres.EquipmentEnt;
import com.example.demo.entity.postgres.ItsMeasurementsPostgresVersion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Date;

public interface ItsMeasRepo extends JpaRepository<ItsMeasurementsPostgresVersion,Long> {
    ItsMeasurementsPostgresVersion getFirstByEquipmentIdAndMeasurmentDateBeforeOrderByMeasurmentDateDesc(Long equipmentId, LocalDateTime fixionDate);

    ItsMeasurementsPostgresVersion getFirstByEquipmentIdAndMeasurmentDateAfterOrderByMeasurmentDateAsc(Long equipmentId, LocalDateTime fixionDate);

    ItsMeasurementsPostgresVersion getFirstByEquipmentIdAndMeasurmentDateAfterOrderByMeasurmentDateDesc(Long equipmentId, LocalDateTime fixionDate);

    ItsMeasurementsPostgresVersion findByEquipmentIdAndMeasurmentDate(Long equipmentId,LocalDateTime dateTime);
}
