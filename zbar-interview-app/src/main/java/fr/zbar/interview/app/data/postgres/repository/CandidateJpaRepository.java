package fr.zbar.interview.app.data.postgres.repository;

import fr.zbar.interview.app.data.postgres.entity.CandidateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateJpaRepository extends JpaRepository<CandidateEntity, Integer> {
}
