package com.example.demo.repositories.postgres;

import com.example.demo.entity.postgres.EquipmentEnt;
import com.example.demo.entity.postgres.ProbabilityEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;

@Repository
public interface ProbabilityRepo extends JpaRepository<ProbabilityEnt,Long> {

}
