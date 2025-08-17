import java.util.Scanner;

public class Arrays {
    public static void main(String args[]){
        int[] marks = new int[5];

        // marks[0] = 87;
        // marks[1] = 14;
        // marks[2] = 85;
        // marks[3] = 86;
        // marks[4] = 88;

        Scanner sc = new Scanner(System.in);

        System.out.println("marks obtained are : ");

        for(int i = 0; i < marks.length; i++){
            marks[i] = sc.nextInt();
            System.out.println(marks[i]);
        }

        //by default 0 is stored in java
    }
}
