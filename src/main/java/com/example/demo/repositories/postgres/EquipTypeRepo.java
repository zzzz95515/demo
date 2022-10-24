package com.example.demo.repositories.postgres;

import com.example.demo.entity.postgres.EquipmentTypeEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipTypeRepo extends JpaRepository<EquipmentTypeEnt,Long> {

    EquipmentTypeEnt findByEquipmentType(String type);
}
