public class Recursion1 {

    public static void printNumb(int n){
        if(n == 0)return;
        
        printNumb(n-1);
        System.out.println(n);
    }
    public static void main(String[] args){
        int n = 5;
        printNumb(n);
    }
}
