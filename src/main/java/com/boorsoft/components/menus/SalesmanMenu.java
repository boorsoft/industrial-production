package com.boorsoft.components.menus;

import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

import com.boorsoft.helpers.Colors;
import com.boorsoft.helpers.Constants;
import com.boorsoft.helpers.FileHandler;
import com.boorsoft.models.SoldProduct;
import com.boorsoft.models.ToSell;
import com.boorsoft.models.GoodModel;

public class SalesmanMenu {
    
    ArrayList<ToSell> toSell;
    ArrayList<SoldProduct> sold; 
    ArrayList<GoodModel> goods;

    public SalesmanMenu() {
        try {
            toSell = FileHandler.getToSell();
            sold = FileHandler.getSold();
            goods = FileHandler.getGoods();
            display();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        } 
    }

    public void display() throws Error {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n1. Show the list of all materials to sell.\n2. Search for materials:\n1. by title\n2. by date");
        System.out.println("3. Show the sales report. \n4. Sell products: \n5. Order a product.");
        
        int salesmenMenuInput = scanner.nextInt();

        switch (salesmenMenuInput) {
            case 1: 
                Colors.colorizeLine("Id Title Price Amount", Colors.ANSI_BLUE);

                for (int i = 0; i < toSell.size(); i++) {
                    System.out.printf("%d %s %d %d", toSell.get(i).id, toSell.get(i).title, toSell.get(i).price, toSell.get(i).amount);
                }

                break;
            case 2:
                int searchInput = scanner.nextInt();

                if (searchInput == 1) {
                    System.out.println("Write title>> ");

                    String searchMaterialTitle = scanner.next();
                    for(int i = 0; i < toSell.size(); i++){
                        if (toSell.get(i).title.equals(searchMaterialTitle)){
                            Colors.colorizeLine("Id Title Price Amount", Colors.ANSI_BLUE);

                            System.out.printf("%d %s %d %d", toSell.get(i).id, toSell.get(i).title, toSell.get(i).price, toSell.get(i).amount);
                            
                        }else {
                            System.out.println("Good not found!");
                        }
                    }
                } else if (searchInput == 2) {
                    System.out.println("Write date>> ");
                    String searchMaterialDate = scanner.nextLine();

                    // for(int i = 0; i < toSell.size(); i++){
                    //     if (toSell.get(i)..equals(searchMaterialDate)){
                    //         Colors.colorizeLine("Id Title Price Amount", Colors.ANSI_BLUE);

                    //         System.out.printf("%d %s %d %d", toSell.get(i).id, toSell.get(i).title, toSell.get(i).price, toSell.get(i).amount);
                            
                    //     }else {
                    //         System.out.println("Good not found!");
                    //     }
                }

                break;
            default:
                scanner.close();
                throw new Error("No option exists.");
        }

        scanner.close();
    }
}