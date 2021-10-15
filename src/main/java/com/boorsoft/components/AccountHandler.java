package com.boorsoft.components;

import java.util.ArrayList;

import com.boorsoft.models.AccountType;
import com.boorsoft.models.Person;
import com.boorsoft.components.menus.ProviderMenu;
import com.boorsoft.helpers.Error;

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

    public static void checkAuth(ArrayList<Person> accounts, String username, String password) throws Error {
        boolean accountFound = false;

        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).username.equals(username) && accounts.get(i).password.equals(password)) {
                System.out.println("Logged in successfully.");
                accountFound = true;
                break;
            }
        }

        if (!accountFound) {
            throw new Error("Login failed");
        }
            
    }

    public static Object checkAccountType(int accountTypeInput, ArrayList<AccountType> accountTypes) {
        
        for (int i = 0; i < accountTypes.size(); i++) {
            if (accountTypeInput == 2) {
                return new ProviderMenu();
            } 
        }

        return 0;
    }
}
