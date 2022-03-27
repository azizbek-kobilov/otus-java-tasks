import java.util.Scanner;

public class OopTestingSystem {
    public static void main(String[] args) {
        String[][] test = {
                {"Сколько месяцев в году?", "1) 5", "2) 8", "3) 12", "3"},
                {"Сколько дней в неделе?", "1) 13", "2) 7", "3) 4", "2"},
                {"Сколько секунд в минуте?", "1) 60", "2) 35", "3) 22", "1"}
        };

        Question[] questions = new Question[3];
        for (int q = 0; q < test.length; q++) {

            Answer[] answers = new Answer[3];
            int iter = 0;
            for (int a = 1; a < 4; a++) {
                Answer answer = new Answer();
                answer.answer = test[q][a];
                answers[iter] = answer;
                iter++;
            }

            Question question = new Question();
            question.question = test[q][0];
            question.answers = answers;
            question.rightAnswer = test[q][4];

            questions[q] = question;
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
            System.out.println(questionsItem.question);

            for (Answer answersItem : questionsItem.answers) {
                System.out.println(answersItem.answer);
            }

            System.out.println();
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            if (answer.equals(questionsItem.rightAnswer)) {
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
    String question;
    Answer[] answers;
    String rightAnswer;
}

class Answer {
    String answer;
}
