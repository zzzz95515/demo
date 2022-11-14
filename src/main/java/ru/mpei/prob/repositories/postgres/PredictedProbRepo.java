package ru.mpei.prob.repositories.postgres;

import ru.mpei.prob.entity.postgres.PredictedProbMeas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PredictedProbRepo extends JpaRepository<PredictedProbMeas, Long> {

}
