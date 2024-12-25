package ConcurrentThreadIncrement;

public class Counter {
    private int count;

    public synchronized void increment() {
        this.count ++;
    }

    public int getCount() {
        return this.count;
    }
}
