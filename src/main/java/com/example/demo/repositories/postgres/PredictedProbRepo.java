package com.example.demo.repositories.postgres;

import com.example.demo.entity.postgres.PredictedItsMeas;
import com.example.demo.entity.postgres.PredictedProbMeas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PredictedProbRepo extends JpaRepository<PredictedProbMeas, Long> {

}
