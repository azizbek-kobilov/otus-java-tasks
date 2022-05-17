package com.kobilov.finalproject.app;


public class PriceInWords {
    static String getCurrency(int lastChar) {
        if (lastChar == 1) {
            return "рубль";
        } else if (lastChar == 2 || lastChar == 3 || lastChar == 4) {
            return "рубля";
        } else {
            return "рублей";
        }
    }
    public static String convert(String StrNumber) {
        try {
            long number = Long.parseLong(StrNumber);
            String answer = NumberToText.WordsRus(number);
            String currency = getCurrency((int) (number % 10));
            return answer + currency;
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            System.err.printf("The string value is not a number! %n");
        };
        return null;
    }
}
