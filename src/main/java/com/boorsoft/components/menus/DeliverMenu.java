package com.boorsoft.components.menus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.boorsoft.helpers.Constants;
import com.boorsoft.helpers.FileHandler;
import com.boorsoft.models.DeliveredProduct;
import com.boorsoft.models.GoodModel;
import com.boorsoft.models.ToSell;

public class DeliverMenu {
    ArrayList<GoodModel> goods;
    ArrayList<DeliveredProduct> delivered;
    ArrayList<ToSell> toSell;

    public DeliverMenu() {
        try {
            goods = FileHandler.getGoods();
            delivered = FileHandler.getDelivered();
            toSell = FileHandler.getToSell();

            Constants.getID();

            display();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void display() throws Error {
        Scanner scanner = new Scanner(System.in);

        System.out.println(
                "\n============================== DELIVER MENU ==============================");
        System.out.println("\n");
        System.out.println("1. Show the list of products to deliver \n2. Show the delivered orders");
        System.out.println(
                "3. Deliver order \n4. Show the list of delivered products \n5. Show the amount ordered products");
        System.out.println("6. Show my earnings \n7. Exit");

        int deliverMenuInput = scanner.nextInt();

        try {
            switch (deliverMenuInput) {
                case 1:
                    System.out.println("Id Title Amount Order Date Delivery Date \n \n");
                    for (int i = 0; i < goods.size(); i++) {
                        System.out.printf("%d %s %d %s %s \n", goods.get(i).id, goods.get(i).title, goods.get(i).amount,
                                goods.get(i).orderDate, goods.get(i).deliveryDate);
                    }
                    break;
                case 2:

                    for (DeliveredProduct dp : delivered) {
                        System.out.println("Id Title Amount Price Delivery Date \n");
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

                            System.out.println("Enter the price: ");
                            int priceInput = scanner.nextInt();

                            DeliveredProduct newDeliveredProduct = new DeliveredProduct(
                                    Constants.currentDeliveredID + 1, goods.get(i).title, goods.get(i).amount,
                                    priceInput,
                                    goods.get(i).deliveryDate);

                            delivered.add(newDeliveredProduct);

                            ToSell newToSell = new ToSell(Constants.currentDeliveredID + 1, goods.get(i).title,
                                    priceInput, goods.get(i).amount, goods.get(i).deliveryDate);

                            toSell.add(newToSell);

                            goods.remove(i);

                            FileHandler.saveGoods(goods);
                            FileHandler.saveDelivered(delivered);
                            FileHandler.saveToSell(toSell);

                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Product not found.");
                    }

                    break;
                case 4:
                    int productSum = 0;
                    for (int i = 0; i < delivered.size(); i++) {
                        productSum += delivered.get(i).amount;
                    }

                    System.out.println("The amount of products delivered " + productSum);

                    break;

                case 5:
                    int productSum2 = 0;
                    for (int i = 0; i < goods.size(); i++) {
                        productSum2 += goods.get(i).amount;
                    }
                    System.out.println("The amount of products ordered " + productSum2);
                    break;

                case 6:
                    int priceSum = 0;
                    for (int i = 0; i < delivered.size(); i++) {
                        priceSum += delivered.get(i).price;
                    }
                    System.out.println("The amount of money earned " + priceSum);
                    break;

                case 7:
                    System.out.println("Program is finished! Thank you for using our program");
                    break;
                default:
                    scanner.close();
                    throw new Error("No option exists.");

            }

            display();
            System.out.println("\n\n\n");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
