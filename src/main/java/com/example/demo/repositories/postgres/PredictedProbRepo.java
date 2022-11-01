package com.example.demo.repositories.postgres;

import com.example.demo.entity.postgres.PredictedItsMeas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PredictedProbRepo extends JpaRepository<PredictedItsMeas, Long> {

}
