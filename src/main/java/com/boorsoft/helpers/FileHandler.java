package com.boorsoft.helpers;

import java.io.File; 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.boorsoft.models.GoodModel;
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
            System.out.println("No data found.");
            return new ArrayList<GoodModel>();
        } 

        return data;

    }
}
