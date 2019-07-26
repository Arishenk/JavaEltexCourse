package com.arishenk.entity;

import lombok.Getter;
import lombok.Setter;

public class Sale {

    @Getter
    @Setter
    private String[] items;

    @Getter
    @Setter
    private Double cost;

    public String toString(){
        return String.join(",", items) + " " + cost.toString();
    }

    public Sale(String[] items, Double cost) {
        this.cost = cost;
        this.items = items;
    }
}
