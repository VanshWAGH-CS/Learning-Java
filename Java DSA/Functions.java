import java.util.Scanner;

public class Functions {
    // public static void printMyName(String name){
    //     System.out.println(name);
    //     return;
    // }

    // public static int calculateSum(int a, int b){
    //     return a+b;
    // }

    public static void printFactorial(int n){
        //loop
        int factorial = 1;
        for(int i = n; i >= 1; i--){
            factorial *= i;
        }

        System.out.println(factorial);

        return;
    }

    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        // String name = sc.nextLine();
        // printMyName(name);

        // int a = sc.nextInt();
        // int b = sc.nextInt();

        // int sum = calculateSum(a, b);

        // System.out.println("sum: " + sum);

        int n = sc.nextInt();

        
        printFactorial(n);

    }
}
