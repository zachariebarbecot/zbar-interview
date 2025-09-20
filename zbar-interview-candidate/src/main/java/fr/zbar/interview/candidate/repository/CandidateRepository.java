package fr.zbar.interview.candidate.repository;

import fr.zbar.interview.candidate.model.Candidate;

public interface CandidateRepository {

	void save(Candidate candidate);
}
