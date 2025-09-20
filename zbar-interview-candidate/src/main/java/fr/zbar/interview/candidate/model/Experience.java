package fr.zbar.interview.candidate.model;

public record Experience(Integer numberOfYears) {

	public Experience {
		if (numberOfYears == null || numberOfYears < 0) {
			throw new IllegalArgumentException("Experience cannot be null or negative");
		}
	}
}
