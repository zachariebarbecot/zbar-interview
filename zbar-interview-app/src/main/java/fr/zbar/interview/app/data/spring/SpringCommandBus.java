package fr.zbar.interview.app.data.spring;

import fr.zbar.interview.candidate.CreateCandidateCommandHandler;
import fr.zbar.interview.candidate.command.CreateCandidateCommand;
import fr.zbar.interview.common.command.Command;
import fr.zbar.interview.common.command.CommandBus;
import fr.zbar.interview.common.command.CommandHandler;
import fr.zbar.interview.common.command.CommandResponse;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class SpringCommandBus implements CommandBus {

	private final Map<Class<?>, CommandHandler<?, ?>> handlers;

	public SpringCommandBus(CreateCandidateCommandHandler createCandidateCommandHandler) {
		this.handlers = Map.of(
				CreateCandidateCommand.class, createCandidateCommandHandler
		);
	}

	@Override
	public <R extends CommandResponse, C extends Command> R send(C command) {
		@SuppressWarnings("unchecked")
		CommandHandler<C, R> handler = (CommandHandler<C, R>) handlers.get(command.getClass());
		return Optional.ofNullable(handler)
				.map(h -> h.handle(command))
				.orElseThrow(() -> new IllegalStateException("No handler found for command " + command.getClass()));
	}
}
