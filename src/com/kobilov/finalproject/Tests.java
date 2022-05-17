package com.kobilov.finalproject;

import com.kobilov.finalproject.app.*;

public class Tests {
    public static void main(String[] args) {
        PriceInWordsTest converterTester = new PriceInWordsTest();
        converterTester.test1();
        converterTester.test2();
        converterTester.test3();
    }
}

class PriceInWordsTest {
    public void test1() {
        String scenario = "1";
        try {
            final String actual = PriceInWords.convert("5");
            String expected = "пять рублей";
            Assertion.assertEquals(actual, expected);

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void test2() {
        String scenario = "2";
        try {
            final String actual = PriceInWords.convert("3");
            String expected = "три рубля";
            Assertion.assertEquals(actual, expected);

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void test3() {
        String scenario = "3";
        try {
            final String actual = PriceInWords.convert("45");
            String expected = "сорок пять рублей";
            Assertion.assertEquals(actual, expected);

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}

class Assertion {
    public static void assertEquals(String actual, String expected) {
        if (!expected.equals(actual)) {
            throw new AssertionError(String.format("Expected %s = %s", expected, actual));
        }
    }
}
