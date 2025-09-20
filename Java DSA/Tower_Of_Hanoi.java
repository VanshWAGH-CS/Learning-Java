public class Tower_Of_Hanoi {

    public static void towerOfHanoi(int n, String src, String dest, String helper) {
        // Base case
        if (n == 1) {
            System.out.println("Move disk 1 from " + src + " to " + dest);
            return;
        }
        
        // Move n-1 disks from source to helper
        towerOfHanoi(n - 1, src, helper, dest);
        
        // Move the nth disk from source to destination
        System.out.println("Move disk " + n + " from " + src + " to " + dest);
        
        // Move the n-1 disks from helper to destination
        towerOfHanoi(n - 1, helper, dest, src);
    }
    public static void main(String args[]){
        int n = 2;
        towerOfHanoi(n, "S", "D", "H");
    }
}
