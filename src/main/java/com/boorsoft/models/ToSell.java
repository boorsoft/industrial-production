package com.boorsoft.models;

import com.google.gson.Gson;

public class ToSell {
    public int id;
    public String title;
    public int price;
    public int amount;

    public ToSell(int id, String title, int price, int amount) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.amount = amount;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}
