package day2;

import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> unsorted = new ArrayList<>();

    public static void main(String[] args) {
        unsorted.add(2);
        unsorted.add(3);
        System.out.println("hi");
        MyOwnSort.selectionSort(1,2,4);
        MyOwnSort.selectionSort(unsorted);
    }
}
