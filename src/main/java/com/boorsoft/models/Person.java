package com.boorsoft.models;
import com.google.gson.*;

public class Person {
    public int id;
    public String username;
    public String password;
    public AccountType accountType;

    public Person(int id, String username, String password, AccountType accountType) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.accountType = accountType;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}