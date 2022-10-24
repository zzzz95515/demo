package com.example.demo.repositories.postgres;

import com.example.demo.entity.postgres.EquipmentEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepo extends JpaRepository <EquipmentEnt,Long> {

}
