package fr.zbar.interview.common.event;

import fr.zbar.interview.common.command.Command;
import fr.zbar.interview.common.command.CommandResponse;

public interface EventHandler<E extends Event> {

	void on(E event);
}
