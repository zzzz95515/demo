package ru.mpei.prob.repositories.postgres;

import ru.mpei.prob.entity.postgres.EquipmentTypeEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipTypeRepo extends JpaRepository<EquipmentTypeEnt,Long> {

    EquipmentTypeEnt findByEquipmentType(String type);
}
