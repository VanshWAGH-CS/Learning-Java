package Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {

    private final Lock lock = new ReentrantLock();

    public void outerMethod() {
        lock.lock(); // First acquisition
        try {
            System.out.println("Outer method");
            innerMethod(); // Calls another method that tries to lock again
        } finally {
            lock.unlock();
        }
    }

    public void innerMethod() {
        lock.lock(); // Same thread acquires the SAME lock again
        try {
            System.out.println("Inner method");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantExample example = new ReentrantExample();
        example.outerMethod();
    }
}
