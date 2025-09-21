package Locks;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteCounter {

    private int count = 0;
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    // Readers can call this simultaneously
    public int getCount() {
        rwLock.readLock().lock();
        try {
            return count;
        } finally {
            rwLock.readLock().unlock();
        }
    }

    // Only one writer at a time
    public void increment() {
        rwLock.writeLock().lock();
        try {
            count++;
            System.out.println(Thread.currentThread().getName() + " incremented count to " + count);
        } finally {
            rwLock.writeLock().unlock();
        }
    }
}
