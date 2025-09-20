package fr.zbar.interview.common.query;

public interface QueryHandler<Q extends Query, R extends QueryResponse> {

	R handle(Q query);
}
