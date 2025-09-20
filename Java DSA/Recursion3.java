public class Recursion3 {

    public static int solveFactorial(int n){
        if(n == 0  || n == 1)return 1;

        return n * solveFactorial(n-1);
    }
    public static void main(String args[]){
        int fact = solveFactorial(5);

        System.out.println(fact);
    }
}
