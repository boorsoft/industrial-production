package com.boorsoft.components.menus;
import java.util.ArrayList;
import java.util.Scanner;

import com.boorsoft.models.AccountType;
import com.boorsoft.models.Person;
import com.boorsoft.components.AccountHandler;
import com.boorsoft.helpers.Error;

public class Menu {

    ArrayList<Person> accounts = new ArrayList<Person>();
    ArrayList<AccountType> accountTypes = new ArrayList<AccountType>();

    public Menu(ArrayList<Person> accounts, ArrayList<AccountType> accountTypes) {
        this.accounts = accounts;
        this.accountTypes = accountTypes;
    }

    public void displayStartingMessage() {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.println("Welcome to the club. \n");
            System.out.println("Enter your account type: ");
            System.out.println("1. Salesman \n2. Provider \n3. Deliver \n");

            System.out.print("\n>> ");
            int accountTypeInput = scanner.nextInt();

            switch(accountTypeInput) {
                case 1:
                    System.out.println("Welcome, dear salesman");
                    break;
                case 2:
                    System.out.println("Welcome, dear provider");
                    break;
                case 3:
                    System.out.println("Welcome, dear deliver");
                    break;
                default:
                    scanner.close();
                    throw new Error("No account type found.");
            }

            System.out.println("\nEnter your credentials.");
            System.out.print("\nLogin: ");

            String login = scanner.next();

            System.out.print("\nPassword: ");

            String password = scanner.next();

            AccountHandler.checkAuth(accounts, login, password);
            AccountHandler.checkAccountType(accountTypeInput, accountTypes);

            scanner.close();
        } catch (Error e) {
            System.out.println(e.getMessage());
        }
        
    }
}
