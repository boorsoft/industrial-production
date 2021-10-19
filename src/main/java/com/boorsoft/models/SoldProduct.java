package com.boorsoft.models;

import com.google.gson.Gson;

public class SoldProduct {
    public int id;
    public String title;
    public int price;
    public int amount;
    public String sellDate;

    public SoldProduct(int id, String title, int price, int amount, String sellDate) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.amount = amount;
        this.sellDate = sellDate;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}
