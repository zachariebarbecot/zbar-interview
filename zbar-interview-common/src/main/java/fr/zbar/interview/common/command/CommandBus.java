package fr.zbar.interview.common.command;

public interface CommandBus {
	<R extends CommandResponse, C extends Command> R send(C command);
}
