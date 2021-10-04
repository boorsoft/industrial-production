package com.boorsoft.models;

public class Provider extends Person {
    Provider(int id, String username, String password, AccountType accountType) {
        super(id, username, password, accountType);
        this.id = id;
        this.username = username;
        this.password = password;
        this.accountType = accountType;
    }
}
