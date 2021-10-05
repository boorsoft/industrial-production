package com.boorsoft.helpers;
import java.io.File;  // Import the File class
import java.io.IOException;

public class FileHandler {


    public void init() {
        try {
            File file = new File("../assets/Profiles.json");
            if (file.createNewFile()) System.out.println("File created.");
            else System.out.println("File already exists.");
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
