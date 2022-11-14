package ru.mpei.prob.repositories.postgres;

import ru.mpei.prob.entity.postgres.EquipmentEnt;
import ru.mpei.prob.entity.postgres.PredictedItsMeas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.ConductingEquipment;

import java.time.LocalDate;

@Repository
public interface PredictedItsRepo extends JpaRepository<PredictedItsMeas,Long> {
    PredictedItsMeas findByEquipmentAndPredDateAndPlanNumber(ConductingEquipment equip, LocalDate LocalDate, Integer planNumber);
    PredictedItsMeas getFirstByEquipmentAndPredDateAfterAndPlanNumberOrderByPredDateAsc(ConductingEquipment equip, LocalDate LocalDate, Integer planNumber);
    PredictedItsMeas getFirstByEquipmentAndPredDateBeforeAndPlanNumberOrderByPredDateDesc(ConductingEquipment equip, LocalDate LocalDate, Integer planNumber);

}
