package fr.zbar.interview.candidate.event;

import fr.zbar.interview.common.Id;
import fr.zbar.interview.common.event.Event;

public record CandidateCreatedEvent(Id<?> id) implements Event {
}
