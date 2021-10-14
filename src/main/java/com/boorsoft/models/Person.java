package com.boorsoft.models;

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
}