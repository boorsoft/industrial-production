package com.boorsoft.components.menus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.boorsoft.helpers.Constants;
import com.boorsoft.helpers.FileHandler;
import com.boorsoft.models.DeliveredProduct;
import com.boorsoft.models.GoodModel;

public class DeliverMenu {
    ArrayList<GoodModel> goods;
    ArrayList<DeliveredProduct> delivered;

    public DeliverMenu() {
        try {
            goods = FileHandler.getGoods();
            delivered = FileHandler.getDelivered();

            Constants.getID();

            display();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        } 
    }

    public void display() throws Error {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Show the list of products to deliver \n2. Show the delivered orders");
        System.out.println("3. Deliver order \n4. Show the list of delivered products \n5. Show the amount ordered products");
        System.out.println("6. Show my earnings \n7. Exit");

        int deliverMenuInput = scanner.nextInt();

        try {
            switch(deliverMenuInput){
                case 1:
                    System.out.println("Id Title Amount Order Date Delivery Date");
                    for (int i = 0; i < goods.size(); i++) { 
                        System.out.printf("%d %s %d %s %s \n", goods.get(i).id, goods.get(i).title, goods.get(i).amount, goods.get(i).orderDate, goods.get(i).deliveryDate);
                    }    
                    break;
                case 2:
                    
                    for (DeliveredProduct dp: delivered) {
                        System.out.println("Id Title Amount Price Delivery Date");
                        System.out.printf("%d %s %d %d %s", dp.id, dp.title, dp.amount, dp.price, dp.deliveryDate);
                    }

                    break;
                case 3:
                    
                    System.out.println("Enter the product id >> ");
                    int idInput = scanner.nextInt();
                    
                    boolean found = false;

                    for (int i = 0; i < goods.size(); i++) {
                        if (goods.get(i).id == idInput) {
                            found = true;

                            DeliveredProduct newDeliveredProduct = new DeliveredProduct(Constants.currentDeliveredID + 1, goods.get(i).title, goods.get(i).amount, 5000, goods.get(i).deliveryDate);
                            
                            delivered.add(newDeliveredProduct);

                            goods.remove(i);

                            FileHandler.saveGoods(goods);
                            FileHandler.saveDelivered(delivered);
                            
                            break;
                        }
                    }

                    if (!found) {
                        scanner.close();
                        throw new Error("Product not found.");
                    }

                    break;

                default: 
                    scanner.close();
                    throw new Error("No option exists.");

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
