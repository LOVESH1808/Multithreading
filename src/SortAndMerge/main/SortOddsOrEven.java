package main;

import java.util.Arrays;

public class SortOddsOrEven implements Runnable {
    private final int[] array;
    private final boolean isOdd;
    private int[] sortedArray;

    public SortOddsOrEven(int[] array, boolean isOdd) {
        this.array = array;
        this.isOdd = isOdd;
    }

    @Override
    public void run() {
        sortedArray = Arrays.stream(array)
                .filter(isOdd ? (i -> i % 2 != 0) : (i -> i % 2 == 0))
                .sorted()
                .toArray();
    }

    public int[] getSortedArray() {
        return sortedArray;
    }
}
