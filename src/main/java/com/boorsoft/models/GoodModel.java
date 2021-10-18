package com.boorsoft.models;

import com.google.gson.Gson;

public class GoodModel {
    public int id;
    public String title;
    public int amount;
    public String deliveryDate;
    public String orderDate;

    public GoodModel(int id, String title, int amount, String deliveryDate, String orderDate) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.deliveryDate = deliveryDate;
        this.orderDate = orderDate;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}
