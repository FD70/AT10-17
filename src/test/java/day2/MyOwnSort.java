package day2;

import java.util.ArrayList;

public class MyOwnSort {

    private static void printArray (ArrayList<Integer> list) {
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    private static void replaceTwo(ArrayList<Integer> list, int index1, int index2) {
        int temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    public static void selectionSort(ArrayList<Integer> list) {
        System.out.println("Before sort");
        printArray(list);

        for (int min = 0; min < list.size() ;min++) {
            for (int i = min + 1; i < list.size(); i++) {
                if (list.get(i) <  list.get(min)) {
                    replaceTwo(list, i, min);
                }
            }
        }

        System.out.println("After sort");
        printArray(list);
    }
}
