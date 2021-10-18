package com.boorsoft.components.menus;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

import com.boorsoft.helpers.FileHandler;
import com.boorsoft.models.GoodModel;

public class ProviderMenu {
    ArrayList<GoodModel> data;

    public ProviderMenu() {
        try {
            data = FileHandler.getGoods();
            display();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }   
    }
    
    public void display() {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("1. Show the list of goods to be delivered \n2. Show the quantity of material supplied \n3. Show the material with the largest number of orders for delivery \n4. Show the material with the smallest number of orders for delivery \n5. Exit \n");
        System.out.println("Menu selection: >>>");
        int providerMenuInput = scanner.nextInt();
        
        scanner.close();
        switch(providerMenuInput){
            case 1:
                System.out.println();
                System.out.println("Id Title Amount Order Date Delivery Date");
                for (int i = 0; i < data.size(); i++) { 
                    System.out.printf("%d %s %d %s %s \n", data.get(i).id, data.get(i).title, data.get(i).amount, data.get(i).orderDate, data.get(i).deliveryDate);
                }    
                break;
            case 2:
                System.out.printf("\n The quantity of material supplied: %d", data.size());
                break;
            case 3:
                int maxIndex = 0;
                
                for (int i = 1; i < data.size(); i++) {
                    if (data.get(i).amount > data.get(maxIndex).amount) {
                        maxIndex = i;
                    }
                }

                System.out.println(data.get(maxIndex).title);
                break;
            case 4:
                int minIndex = 0;
                    
                for (int i = 1; i < data.size(); i++) {
                    if (data.get(i).amount < data.get(minIndex).amount) {
                        minIndex = i;
                    }
                }

                System.out.println(data.get(minIndex).title);
                break;
            case 5:
                break;
        }

    }
}
