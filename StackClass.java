/*
 * StackTutorial.java
 *
 * A detailed, well-commented tutorial file that shows:
 *  1) A linked-list-based generic stack implementation (LinkedListStack<T>)
 *  2) An array-backed generic stack with automatic resizing (ArrayStack<T>)
 *  3) Small example applications (balanced parentheses, reverse string)
 *
 * How to compile and run:
 *   javac StackTutorial.java
 *   java StackTutorial
 *
 * This file is intended to teach stacks step-by-step. Read the comments
 * inside each class to understand the theory and the Java-specific details.
 */

import java.util.EmptyStackException;
import java.util.Arrays;

public class StackClass {

    // ====================================================
    // Linked-list backed stack implementation (generic)
    // ====================================================
    // Important design choices shown here:
    //  - The stack is implemented as a singly-linked list with the head
    //    representing the top of the stack.
    //  - All operations (push, pop, peek, isEmpty, size) are O(1).
    //  - The implementation is instance-based (not static) so multiple
    //    stacks can exist at once.
    public static class LinkedListStack<T> {
        // Node is a private static nested class: it does not implicitly
        // capture the outer 'this' reference and keeps memory usage small.
        private static class Node<T> {
            T data;
            Node<T> next;
            Node(T data) { this.data = data; this.next = null; }
        }

        // 'head' points to the top item of the stack. 'size' tracks number
        // of elements so size() is O(1).
        private Node<T> head;
        private int size;

        // Create an empty stack
        public LinkedListStack() { head = null; size = 0; }

        // Check whether the stack is empty
        public boolean isEmpty() { return head == null; }

        // Return number of elements in the stack
        public int size() { return size; }

        // Push: insert an element at the head (top). Time complexity: O(1)
        public void push(T item) {
            Node<T> node = new Node<>(item);
            node.next = head;
            head = node;
            size++;
        }

        // Pop: remove and return the top element. If empty, throw
        // java.util.EmptyStackException (preferred over returning a sentinel
        // like -1, because the stack may legitimately contain -1).
        // Time: O(1)
        public T pop() {
            if (isEmpty()) throw new EmptyStackException();
            T top = head.data;
            head = head.next; // unlink popped node
            size--;
            return top;
        }

        // Peek: return the top element WITHOUT removing it. This must NOT
        // change the head or the size. Time: O(1)
        public T peek() {
            if (isEmpty()) throw new EmptyStackException();
            return head.data;
        }

        // Clear all elements references so GC can collect nodes.
        public void clear() {
            head = null;
            size = 0;
        }

        // Nicely formatted string (top ... bottom) for debugging/demo
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            Node<T> cur = head;
            while (cur != null) {
                sb.append(cur.data);
                cur = cur.next;
                if (cur != null) sb.append(", ");
            }
            sb.append("]");
            return sb.toString();
        }
    }


    // ====================================================
    // Array-backed stack implementation (generic)
    // with automatic resizing (doubling strategy)
    // ====================================================
    public static class ArrayStack<T> {
        private Object[] data; // can't create generic arrays; use Object[] and cast
        private int size;
        private static final int DEFAULT_CAPACITY = 10;

        public ArrayStack() { this(DEFAULT_CAPACITY); }
        public ArrayStack(int capacity) {
            if (capacity <= 0) capacity = DEFAULT_CAPACITY;
            data = new Object[capacity];
            size = 0;
        }

        public boolean isEmpty() { return size == 0; }
        public int size() { return size; }

        public void push(T item) {
            ensureCapacity(size + 1);
            data[size++] = item;
        }

        @SuppressWarnings("unchecked")
        public T pop() {
            if (isEmpty()) throw new EmptyStackException();
            T item = (T) data[--size];
            data[size] = null; // avoid memory leak by dropping reference
            return item;
        }

        @SuppressWarnings("unchecked")
        public T peek() {
            if (isEmpty()) throw new EmptyStackException();
            return (T) data[size - 1];
        }

        // Ensure array capacity using doubling strategy (amortized O(1) push)
        private void ensureCapacity(int minCapacity) {
            if (minCapacity > data.length) {
                int newCap = data.length * 2;
                if (newCap < minCapacity) newCap = minCapacity;
                data = Arrays.copyOf(data, newCap);
            }
        }

        public void clear() {
            Arrays.fill(data, 0, size, null);
            size = 0;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            // print top first for easier reading
            for (int i = size - 1; i >= 0; i--) {
                sb.append(data[i]);
                if (i > 0) sb.append(", ");
            }
            sb.append("]");
            return sb.toString();
        }
    }


    // ====================================================
    // Small stack-based applications to demonstrate usage
    //  - Balanced parentheses checker (common interview question)
    //  - Reverse a string using a stack
    // ====================================================

    // Balanced parentheses: supports (), [], {}
    public static boolean isBalanced(String s) {
        LinkedListStack<Character> st = new LinkedListStack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (st.isEmpty()) return false;
                char top = st.pop();
                if (!matches(top, ch)) return false;
            }
        }
        return st.isEmpty();
    }

    private static boolean matches(char open, char close) {
        return (open == '(' && close == ')')
            || (open == '[' && close == ']')
            || (open == '{' && close == '}');
    }

    // Reverse string using stack
    public static String reverseString(String s) {
        LinkedListStack<Character> st = new LinkedListStack<>();
        for (char c : s.toCharArray()) st.push(c);
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) sb.append(st.pop());
        return sb.toString();
    }


    // ====================================================
    // Main: demo runs
    // ====================================================
    public static void main(String[] args) {
        // LinkedListStack demo
        LinkedListStack<Integer> ls = new LinkedListStack<>();
        ls.push(1);
        ls.push(2);
        ls.push(3);
        System.out.println("LinkedListStack (top ... bottom): " + ls);
        System.out.println("peek: " + ls.peek());
        System.out.println("pop: " + ls.pop());
        System.out.println("after pop: " + ls);
        System.out.println("size: " + ls.size());
        System.out.println();

        // ArrayStack demo
        ArrayStack<String> as = new ArrayStack<>();
        as.push("apple");
        as.push("banana");
        as.push("cherry");
        System.out.println("ArrayStack (top ... bottom): " + as);
        System.out.println("peek: " + as.peek());
        System.out.println("pop: " + as.pop());
        System.out.println("after pop: " + as);
        System.out.println();

        // Applications
        String expr1 = "{[(())]}";
        System.out.println("isBalanced(\"{[(())]}\") = " + isBalanced(expr1));
        String s = "hello";
        System.out.println("reverseString(\"" + s + "\") = " + reverseString(s));
    }
}
