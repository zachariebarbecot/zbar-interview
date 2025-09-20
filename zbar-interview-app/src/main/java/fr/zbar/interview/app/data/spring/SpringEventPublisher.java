package fr.zbar.interview.app.data.spring;

import fr.zbar.interview.app.data.exception.EventException;
import fr.zbar.interview.candidate.event.CandidateCreatedEvent;
import fr.zbar.interview.candidate.event.CandidateNotCreatedEvent;
import fr.zbar.interview.common.event.Event;
import fr.zbar.interview.common.event.EventPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SpringEventPublisher implements EventPublisher {

	private final ApplicationEventPublisher publisher;

	@Override
	public void publish(Event event) {
		publisher.publishEvent(event);
	}

	@EventListener
	public void on(CandidateCreatedEvent event) {
		log.info("Candidate {} is created", event.id().value());
	}

	@EventListener
	public void on(CandidateNotCreatedEvent event) {
		log.error("Candidate is not created: {}", event.message());
		throw new EventException(event.message(), event.cause());
	}
}
