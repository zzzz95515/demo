package ru.mpei.prob.repositories.postgres;

import ru.mpei.prob.entity.postgres.ItsMeasurementsPostgresVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;


@Repository
public interface ItsMeasRepo extends JpaRepository<ItsMeasurementsPostgresVersion,Long> {
    ItsMeasurementsPostgresVersion getFirstByEquipmentIdAndMeasurmentDateBeforeOrderByMeasurmentDateDesc(String equipmentId, LocalDate fixionDate);

    ItsMeasurementsPostgresVersion getFirstByEquipmentIdAndMeasurmentDateAfterOrderByMeasurmentDateAsc(String equipmentId, LocalDate fixionDate);

    ItsMeasurementsPostgresVersion getFirstByEquipmentIdAndMeasurmentDateAfterOrderByMeasurmentDateDesc(String equipmentId, LocalDate fixionDate);

    ItsMeasurementsPostgresVersion findByEquipmentIdAndMeasurmentDate(String equipmentId,LocalDate dateTime);
}
