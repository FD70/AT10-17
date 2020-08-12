package day2;

import java.util.ArrayList;

public class Main {
    static int COUNT_OF_NUMBERS = 10;
    static int MAX_NUMBER = 42;
    static ArrayList<Integer> unsorted = new ArrayList<>();

    private static void fillArrayWithRandom(ArrayList<Integer> list, int count) {
        for (int i = 0; i < count; i++) {
            list.add((int) (Math.random() * MAX_NUMBER + 1));
        }
    }

    public static void main(String[] args) {
        fillArrayWithRandom(unsorted, COUNT_OF_NUMBERS);
        MyOwnSort.selectionSort(unsorted);
    }
}
