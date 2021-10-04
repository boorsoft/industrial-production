package com.boorsoft.models;
import com.google.gson.*;

public class Person {
    int id;
    String username;
    String password;
    AccountType accountType;

    Person(int id, String username, String password, AccountType accountType) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.accountType = accountType;
    }

    String toJson() {
        return new Gson().toJson(this);
    }
}
