package com.boorsoft.models;

public class DeliveredProduct {
    public int id;
    public String title;
    public int amount;
    public int price;
    public String deliveryDate;

    public DeliveredProduct(int id, String title, int amount, int price, String deliverDate) {
        this.id = id;
        this.title = title;
        this.amount = amount; 
        this.price = price;
        this.deliveryDate = deliverDate;
    }
}
