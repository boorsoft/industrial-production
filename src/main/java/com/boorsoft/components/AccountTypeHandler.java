package com.boorsoft.components;

import java.util.ArrayList;

import com.boorsoft.models.AccountType;

public class AccountTypeHandler {
    ArrayList<AccountType> accountTypes = new ArrayList<AccountType>();

    public AccountTypeHandler(ArrayList<AccountType> accountTypes) {
        this.accountTypes = accountTypes;

        init();
    }

    public void init() {
        AccountType salesman = new AccountType(1, "Salesman");
        AccountType provider = new AccountType(2, "Provider");
        AccountType deliver = new AccountType(3, "Deliver");
        
        accountTypes.add(salesman);
        accountTypes.add(provider);
        accountTypes.add(deliver);

    }

}
