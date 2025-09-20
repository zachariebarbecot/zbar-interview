package fr.zbar.interview.app.data.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class EventException extends RuntimeException {

	public EventException(String message, Throwable cause) {
		super(message, cause);
	}
}
