package ru.mpei.prob.repositories.postgres;

import ru.mpei.prob.entity.postgres.ProbabilityEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProbabilityRepo extends JpaRepository<ProbabilityEnt,Long> {

}
