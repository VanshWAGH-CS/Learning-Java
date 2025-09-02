import java.util.ArrayList;

public class StackUsingArrayList {
    
    // Inner class representing the Stack
    static class Stack {
        // We use ArrayList as the underlying storage
        private static ArrayList<Integer> list = new ArrayList<>();

        // Check if stack is empty
        public static boolean isEmpty() {
            return list.size() == 0; // or list.isEmpty()
        }

        // Push = add element to the end (top of stack)
        public static void push(int data) {
            list.add(data); // O(1) amortized
        }

        // Pop = remove and return the last element
        public static int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty!");
                return -1; // Sentinel value
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1); // O(1) amortized
            return top;
        }

        // Peek = return last element without removing
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty!");
                return -1;
            }
            return list.get(list.size() - 1);
        }
    }

    public static void main(String args[]) {
        Stack s = new Stack();

        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);

        // Printing elements in LIFO order
        while (!s.isEmpty()) {
            System.out.println(s.peek()); // check top
            s.pop(); // remove top
        }
    }
}
