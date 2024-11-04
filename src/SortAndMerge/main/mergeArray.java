package main;

import java.util.Arrays;
import java.util.stream.IntStream;

public class mergeArray implements Runnable {
    private final int[] sortedEvenArray;
    private final int[] sortedOddArray;
    private int[] combinedArray;

    public mergeArray(int[] sortedEvenArray, int[] sortedOddArray) {
        this.sortedEvenArray = sortedEvenArray;
        this.sortedOddArray = sortedOddArray;
    }

    @Override
    public void run() {
        combinedArray = IntStream.concat(Arrays.stream(sortedEvenArray), Arrays.stream(sortedOddArray)).toArray();
    }

    public int[] getCombinedArray() {
        return combinedArray;
    }
}
