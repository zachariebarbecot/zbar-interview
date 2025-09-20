package fr.zbar.interview.candidate.event;

import fr.zbar.interview.common.event.Event;

public record CandidateNotCreatedEvent(String message, Throwable cause) implements Event {
}
