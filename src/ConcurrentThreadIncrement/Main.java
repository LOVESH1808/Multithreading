package ConcurrentThreadIncrement;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        int numThreads = 6;

        int incrementPerThread = 1000;

        IncrementThread threads[] = new IncrementThread[numThreads];

        for(int i = 0; i < numThreads; i ++) {
            threads[i] = new IncrementThread(counter, incrementPerThread);
            threads[i].start();
        }

        try {
            for(IncrementThread thread : threads) {
                thread.join();
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Final count " + counter.getCount());
    }
}
