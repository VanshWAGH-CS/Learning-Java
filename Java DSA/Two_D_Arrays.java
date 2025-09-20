import java.util.Scanner;

public class Two_D_Arrays {
    public static void main(String args[]){
        int rows = 3;
        int cols = 3;
        int[][] array = new int[rows][cols];

        Scanner sc= new Scanner(System.in);

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                array[i][j] = sc.nextInt();
            }
        }

        System.out.println();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
