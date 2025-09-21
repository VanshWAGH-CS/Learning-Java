package Syncronisation;

public class MyThread2 extends Thread {
    private Counter counter; // reference to the shared Counter object

    // Constructor takes the shared Counter object
    public MyThread2(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        /*
         * Each thread will try to increment the shared 'count' 1000 times.
         * Without synchronization, both threads could interfere,
         * causing lost updates.
         */
        for (int i = 0; i < 1000; i++) {
            counter.increment(); // safe because increment() is synchronized
        }
    }
}
