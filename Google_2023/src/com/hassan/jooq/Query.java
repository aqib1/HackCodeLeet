package com.hassan.jooq;

import java.util.Set;

public class Query {
    private Condition condition;
    private Set<String> values;

    public Query(Condition condition, Set<String> values) {
        this.condition = condition;
        this.values = values;
    }

    public Condition getConditions() {
        return condition;
    }

    public void setConditions(Condition condition) {
        this.condition = condition;
    }

    public Set<String> getValues() {
        return values;
    }

    public void setValues(Set<String> values) {
        this.values = values;
    }
}
