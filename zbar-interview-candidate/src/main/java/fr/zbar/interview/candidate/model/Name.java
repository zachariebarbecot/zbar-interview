package fr.zbar.interview.candidate.model;

public record Name(String value) {

	public Name {
		if (value == null || value.isBlank()) {
			throw new IllegalArgumentException("Name cannot be null or blank");
		}
	}
}
