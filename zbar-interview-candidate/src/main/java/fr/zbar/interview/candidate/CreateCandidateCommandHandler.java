package fr.zbar.interview.candidate;

import fr.zbar.interview.candidate.command.CreateCandidateCommand;
import fr.zbar.interview.candidate.event.CandidateCreatedEvent;
import fr.zbar.interview.candidate.event.CandidateNotCreatedEvent;
import fr.zbar.interview.candidate.model.Candidate;
import fr.zbar.interview.candidate.repository.CandidateRepository;
import fr.zbar.interview.common.Id;
import fr.zbar.interview.common.IdGenerator;
import fr.zbar.interview.common.annotation.DomainService;
import fr.zbar.interview.common.command.CommandHandler;
import fr.zbar.interview.common.command.CommandResponse;
import fr.zbar.interview.common.event.EventPublisher;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@DomainService
public class CreateCandidateCommandHandler implements CommandHandler<CreateCandidateCommand, CommandResponse> {

	private final IdGenerator idGenerator;
	private final CandidateRepository candidateRepository;
	private final EventPublisher publisher;

	@Override
	public CommandResponse handle(CreateCandidateCommand command) {
		try {
			Candidate candidate = new Candidate(idGenerator.generate(), command.name(), command.email(), command.language(), command.experienceYears());
			candidateRepository.save(candidate);
			publisher.publish(new CandidateCreatedEvent(candidate.id()));
			return new CandidateCreated(candidate.id());
		} catch (Exception e) {
			publisher.publish(new CandidateNotCreatedEvent(e.getMessage(), e.getCause()));
			return new CandidateNotCreated();
		}
	}

	public record CandidateCreated(Id<?> id) implements CommandResponse {
	}

	public record CandidateNotCreated() implements CommandResponse {
	}
}
