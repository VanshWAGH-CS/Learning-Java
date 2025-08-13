import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // //output
        // System.out.println("Hello, world");
        // //this do not add a new line
        // //use println for this
        // System.out.println("Hello, world");

        // String name = "tony Stark";
        // int a = 25;
        // int b = 10;

        // int sum = a+b;
        // System.out.println(sum);

        // Scanner sc = new Scanner(System.in);
        // String name = sc.next();
        // System.out.println("your name is : " +name);

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b= sc.nextInt();

        int sum = a+b;
        System.out.println(sum);

    }
}

// Java is a types language
/*

    we need to give the type of the variable
    to make is allocate a space in the memory

    -> Primitive Data Types
    byte
    short
    char
    boolean
    int
    long
    float
    double

    ->Non primitive 
    String
    array
    class
    object
    interface

 */
