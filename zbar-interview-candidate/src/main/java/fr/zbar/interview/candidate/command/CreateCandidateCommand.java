package fr.zbar.interview.candidate.command;

import fr.zbar.interview.common.command.Command;

public record CreateCandidateCommand(String name, String email, String language, Integer experienceYears) implements Command {
}
