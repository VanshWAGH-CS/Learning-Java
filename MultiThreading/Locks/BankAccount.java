package Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

public class BankAccount {

    private int balance = 100;                 // Shared resource
    private final Lock lock = new ReentrantLock(); // ReentrantLock provides explicit locking

    // Withdraw method with lock protection
    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);

        try {
            /*
             * tryLock(timeout, unit):
             * ----------------------
             * Tries to acquire the lock within the given time.
             * - Returns true if the lock was acquired.
             * - Returns false if the time expired.
             *
             * This prevents DEADLOCK because the thread will not wait forever.
             */
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                try {
                    // Critical Section: only one thread can be here at a time
                    if (balance >= amount) {
                        System.out.println(Thread.currentThread().getName() + " proceeding transaction...");
                        Thread.sleep(100); // Simulate transaction delay
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName()
                                + " completed transaction. New balance: " + balance);
                    } else {
                        System.out.println(Thread.currentThread().getName() + " insufficient balance!");
                    }
                } finally {
                    // Always unlock inside a finally block to avoid leaving the lock held
                    lock.unlock();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " could not acquire lock, try later.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + " was interrupted.");
        }
    }
}
