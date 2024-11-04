package main;

public class SortAndMergeConcurrently {
    private int array[];

    public void setArray(int[] array) {
        this.array = array;
    }

    public void sortAndMergeUsingThreads() throws InterruptedException {
        if (array == null || array.length == 0) {
            return;
        }
        final var sortEven = new SortOddsOrEven(array, false);
        final var sortOdd = new SortOddsOrEven(array, true);

        final var thread1 = new Thread(sortEven);
        final var thread2 = new Thread(sortOdd);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        final var sortedEvenArray = sortEven.getSortedArray();
        final var sortedOddArray = sortOdd.getSortedArray();

        final var mergeArrays = new mergeArray(sortedEvenArray, sortedOddArray);
        final var thread3 = new Thread(mergeArrays);

        thread3.start();
        thread3.join();

        final var combinedArray = mergeArrays.getCombinedArray();

//        print all the 3 arrays

        System.out.println("Sorted Odd array");
        print(sortedOddArray);

        System.out.println("Sorted Even array");
        print(sortedEvenArray);

        System.out.println("Sorted combined array");
        print(combinedArray);
        System.out.println("-----------------------------------------------");
    }

    private void print(final int[] array) {
        for (final int num : array) {
            System.out.printf("%d, ", num);
        }
        System.out.println();
    }
}
