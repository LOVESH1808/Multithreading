package ProducerConsumer;

import java.util.*;

public class ProducerConsumer {
    private static final int BUFFER_SIZE = 5;
    private static final Queue<Integer> buffer = new LinkedList<>();;

    public static void main(String[] args) {
        Thread producerThread = new Thread(new Producer());
        Thread consumerThread = new Thread(new Consumer());

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    static class Producer implements Runnable {
        @Override
        public void run() {
            int value = 0;
            while(true) {
                synchronized(buffer) {
                    while(buffer.size() == BUFFER_SIZE) {
                        try {
                            buffer.wait();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }

                    System.out.println("Producer Produced: " + value);
                    buffer.add(value ++);

//              Notify the consumer that an item is produced
                    buffer.notify();
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            while(true) {
                synchronized (buffer) {
                    while(buffer.isEmpty()) {
                        try {
                            buffer.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    int value = buffer.poll();
                    System.out.println("Consumer Consumed: " + value);

                    //notify that an item is consumed
                    buffer.notify();

                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
