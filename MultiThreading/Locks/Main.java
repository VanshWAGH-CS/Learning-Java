package Locks;

public class Main {
    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount(); // Shared BankAccount

        // A task that withdraws 50
        Runnable task = () -> bankAccount.withdraw(50);

        // Two threads using the SAME BankAccount object
        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}
