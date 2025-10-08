// Full multithreading demonstration with detailed comments
// Learn: Thread basics, Runnable vs Thread, Sleep, Priority, Race Conditions, Thread States

// Import for AtomicInteger (used later for safe counter)
import java.util.concurrent.atomic.AtomicInteger;

class A extends Thread {
    // Extending Thread class
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Hi from Thread A");
            try {
                // Sleep pauses the current thread for the given milliseconds.
                // During this time, thread goes to TIMED_WAITING state.
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Thread A interrupted");
            }
        }
    }
}

// Runnable example (preferred way)
class B implements Runnable {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Hello from Runnable B");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Thread B interrupted");
            }
        }
    }
}

// Race condition example
class Counter {
    int count = 0;

    // Non-synchronized increment — unsafe (race condition)
    void increment() {
        count++;
    }

    // Synchronized increment — safe
    synchronized void safeIncrement() {
        count++;
    }
}

public class Demo {
    public static void main(String[] args) throws InterruptedException {

        // ========== 1. THREAD CREATION METHODS ==========

        // Method 1: Extending Thread class
        A t1 = new A();

        // Method 2: Implementing Runnable interface
        B objB = new B();
        Thread t2 = new Thread(objB);

        // Setting thread names
        t1.setName("Thread-A");
        t2.setName("Thread-B");

        // ========== 2. THREAD PRIORITY ==========
        // Priority range: 1 (MIN) to 10 (MAX)
        // Default priority = 5
        t1.setPriority(Thread.MAX_PRIORITY); // 10
        t2.setPriority(Thread.MIN_PRIORITY); // 1
        // Note: Priority is just a *hint* to the scheduler, not guaranteed.

        // ========== 3. THREAD STATES ==========
        // NEW → RUNNABLE → RUNNING → BLOCKED/WAITING → TERMINATED

        System.out.println(t1.getName() + " State: " + t1.getState()); // NEW
        System.out.println(t2.getName() + " State: " + t2.getState()); // NEW

        // Start both threads
        t1.start();
        t2.start();

        System.out.println(t1.getName() + " State after start: " + t1.getState());
        System.out.println(t2.getName() + " State after start: " + t2.getState());

        // Wait for threads to finish (join)
        t1.join(); // main thread waits for t1 to complete
        t2.join(); // main thread waits for t2 to complete

        System.out.println("Both threads finished!\n");

        // ========== 4. RACE CONDITION DEMONSTRATION ==========

        Counter counter = new Counter();

        // Two threads modifying same data (without synchronization)
        Thread r1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) counter.increment();
        });

        Thread r2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) counter.increment();
        });

        r1.start();
        r2.start();

        r1.join();
        r2.join();

        System.out.println("Without synchronization (expected 200000): " + counter.count);

        // ========== 5. FIXING RACE CONDITION ==========

        Counter safeCounter = new Counter();

        Thread r3 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) safeCounter.safeIncrement();
        });

        Thread r4 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) safeCounter.safeIncrement();
        });

        r3.start();
        r4.start();

        r3.join();
        r4.join();

        System.out.println("With synchronization (expected 200000): " + safeCounter.count);

        // ========== 6. USING ATOMIC VARIABLE (another fix) ==========

        AtomicInteger atomicCount = new AtomicInteger(0);

        Thread r5 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) atomicCount.incrementAndGet();
        });

        Thread r6 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) atomicCount.incrementAndGet();
        });

        r5.start();
        r6.start();

        r5.join();
        r6.join();

        System.out.println("Using AtomicInteger (expected 200000): " + atomicCount.get());

        // ========== 7. THREAD STATE MONITORING EXAMPLE ==========

        Thread monitor = new Thread(() -> {
            try {
                System.out.println("Monitor thread running...");
                Thread.sleep(200); // goes to TIMED_WAITING
                System.out.println("Monitor thread awake!");
            } catch (InterruptedException e) {
                System.out.println("Monitor interrupted");
            }
        });

        System.out.println("Monitor state before start: " + monitor.getState()); // NEW
        monitor.start();
        System.out.println("Monitor state after start: " + monitor.getState()); // RUNNABLE

        // Give it time to sleep
        Thread.sleep(50);
        System.out.println("Monitor state while sleeping: " + monitor.getState()); // TIMED_WAITING

        monitor.join();
        System.out.println("Monitor state after finish: " + monitor.getState()); // TERMINATED

        // ========== 8. MAIN THREAD ==========
        System.out.println("Main thread exiting!");
    }
}
