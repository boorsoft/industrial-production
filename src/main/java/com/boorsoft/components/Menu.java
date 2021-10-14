package com.boorsoft.components;
import java.util.Scanner;

public class Menu {
    public void displayStartingMessage() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the club.");
        System.out.println("Enter your account type: ");
        int accountTypeInput = scanner.nextInt();
    }
}
