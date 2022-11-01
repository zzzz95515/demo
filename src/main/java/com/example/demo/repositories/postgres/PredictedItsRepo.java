package com.example.demo.repositories.postgres;

import com.example.demo.entity.postgres.EquipmentEnt;
import com.example.demo.entity.postgres.PredictedItsMeas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PredictedItsRepo extends JpaRepository<PredictedItsMeas,Long> {
    PredictedItsMeas findByEquipmentAndDateAAndPlanNumber(EquipmentEnt equip, LocalDateTime localDateTime,Integer planNumber);
    PredictedItsMeas findByEquipmentAndDateAfterAndAndPlanNumber(EquipmentEnt equip, LocalDateTime localDateTime, Integer planNumber);
    PredictedItsMeas findByEquipmentAndDateBeforeAndAndPlanNumber(EquipmentEnt equip, LocalDateTime localDateTime, Integer planNumber);
}
