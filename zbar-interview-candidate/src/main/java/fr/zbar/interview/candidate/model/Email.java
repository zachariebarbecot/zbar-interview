package fr.zbar.interview.candidate.model;

public record Email(String value) {

	public Email {
		if (value == null || value.isBlank()) {
			throw new IllegalArgumentException("Email cannot be null or blank");
		}
	}
}
