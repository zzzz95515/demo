package com.example.demo.repositories.postgres;

import com.example.demo.entity.postgres.EquipmentEnt;
import com.example.demo.entity.postgres.PredictedItsMeas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface PredictedItsRepo extends JpaRepository<PredictedItsMeas,Long> {
    PredictedItsMeas findByEquipmentAndPredDateAndPlanNumber(EquipmentEnt equip, LocalDate LocalDate, Integer planNumber);
    PredictedItsMeas getFirstByEquipmentAndPredDateAfterAndPlanNumberOrderByPredDateAsc(EquipmentEnt equip, LocalDate LocalDate, Integer planNumber);
    PredictedItsMeas getFirstByEquipmentAndPredDateBeforeAndPlanNumberOrderByPredDateDesc(EquipmentEnt equip, LocalDate LocalDate, Integer planNumber);

}
