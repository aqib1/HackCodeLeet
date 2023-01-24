package com.hassan.jooq;

import java.util.*;

import static com.hassan.jooq.Condition.*;

public class SQLQuery {
    //((A & B) | C) & (B | C)
    public static void main(String[] args) {
        Query query1 = new Query(AND, Set.of("A", "B"));
        Query query2 = new Query(NONE, Set.of("C"));
        Query query3 = new Query(OR, Set.of("B", "C"));

        ConditionalList<Query> conditionalList = new ConditionalList<>(query1);
        conditionalList.next(query2, OR);
        conditionalList.next(query3, OR);


    }
}
