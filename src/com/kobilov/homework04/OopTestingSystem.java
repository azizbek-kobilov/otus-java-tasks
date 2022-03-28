package com.kobilov.homework04;

import java.util.Scanner;

public class OopTestingSystem {
    public static void main(String[] args) {
        String[][] test = {
                {"Сколько месяцев в году?", "1) 5", "2) 8", "3) 12", "3"},
                {"Сколько дней в неделе?", "1) 13", "2) 7", "3) 4", "2"},
                {"Сколько секунд в минуте?", "1) 60", "2) 35", "3) 22", "1"}
        };

        Question[] questions = new Question[3];
        for (int i = 0; i < test.length; i++) {

            Answer[] answers = new Answer[3];
            int iter = 0;
            for (int j = 1; j < 4; j++) {
                Answer answer = new Answer();
                answer.setAnswer(test[i][j]);
                answers[iter] = answer;
                iter++;
            }

            Question question = new Question();
            question.setQuestion(test[i][0]);
            question.setAnswers(answers);
            question.setRightAnswer(test[i][4]);

            questions[i] = question;
        }

        Test simpleTest = new Test();
        simpleTest.questions = questions;
        simpleTest.run();
    }
}

class Test {
    private int rightAnswers = 0;
    private int wrongAnswers = 0;
    Question[] questions;

    void run() {
        for (Question questionsItem : questions) {
            System.out.println(questionsItem.getQuestion());

            for (Answer answersItem : questionsItem.getAnswers()) {
                System.out.println(answersItem.getAnswer());
            }

            System.out.println();
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            if (answer.equals(questionsItem.getRightAnswer())) {
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

class Question {
    private String question;
    private Answer[] answers;
    private String rightAnswer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer[] getAnswers() {
        return answers;
    }

    public void setAnswers(Answer[] answers) {
        this.answers = answers;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }
}

class Answer {
    private String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
