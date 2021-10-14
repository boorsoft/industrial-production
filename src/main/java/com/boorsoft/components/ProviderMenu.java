package com.boorsoft.components;

import java.util.Scanner;


public class ProviderMenu {
    
    public void providerMenu(){
        Scanner scanner = new Scanner(System.in);

        System.out.printf("1. Show the list of goods to be delivered \n2. Show the quantity of material supplied \n3. Show the material with the largest number of orders for delivery \n4. Show the material with the smallest number of orders for delivery \n5. Exit \n");
        System.out.println("Menu selection: >>>");
        int providerMenuInput = scanner.nextInt();

        // switch(providerMenuInput){
        //     case 1:

        // }

    }
}
