import java.util.Stack;

public class StackCF {

    public static void pushAtBottom(int data, Stack<Integer> s){

        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(data, s);
        s.push(top);
    }
    
    public static void main(String args[]){
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        int data = 5;

        pushAtBottom(data, s);

        // Printing elements in LIFO order
        while (!s.isEmpty()) {
            System.out.println(s.peek()); // check top
            s.pop(); // remove top
        }
    }
}
