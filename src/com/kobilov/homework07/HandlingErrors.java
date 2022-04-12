package com.kobilov.homework07;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class HandlingErrors {
    public static void main(String[] args) throws Exception {
        File file = new File();
        file.open();

        InputString string = new InputString();
        string.input();
    }
}

class File {
    public void open() {
        try {
            FileInputStream file = new FileInputStream("test.txt");
            System.out.println("File found");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.out.println(e);
        }
    }
}

class InputString {
    public String input() throws Exception {
        String s = null;
        System.out.println("Enter string:");
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            s = reader.readLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (s.equals("")){
            throw new Exception ("String can not be empty!");
        }
        return s;
    }
}
