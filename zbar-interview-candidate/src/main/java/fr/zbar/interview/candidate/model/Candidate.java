package fr.zbar.interview.candidate.model;

import fr.zbar.interview.common.Id;

public record Candidate(Id<?> id, Name name, Email email, Language language, Experience experienceYears) {

	public Candidate(Id<?> id, String name, String email, String language, Integer experienceYears) {
		this(id, new Name(name), new Email(email), new Language(language), new Experience(experienceYears));
	}
}
