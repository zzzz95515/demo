package com.example.demo.repositories.postgres;

import com.example.demo.entity.postgres.ItsMeasurementsPostgresVersion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface ItsMeasRepo extends JpaRepository<ItsMeasurementsPostgresVersion,Long> {
    ItsMeasurementsPostgresVersion getFirstByEquipmentIdAndMeasurmentDateBeforeOrderByMeasurmentDateDesc(Long equipmentId, Date fixionDate);

    ItsMeasurementsPostgresVersion getFirstByEquipmentIdAndMeasurmentDateAfterOrderByMeasurmentDateAsc(Long equipmentId, Date fixionDate);

    ItsMeasurementsPostgresVersion getFirstByEquipmentIdAndMeasurmentDateAfterOrderByMeasurmentDateDesc(Long equipmentId, Date fixionDate);
}
