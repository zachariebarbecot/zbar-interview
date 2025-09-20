package fr.zbar.interview.candidate.model;

public record Language(String value) {

	public Language {
		if (value == null || value.isBlank()) {
			throw new IllegalArgumentException("Language cannot be null or blank");
		}
	}
}
