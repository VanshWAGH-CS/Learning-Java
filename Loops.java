import java.util.Scanner;

public class Loops {
    public static void main(String[] args){

        // for(int i =0; i < 100; i++){
        //     System.out.println(i);
        // }

        // int i = 0;

        // while(i < 11){
        //     System.out.println(i);
        //     if(i == 5)break;
        //     i++;
        // }

        // do{
        //     System.out.println(i);
        //     if(i == 5)break;
        //     i++;
        // }while(i < 11);

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        

        for(int i = 1; i < 11; i++){
            System.out.println(i*n);
        }

        
    }
}
