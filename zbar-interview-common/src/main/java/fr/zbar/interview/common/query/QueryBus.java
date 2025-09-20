package fr.zbar.interview.common.query;

public interface QueryBus {
	<R extends QueryResponse, Q extends Query> R ask(Q query);
}
