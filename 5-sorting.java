import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorting {
    public static void main(String[] args) {
        List<Integer> randomList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            randomList.add(new Double(Math.random() * Integer.MAX_VALUE).intValue());
        }

        long startDate = System.currentTimeMillis();
        BubbleSorting.sort(randomList);
        long duration = System.currentTimeMillis() - startDate;
        System.out.println("My sort time = " + duration);

        randomList.clear();
        for (int i = 0; i < 10000; i++) {
            randomList.add(new Double(Math.random() * Integer.MAX_VALUE).intValue());
        }

        startDate = System.currentTimeMillis();
        Collections.sort(randomList);
        duration = System.currentTimeMillis() - startDate;
        System.out.println("System sort time = " + duration);
    }
}

class BubbleSorting {
    static void sort(List<Integer> array) {
        for (int i = 0; i < array.size() - 1; i++) {
            for (int j = array.size() - 1; j > i; j--) {
                if (array.get(j - 1) > array.get(j)) {
                    int tmp = array.get(j - 1);
                    array.set(j - 1, array.get(j));
                    array.set(j, tmp);
                }
            }
        }
    }
}
