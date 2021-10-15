package com.boorsoft.helpers;
import java.io.File;  // Import the File class
import java.io.IOException;

public class FileHandler {


    public void init() {

        try {
            File goods = new File("src\\main\\java\\com\\boorsoft\\assets\\goods.json");
            if (goods.createNewFile()) System.out.println("File created.");
            else System.out.println("File already exists.");
        } catch(IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
        
    }

    public void writeFile(File file) {

    }
}
