package com.kobilov.homework03;

import java.util.Scanner;

public class TestingSystem {
    public static void main(String[] args) {
        String[][] questions = {
                {"Сколько месяцев в году?", "1) 5", "2) 8", "3) 12", "3"},
                {"Сколько дней в неделе?", "1) 13", "2) 7", "3) 4", "2"},
                {"Сколько секунд в минуте?", "1) 60", "2) 35", "3) 22", "1"}
        };
        int rightAnswers = 0;
        int wrongAnswers = 0;

        for (String[] item : questions) {
            for (int i = 0; i < item.length - 1; i++) {
                System.out.println(item[i]);
            };
            System.out.println();
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            if (answer.equals(item[item.length - 1])) {
                rightAnswers++;
                System.out.println("Правильно!");
            } else {
                wrongAnswers++;
                System.out.println("Ошибка(");
            }
            System.out.println();
        }

        System.out.println("====== Ваш результат ======");
        System.out.println("Правильно: " + rightAnswers + "\nНеправильно: " + wrongAnswers);

    }
}
