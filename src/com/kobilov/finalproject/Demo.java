package com.kobilov.finalproject;
import com.kobilov.finalproject.app.PriceInWords;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        System.out.println(PriceInWords.convert(value));
    }
}
