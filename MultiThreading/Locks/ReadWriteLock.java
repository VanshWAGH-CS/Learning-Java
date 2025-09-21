package Locks;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Minimal example showing how to create a ReadWriteLock.
 * (Not meant to run alone—used inside ReadWriteCounter.)
 */
public class ReadWriteLock {

    public static void main(String[] args) {
        // Create a ReadWriteLock
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

        // Acquire and release locks (dummy example)
        writeLock.lock();
        try {
            System.out.println("Writing data safely...");
        } finally {
            writeLock.unlock();
        }

        readLock.lock();
        try {
            System.out.println("Reading data safely...");
        } finally {
            readLock.unlock();
        }
    }
}
