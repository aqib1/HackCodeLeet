package com.hassan.jooq;

public class ConditionalList<N> {
    private Condition condition;
    private final N query;
    private ConditionalList<N> next;

    public ConditionalList(N query) {
        this.query = query;

    }

    public void next(N query, Condition condition) {
        this.next = new ConditionalList<>(query);
        this.condition = condition;
    }

}
