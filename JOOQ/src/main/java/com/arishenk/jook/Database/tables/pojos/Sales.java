/*
 * This file is generated by jOOQ.
 */
package com.arishenk.jook.Database.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sales implements Serializable {

    private static final long serialVersionUID = 209133365;

    private final Integer id;
    private final String  cost;

    public Sales(Sales value) {
        this.id = value.id;
        this.cost = value.cost;
    }

    public Sales(
        Integer id,
        String  cost
    ) {
        this.id = id;
        this.cost = cost;
    }

    public Integer getId() {
        return this.id;
    }

    public String getCost() {
        return this.cost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Sales (");

        sb.append(id);
        sb.append(", ").append(cost);

        sb.append(")");
        return sb.toString();
    }
}
