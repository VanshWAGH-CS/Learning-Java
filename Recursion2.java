public class Recursion2 {
    //summ of n numbers
    public static int solve(int n){
        if(n == 0)return 0;

        return n + solve(n-1);
    }
    public static void main(String args[]){
        int sum = solve(5);

        System.out.println(sum);
    }
}
