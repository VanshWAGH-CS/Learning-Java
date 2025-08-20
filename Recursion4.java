public class Recursion4 {

    // Function to calculate nth Fibonacci number
    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Function to print Fibonacci series till n terms
    public static void printFibonacciSeries(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    public static void main(String args[]) {
        int n = 10; // number of terms
        printFibonacciSeries(n);
    }
}
