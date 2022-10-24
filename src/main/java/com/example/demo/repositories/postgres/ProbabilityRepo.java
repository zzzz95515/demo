package com.example.demo.repositories.postgres;

import com.example.demo.entity.postgres.ProbabilityEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProbabilityRepo extends JpaRepository<ProbabilityEnt,Long> {
}
