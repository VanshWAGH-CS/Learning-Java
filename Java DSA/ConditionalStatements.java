import java.util.Scanner;

public class ConditionalStatements {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // int a = sc.nextInt();
        // int b = sc.nextInt();

        // if(age > 18){
        //     System.out.println("You are an adult.");
        // }else{
        //     System.out.println("not an adult");
        // }

        // if(x % 2 == 0){
        //     System.out.println("Even");
        // }else{
        //     System.out.println("Odd");
        // }

        // if(a == b){
        //     System.out.println("Equal");
        // }
        // else if(a > b){
        //     System.out.println("a is greater");
        // }else{
        //     System.out.println("a is lesser than b");
        // }

        int button = sc.nextInt();

        switch (button) {
            case 1:
                System.out.println("Hello");
                break;

            case 2:
                System.out.println("Namaste");
                break;
            
            case 3:
                System.out.println("banjour");
                break;
        
            default:
                System.out.println("Invalid button");
                break;
        }
        
    }
}
