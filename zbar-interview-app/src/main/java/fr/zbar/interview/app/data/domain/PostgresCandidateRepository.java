package fr.zbar.interview.app.data.domain;

import fr.zbar.interview.app.data.postgres.entity.CandidateEntity;
import fr.zbar.interview.app.data.postgres.repository.CandidateJpaRepository;
import fr.zbar.interview.candidate.model.Candidate;
import fr.zbar.interview.candidate.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostgresCandidateRepository implements CandidateRepository {

	private final CandidateJpaRepository candidateJpaRepository;

	@Override
	public void save(Candidate candidate) {
		var entity = new CandidateEntity();
		entity.reference(candidate.id().value().toString());
		entity.name(candidate.name().value());
		entity.email(candidate.email().value());
		entity.language(candidate.language().value());
		entity.experience(candidate.experienceYears().value());
		candidateJpaRepository.save(entity);
	}
}
