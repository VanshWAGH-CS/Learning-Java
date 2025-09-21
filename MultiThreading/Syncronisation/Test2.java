package Syncronisation;

public class Test2 {

    public static void main(String[] args) {
        Counter counter = new Counter(); // shared object

        // Two threads operating on the SAME Counter object
        MyThread2 t1 = new MyThread2(counter);
        MyThread2 t2 = new MyThread2(counter);

        t1.start(); // start first thread
        t2.start(); // start second thread

        try {
            // join() makes main thread wait until t1 and t2 finish
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*
         * Expected Output:
         * -----------------
         * Each thread increments 1000 times.
         * Total = 1000 + 1000 = 2000
         *
         * If synchronized is REMOVED, output may vary (e.g., 1500, 1800, etc.)
         * because of race conditions.
         */
        System.out.println(counter.getCount());
    }
}
