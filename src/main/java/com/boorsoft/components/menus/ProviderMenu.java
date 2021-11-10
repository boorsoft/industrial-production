package com.boorsoft.components.menus;

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
    
    public void display() throws Error {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n");
        System.out.printf("1. Show the list of goods to be delivered \n2. Show the quantity of material supplied \n3. Show the material with the largest number of orders for delivery \n4. Show the material with the smallest number of orders for delivery \n5. Exit \n");
        System.out.println("Menu selection: >>>");
        int providerMenuInput = scanner.nextInt();
        
        try {
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
                    int max = 0;
                    int maxAmountIndex = 0;

                    if (data.size() > 0) {
                        for (int i = 0; i < data.size(); i++) {
                            if (data.get(i).amount > max) {
                                max = data.get(i).amount;
                                maxAmountIndex++;
                            }
                        }

                        System.out.println(data.get(maxAmountIndex).title);
                    } else {
                        System.out.println("No data found.");
                    }
                    
                    break;
                case 4:
                    int minIndex = 0;
                    
                    if (data.size() > 0) {
                        for (int i = 1; i < data.size(); i++) {
                            if (data.get(i).amount < data.get(minIndex).amount) {
                                minIndex = i;
                            }
                        }

                        System.out.println(data.get(minIndex).title);
                    } else {
                        System.out.println("No data found.");
                    }
                    
                    break;
                case 5:
                    break;
                default:
                    scanner.close();
                    throw new Error("No option exists.");
            }
        } catch (Error e) {
            System.out.println(e.getMessage());
        }
        display();
    }
}
