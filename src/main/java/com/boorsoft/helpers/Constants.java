package com.boorsoft.helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Constants {
    public static String goodsPath = "src\\main\\java\\com\\boorsoft\\assets\\goods.json";
    public static String toSellPath = "src\\main\\java\\com\\boorsoft\\assets\\toSell.json";
    public static String soldPath = "src\\main\\java\\com\\boorsoft\\assets\\sold.json";
    public static String deliveredPath = "src\\main\\java\\com\\boorsoft\\assets\\delivered.json";

    public static int currentSoldID = 0;
    public static int currentToSellID = 0;
    public static int currentGoodID = 0;
    public static int currentDeliveredID = 0;

    public static DateTimeFormatter dTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static String currentDate = LocalDate.now().format(dTimeFormatter); 

    public static void getID() {
        try {
            currentSoldID = FileHandler.getSold().size();
            currentToSellID = FileHandler.getToSell().size();
            currentGoodID = FileHandler.getGoods().size();
            currentDeliveredID = FileHandler.getDelivered().size();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}