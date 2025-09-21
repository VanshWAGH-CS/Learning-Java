package Syncronisation;

public class Counter {

    private int count = 0; // shared resource accessed by multiple threads

    /*
     * Problem:
     * --------
     * If two threads call increment() at the same time,
     * they may both read the same 'count' value before either writes back,
     * causing a RACE CONDITION (final result is wrong).
     * 
     * Example of Race Condition:
     * --------------------------
     * Thread 1 reads count = 10
     * Thread 2 reads count = 10
     * Thread 1 adds 1 -> count = 11 (but not yet stored)
     * Thread 2 adds 1 -> count = 11 (overwrites Thread 1’s update!)
     * Expected: 12, Actual: 11  ❌
     */

    // SOLUTION:
    // Use 'synchronized' to allow ONLY ONE THREAD
    // to execute this method at a time for this object.
    public synchronized void increment() {
        count++; // critical section (shared data is updated)
    }

    // Getter to safely read the value of count
    public int getCount() {
        return count;
    }
}
