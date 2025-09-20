package fr.zbar.interview.candidate.model;

public record Experience(Integer value) {

	public Experience {
		if (value == null || value < 0) {
			throw new IllegalArgumentException("Experience cannot be null or negative");
		}
	}
}
