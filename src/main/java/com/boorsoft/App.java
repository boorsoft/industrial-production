package com.boorsoft;

import java.util.ArrayList;

import com.boorsoft.components.AccountHandler;
import com.boorsoft.components.AccountTypeHandler;
import com.boorsoft.components.menus.Menu;
import com.boorsoft.helpers.FileHandler;
import com.boorsoft.models.Person;
import com.boorsoft.models.AccountType;

public class App {
    public static void main(String[] args) throws Error {
        ArrayList<Person> accounts = new ArrayList<Person>();
        ArrayList<AccountType> accountTypes = new ArrayList<AccountType>();

        new AccountTypeHandler(accountTypes);
        new AccountHandler(accounts, accountTypes);

        FileHandler fileHandler = new FileHandler();
        fileHandler.init();

        Menu menu = new Menu(accounts, accountTypes);
        menu.displayStartingMessage();

    }
}
