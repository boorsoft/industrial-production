package com.boorsoft.components.menus;

import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

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

        System.out.println("\n1. Show the list of all materials to sell.\n2. Search for materials");
        System.out.println("3. Show the sales report. \n4. Sell products: \n5. Order a product.");
        
        int salesmenMenuInput = scanner.nextInt();

        switch (salesmenMenuInput) {
            case 1: 
                System.out.println("Id Title Price Amount");

                for (int i = 0; i < toSell.size(); i++) {
                    System.out.printf("%d %s %d %d", toSell.get(i).id, toSell.get(i).title, toSell.get(i).price, toSell.get(i).amount);
                }

                break;
            case 2:
                System.out.println("Choose an option to search by >>");
                System.out.println("\t \n1. by title\n2. by date");
                int searchInput = scanner.nextInt();

                if (searchInput == 1) {
                    System.out.println("Write title >> ");

                    String searchMaterialTitle = scanner.next();
                    for(int i = 0; i < toSell.size(); i++){
                        if (toSell.get(i).title.toLowerCase().startsWith(searchMaterialTitle.toLowerCase())){
                            System.out.println("Id Title Price Amount");

                            System.out.printf("%d %s %d %d", toSell.get(i).id, toSell.get(i).title, toSell.get(i).price, toSell.get(i).amount);
                            
                        } else {
                            System.out.println("Good not found!");
                        }
                    }
                } else if (searchInput == 2) {
                    System.out.println("Write date >> ");
                    String searchMaterialDate = scanner.next();

                    for(int i = 0; i < toSell.size(); i++){
                        if (toSell.get(i).date.equals(searchMaterialDate)){
                            System.out.println("Id Title Price Amount Date");

                            System.out.printf("%d %s %d %d", toSell.get(i).id, toSell.get(i).title, toSell.get(i).price, toSell.get(i).amount);
                            
                        }else {
                            System.out.println("Good not found!");
                        }
                    }
                }

                break;
            
            case 3:
                for (int i=0; i < sold.size(); i++){
                    System.out.println("Id Title Price Amount Sell Date");
                    System.out.printf("%d %s %d %d %s", sold.get(i).id, sold.get(i).title, sold.get(i).price, sold.get(i).amount, sold.get(i).sellDate);
                }
                break;
            
            case 4:
                System.out.println("Write product name >>");
                String toSellGoodName = scanner.next();
                System.out.println("Write amount to sell >> ");
                int toSellGoodAmount = scanner.nextInt();

                boolean removeProduct = false;
                
                for(int i = 0; i < toSell.size(); i++){
                    if (toSell.get(i).title.toLowerCase().startsWith(toSellGoodName.toLowerCase()) && toSell.get(i).amount > toSellGoodAmount){
                        toSell.get(i).amount = toSell.get(i).amount - toSellGoodAmount;
                        System.out.printf("%d %s %d %d", toSell.get(i).id, toSell.get(i).title, toSell.get(i).price, toSell.get(i).amount);
                    } else if (toSell.get(i).amount == toSellGoodAmount){
                        removeProduct = true;   
                    }

                    SoldProduct newSoldProduct = new SoldProduct(Constants.currentSoldID + 1, toSell.get(i).title, toSell.get(i).price, toSell.get(i).amount, Constants.currentDate);
                    sold.add(newSoldProduct);

                    if (removeProduct) {
                        toSell.remove(i);
                    }
                }

                break;

            default:
                scanner.close();
                throw new Error("No option exists.");
        }

        scanner.close();
    }
}