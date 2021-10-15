package com.boorsoft.components.menus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.boorsoft.helpers.Constants;
import com.boorsoft.helpers.FileHandler;

public class ProviderMenu {

    public ProviderMenu() {
        try {
            display();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public void display() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("1. Show the list of goods to be delivered \n2. Show the quantity of material supplied \n3. Show the material with the largest number of orders for delivery \n4. Show the material with the smallest number of orders for delivery \n5. Exit \n");
        System.out.println("Menu selection: >>>");
        int providerMenuInput = scanner.nextInt();
        
        scanner.close();
        switch(providerMenuInput){
            case 1:
                System.out.println(FileHandler.readFile(new File(Constants.goodsPath)));
        }

    }
}
