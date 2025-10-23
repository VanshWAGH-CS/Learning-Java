public class Stack {


    int stack[] = new int [10];
    int top = -1;

    public Stack(){
        // default capacity 10
    }

    public Stack(int capacity){
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.stack = new int[capacity];
    }

    public void push(int data){
        if (isFull()) {
            throw new IllegalStateException("Stack overflow: stack is full");
        }
        stack[++top] = data;
    }

    public int pop(){
        if (isEmpty()) {
            throw new IllegalStateException("Stack underflow: stack is empty");
        }
        int data = stack[top];
        stack[top] = 0; // optional: clear slot for display clarity
        top--;
        return data;
    }

    public int peek(){
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top];
    }

    public int size(){
        return top + 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == stack.length - 1;
    }

    public void clear(){
        for (int i = 0; i <= top; i++) {
            stack[i] = 0;
        }
        top = -1;
    }

    public void show(){
        if (isEmpty()) {
            System.out.println("[empty]");
            return;
        }
        System.out.print("Stack (bottom -> top): ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i]);
            if (i < top) System.out.print(", ");
        }
        System.out.println();
    }

}