package com.boorsoft.components;
import java.util.ArrayList;
import java.util.Scanner;

import com.boorsoft.models.Person;

public class Menu {

    ArrayList<Person> accounts = new ArrayList<Person>();

    public Menu(ArrayList<Person> accounts) {
        this.accounts = accounts;
    }

    public void displayStartingMessage() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the club. \n");
        System.out.println("Enter your account type: ");
        System.out.printf("1. Salesman \n2. Provider \n3. Deliver \n");

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
                System.out.println("No account type found.");
        }

        System.out.println("\nEnter your credentials.");
        System.out.print("\nLogin: ");

        String login = scanner.next();

        System.out.print("\nPassword: ");

        String password = scanner.next();

        AccountHandler.checkAuth(accounts, login, password);

        scanner.close();
    }
}
