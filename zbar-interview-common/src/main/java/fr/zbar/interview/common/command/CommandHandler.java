package fr.zbar.interview.common.command;

public interface CommandHandler<C extends Command, R extends CommandResponse> {

	R handle(C command);
}
