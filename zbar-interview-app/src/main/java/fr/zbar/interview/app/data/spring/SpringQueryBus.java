package fr.zbar.interview.app.data.spring;

import fr.zbar.interview.common.query.Query;
import fr.zbar.interview.common.query.QueryBus;
import fr.zbar.interview.common.query.QueryHandler;
import fr.zbar.interview.common.query.QueryResponse;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class SpringQueryBus implements QueryBus {

	private final Map<Class<?>, QueryHandler<?, ?>> handlers;

	public SpringQueryBus() {
		this.handlers = Map.of();
	}

	@Override
	public <R extends QueryResponse, Q extends Query> R ask(Q query) {
		@SuppressWarnings("unchecked")
		QueryHandler<Q, R> handler = (QueryHandler<Q, R>) handlers.get(query.getClass());
		return Optional.ofNullable(handler)
				.map(h -> h.handle(query))
				.orElseThrow(() -> new IllegalStateException("No handler found for query " + query.getClass()));
	}
}
