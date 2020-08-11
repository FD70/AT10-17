package day2;

import java.util.ArrayList;

public class Main {
    static ArrayList unsorted = new ArrayList();

    public static void main(String[] args) {
        unsorted.add(2);
        unsorted.add(3);
        System.out.println("hi");
        day2.MyOwnSort.selectionSort(1,2,4);
        day2.MyOwnSort.selectionSort(unsorted);
    }
}
