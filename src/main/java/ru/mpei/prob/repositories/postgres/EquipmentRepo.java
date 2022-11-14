package ru.mpei.prob.repositories.postgres;

import ru.mpei.prob.entity.postgres.EquipmentEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepo extends JpaRepository <EquipmentEnt,Long> {

}
