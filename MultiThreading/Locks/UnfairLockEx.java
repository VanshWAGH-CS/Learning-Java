package Locks;

import java.util.concurrent.locks.ReentrantLock;

public class UnfairLockEx {

    public static void main(String[] args) {
        /*
         * new ReentrantLock(true)  -> Fair lock
         *      - Threads acquire lock in the order they requested it (FIFO).
         *
         * new ReentrantLock(false) -> Unfair lock (default)
         *      - Threads may "barge in", allowing a thread that just requested
         *        the lock to acquire it before others.
         *
         * Fair lock prevents starvation but is slightly slower.
         */
        ReentrantLock fairLock = new ReentrantLock(true);

        Runnable task = () -> {
            for (int i = 0; i < 3; i++) {
                fairLock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " acquired the lock");
                } finally {
                    fairLock.unlock();
                }
            }
        };

        for (int i = 1; i <= 3; i++) {
            new Thread(task, "Thread-" + i).start();
        }
    }
}
