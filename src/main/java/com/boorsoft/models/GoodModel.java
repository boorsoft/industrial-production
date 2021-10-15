package com.boorsoft.models;

import java.time.LocalDate;
import com.google.gson.*;

public class GoodModel {
    int id;
    String title;
    int amount;
    LocalDate deliveryDate;
    LocalDate orderDate;

    public GoodModel(int id, String title, int amount, LocalDate deliveryDate, LocalDate orderDate) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.deliveryDate = deliveryDate;
        this.orderDate = orderDate;
    }

    String toJson() {
        return new Gson().toJson(this);
    }

    GoodModel fromJson(String good) {
        return new Gson().fromJson(good, GoodModel.class);
    }
}
