package com.boorsoft.components;

import java.util.ArrayList;

import com.boorsoft.models.AccountType;
import com.boorsoft.models.Person;

public class AccountHandler {

    ArrayList<Person> accounts = new ArrayList<Person>();
    ArrayList<AccountType> accountTypes = new ArrayList<AccountType>();

    public AccountHandler(ArrayList<Person> accounts, ArrayList<AccountType> accountTypes) {
        this.accounts = accounts;
        this.accountTypes = accountTypes;

        init();
    }

    public void init() {
        Person salesman = new Person(1, "salesman", "12345", accountTypes.get(0));
        Person provider = new Person(2, "provider", "77788", accountTypes.get(1));
        Person deliver = new Person(3, "deliver", "65123", accountTypes.get(2));

        accounts.add(salesman);
        accounts.add(provider);
        accounts.add(deliver);
    }
}
