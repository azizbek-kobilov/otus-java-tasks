package com.kobilov.homework08;

import com.kobilov.homework08.game.*;

public class HomeWork {

    /*
        Заготовка для ДЗ представляет собой игру в кости.
        При вызове game.playGame(), два игрока кидают кости.
        Выигрывает игрок, у кого результат (1-6) больше

        Написать тесты (минимум 4) на классы DiceImpl и Game.
        Тесты должны найти не менее двух ошибок.

        Информацию о пройденном тесте предлагается выводить в System.out, а об упавшем в System.err
     */
    public static void main(String[] args) {
        new DiceImplTest().test();
        new GameTest().test();
        new GameTest().test2();
        new GameTest().test3();
    }
}

class DiceImplTest {
    private final DiceImpl dice = new DiceImpl();

    public void test() {
        String scenario = "1";
        try {
            int actual = dice.roll();
            boolean expected = actual > 0 && actual < 7;
            Assertion.assertEquals(true, expected);

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}

class GameTest {
    public void test() {
        final Player player = new Player("Aziz");
        final Dice dice = new DiceTest();
        final GameWinnerPrinter winnerPrinter = new GameWinnerPrinterTest(player);
        final Game game = new Game(dice, winnerPrinter);
        String scenario = "2";
        try {
            game.playGame(player, new Player("Игорь"));

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void test2() {
        final Player player = new Player("Aziz");
        final Dice dice = new DiceTest2();
        final GameWinnerPrinter winnerPrinter = new GameWinnerPrinterTest(player);
        final Game game = new Game(dice, winnerPrinter);
        String scenario = "3";
        try {
            game.playGame(player, new Player("Игорь"));

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void test3() {
        final Player player = new Player("Aziz");
        final Dice dice = null;
        final GameWinnerPrinter winnerPrinter = new GameWinnerPrinterTest(player);
        final Game game = new Game(dice, winnerPrinter);
        String scenario = "3";
        try {
            game.playGame(player, new Player("Игорь"));

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}

class DiceTest implements Dice {
    @Override
    public int roll() {
        return 1;
    }
}

class DiceTest2 implements Dice {
    int count = 0;
    @Override
    public int roll() {
        count++;
        if (count == 1){
            return 6;
        }
        else
            return 1;
    }
}

class GameWinnerPrinterTest implements GameWinnerPrinter {
    Player player;

    public GameWinnerPrinterTest(Player player) {
        this.player = player;
    }

    @Override
    public void printWinner(Player winner) {
        Assertion.assertEquals(player, winner);
    }
}

class Assertion {
    public static void assertEquals(boolean actual, boolean expected) {
        if (expected != actual) {
            throw new AssertionError(String.format("Expected %b = %b", expected, actual));
        }
    }

    public static void assertEquals(Player player, Player winner) {
        if (!player.equals(winner)) {
            throw new AssertionError(String.format("Expected %s = %s", winner.getName(), player.getName()));
        }
    }
}
