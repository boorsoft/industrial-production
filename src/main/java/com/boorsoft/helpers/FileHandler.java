package com.boorsoft.helpers;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class FileHandler {

    public void init() {

        try {
            File goods = new File(Constants.goodsPath);
            if (goods.createNewFile()) System.out.println("File created.");
            else System.out.println("File already exists.");
        } catch(IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
        
    }

    public static ArrayList<Object> readFile(File file) throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader(file));
        
        ArrayList<Object> data = new Gson().fromJson(reader, new ArrayList<Object>().getClass());

        return data;
    }
}
