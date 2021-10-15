package com.boorsoft.models;

import java.time.LocalDate;

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
}
