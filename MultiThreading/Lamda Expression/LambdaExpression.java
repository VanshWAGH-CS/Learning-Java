// File 3: LambdaExpression.java
// Demonstrates creating and running threads using lambda expressions.
public class LambdaExpression {
public static void main(String[] args) throws InterruptedException {
// Runnable is a functional interface with a single method run().
// We can implement it using a lambda instead of creating an anonymous class.
Runnable task = () -> {
// Code inside run() will execute in a separate thread.
for (int i = 1; i <= 5; i++) {
System.out.println(Thread.currentThread().getName() +
" is running iteration " + i);
try {
// Simulate some work with sleep.
Thread.sleep(500);
} catch (InterruptedException e) {
System.out.println(Thread.currentThread().getName() + " interrupted!");
return; // Exit if interrupted.
}
}
System.out.println(Thread.currentThread().getName() + " finished work.");
};


// Create two threads executing the same lambda task.
Thread t1 = new Thread(task, "Worker-1");
Thread t2 = new Thread(task, "Worker-2");


// Start both threads. They run concurrently with main thread.
t1.start();
t2.start();


// The main thread waits for both threads to finish.
t1.join();
t2.join();


System.out.println("Both worker threads completed.");


// Demonstrating use of Student interface with a lambda.
Student lambdaStudent = name -> name + " is an Engineering Student (via lambda)";
System.out.println(lambdaStudent.getBio("Vansh"));


// Also using the regular class implementation.
Student classStudent = new EngineeringStudent();
System.out.println(classStudent.getBio("Vansh"));
}
}


/*
Explanation of key concepts:
1. Runnable: A functional interface with a single run() method. Perfect for lambda.
2. Thread: Represents a separate path of execution. Pass a Runnable to its constructor.
3. start(): Begins execution of the thread; JVM calls run() internally.
4. join(): Causes the current thread (main) to wait until the specified thread completes.
5. Thread.sleep(ms): Pauses the current thread for the given time; may throw InterruptedException.
6. Lambda with Runnable makes code shorter and more readable than anonymous classes.
*/