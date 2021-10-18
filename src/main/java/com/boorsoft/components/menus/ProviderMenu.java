package com.boorsoft.components.menus;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

import com.boorsoft.helpers.FileHandler;
import com.boorsoft.models.GoodModel;

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
                ArrayList<GoodModel> data = FileHandler.getGoods();
                
                System.out.println();
                System.out.println("Id Title Amount Order Date Delivery Date");
                for (int i = 0; i < data.size(); i++) { 
                    System.out.printf("%d %s %d %s %s \n", data.get(i).id, data.get(i).title, data.get(i).amount, data.get(i).orderDate, data.get(i).deliveryDate);
                }    
                
        }

    }
}
