package com.boorsoft.helpers;

import java.io.File; 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.boorsoft.models.GoodModel;
import com.boorsoft.models.SoldProduct;
import com.boorsoft.models.ToSell;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class FileHandler {

    public void init() {

        try {
            File goods = new File(Constants.goodsPath);
            File toSell = new File(Constants.toSellPath);
            File sold = new File(Constants.soldPath);

            if (goods.createNewFile() ||
                toSell.createNewFile() || 
                sold.createNewFile()) System.out.println("File created.");
            else System.out.println("File already exists.");

        } catch(IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
        
    }

    public static ArrayList<GoodModel> getGoods() throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader(Constants.goodsPath));

        Type objectsType = new TypeToken<ArrayList<GoodModel>>() {}.getType();

        ArrayList<GoodModel> data = new Gson().fromJson(reader, objectsType);

        if (data == null) {
            // System.out.println("No data found.");
            return new ArrayList<GoodModel>();
        } 

        return data;

    }

    public static ArrayList<ToSell> getToSell() throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader(Constants.toSellPath));

        Type objectsType = new TypeToken<ArrayList<ToSell>>() {}.getType();

        ArrayList<ToSell> data = new Gson().fromJson(reader, objectsType);

        if (data == null) {
            // System.out.println("No data found.");
            return new ArrayList<ToSell>();
        }

        return data;
    }

    public static ArrayList<SoldProduct> getSold() throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader(Constants.soldPath));

        Type objectsType = new TypeToken<ArrayList<SoldProduct>>() {}.getType();

        ArrayList<SoldProduct> data = new Gson().fromJson(reader, objectsType);

        if (data == null) {
            // System.out.println("No data found.");
            return new ArrayList<SoldProduct>();
        }

        return data;
    }

    public static void saveSoldProducts(ArrayList<SoldProduct> soldProducts) throws IOException {
        FileWriter fileWriter = new FileWriter(Constants.soldPath);
        fileWriter.write(new Gson().toJson(soldProducts, new TypeToken<ArrayList<SoldProduct>>() {}.getType()));
        fileWriter.close();
    }

    public static void saveToSell(ArrayList<ToSell> toSell) throws IOException {
        FileWriter fileWriter = new FileWriter(Constants.toSellPath);
        fileWriter.write(new Gson().toJson(toSell, new TypeToken<ArrayList<ToSell>>() {}.getType()));
        fileWriter.close();
    }

    public static void saveGoods(ArrayList<GoodModel> goods) throws IOException {
        FileWriter fileWriter = new FileWriter(Constants.goodsPath);
        fileWriter.write(new Gson().toJson(goods, new TypeToken<ArrayList<GoodModel>>() {}.getType()));
        fileWriter.close();
    }
}
    
