package com.arishenk;

public class Sale {

    private String[] items;
    private Double cost;

    public String toString(){
        return String.join(",", items) + " " + cost.toString();
    }

    public Sale(String[] items, Double cost) {
        this.cost = cost;
        this.items = items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    public String[] getItems() {
        return this.items;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getCost() {
        return this.cost;
    }
}