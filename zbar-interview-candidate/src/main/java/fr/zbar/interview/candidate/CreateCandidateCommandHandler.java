package fr.zbar.interview.candidate;

import fr.zbar.interview.candidate.command.CreateCandidateCommand;
import fr.zbar.interview.candidate.model.Candidate;
import fr.zbar.interview.common.IdGenerator;
import fr.zbar.interview.common.annotation.DomainService;
import fr.zbar.interview.common.command.CommandHandler;
import fr.zbar.interview.common.command.CommandResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@DomainService
public class CreateCandidateCommandHandler implements CommandHandler<CreateCandidateCommand, CommandResponse> {

	private final IdGenerator idGenerator;

	@Override
	public CommandResponse handle(CreateCandidateCommand command) {
		try {
			Candidate candidate = new Candidate(idGenerator.generate(), command.name(), command.email(), command.language(), command.experienceYears());
			return new CandidateCreated(candidate);
		} catch (IllegalArgumentException e) {
			return new CandidateNotCreated();
		}
	}

	public record CandidateCreated(Candidate candidate) implements CommandResponse {
	}

	public record CandidateNotCreated() implements CommandResponse {
	}
}
