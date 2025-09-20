import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Stack;

public class QueueY {
    
    /**
     * DEEP EXPLANATION OF INTERFACES AND COLLECTIONS:
     * 
     * KEY CONCEPTS:
     * 1. Interface: A contract that defines what methods a class must implement
     * 2. Implementation: A concrete class that provides the actual method bodies
     * 3. Polymorphism: Using interface reference to refer to implementation objects
     * 4. Generics: Type-safe collections that prevent ClassCastException
     * 
     * WHY USE Queue<Integer> q = new LinkedList<>(); INSTEAD OF LinkedList<Integer> q = new LinkedList<>();?
     * - Loose coupling: Code depends on interface, not implementation
     * - Flexibility: Easy to switch implementations (LinkedList → ArrayDeque)
     * - Abstraction: Focus on what the object does, not how it does it
     */

    public static void main(String args[]){
        // =================================================================
        // ERROR RESOLUTION AND BASIC EXPLANATION
        // =================================================================
        
        // ERROR: Queue is an interface, cannot be instantiated directly
        // Queue q = new Queue();  // ❌ WRONG - Compilation error
        
        // CORRECT: Use a class that implements the Queue interface
        Queue<Integer> q = new LinkedList<>();  // ✅ CORRECT
        
        System.out.println("=== BASIC QUEUE OPERATIONS ===");
        
        // linkedList class hai but queue is an interface
        q.add(1);    // Adds element to the end of queue (throws exception if fails)
        q.add(0);
        q.add(4);
        q.offer(7);  // Adds element (returns false if fails - preferred method)

        System.out.println("Queue elements: " + q);
        System.out.println("Front element (peek): " + q.peek());
        System.out.println("Queue size: " + q.size());
        
        System.out.println("\nProcessing queue elements:");
        while(!q.isEmpty()){
            System.out.println("Front element: " + q.peek());
            System.out.println("Removed: " + q.remove());
            System.out.println("Remaining queue: " + q);
            System.out.println("---");
        }

        // =================================================================
        // DIFFERENT QUEUE IMPLEMENTATIONS
        // =================================================================
        
        System.out.println("\n=== DIFFERENT QUEUE IMPLEMENTATIONS ===");
        
        // 1. LinkedList Implementation (good for frequent insertions/deletions)
        Queue<String> linkedListQueue = new LinkedList<>();
        linkedListQueue.offer("First");
        linkedListQueue.offer("Second");
        linkedListQueue.offer("Third");
        System.out.println("LinkedList Queue: " + linkedListQueue);
        
        // 2. ArrayDeque Implementation (most efficient for queue operations)
        Queue<Integer> arrayDequeQueue = new ArrayDeque<>();
        arrayDequeQueue.offer(10);
        arrayDequeQueue.offer(20);
        arrayDequeQueue.offer(30);
        System.out.println("ArrayDeque Queue: " + arrayDequeQueue);
        
        // 3. PriorityQueue Implementation (elements ordered by priority)
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(30);
        priorityQueue.offer(10);
        priorityQueue.offer(20);
        System.out.println("PriorityQueue (not FIFO): " + priorityQueue);
        
        // =================================================================
        // INTERFACE VS IMPLEMENTATION DEMONSTRATION
        // =================================================================
        
        System.out.println("\n=== INTERFACE POLYMORPHISM ===");
        
        // Using interface reference - can switch implementations easily
        Queue<Double> interfaceQueue;
        
        // First implementation
        interfaceQueue = new LinkedList<>();
        interfaceQueue.offer(1.1);
        interfaceQueue.offer(2.2);
        System.out.println("LinkedList implementation: " + interfaceQueue);
        
        // Switch to different implementation - same interface methods!
        interfaceQueue = new ArrayDeque<>();
        interfaceQueue.offer(3.3);
        interfaceQueue.offer(4.4);
        System.out.println("ArrayDeque implementation: " + interfaceQueue);
        
        // =================================================================
        // QUEUE METHODS COMPARISON
        // =================================================================
        
        System.out.println("\n=== QUEUE METHOD COMPARISON ===");
        
        Queue<Character> charQueue = new LinkedList<>();
        
        // add() vs offer()
        charQueue.add('A');  // Throws exception if capacity restricted
        charQueue.offer('B'); // Returns false if capacity restricted (preferred)
        
        // remove() vs poll()
        System.out.println("remove(): " + charQueue.remove()); // Throws exception if empty
        System.out.println("poll(): " + charQueue.poll());     // Returns null if empty
        
        // element() vs peek()
        charQueue.offer('C');
        System.out.println("element(): " + charQueue.element()); // Throws exception if empty
        System.out.println("peek(): " + charQueue.peek());       // Returns null if empty
        
        // =================================================================
        // REAL-WORLD QUEUE APPLICATIONS
        // =================================================================
        
        System.out.println("\n=== REAL-WORLD APPLICATIONS ===");
        
        // 1. Breadth-First Search (BFS) simulation
        System.out.println("BFS Simulation:");
        Queue<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.offer(0); // Start from root
        
        while (!bfsQueue.isEmpty()) {
            int current = bfsQueue.poll();
            System.out.println("Visiting node: " + current);
            
            // Simulate adding child nodes
            if (current < 3) {
                bfsQueue.offer(current * 2 + 1);
                bfsQueue.offer(current * 2 + 2);
            }
        }
        
        // 2. Task scheduling simulation
        System.out.println("\nTask Scheduling Simulation:");
        Queue<String> taskQueue = new LinkedList<>();
        taskQueue.offer("Task1");
        taskQueue.offer("Task2");
        taskQueue.offer("Task3");
        
        while (!taskQueue.isEmpty()) {
            String task = taskQueue.poll();
            System.out.println("Executing: " + task);
            // Simulate task completion and adding new tasks
            if (task.equals("Task1")) {
                taskQueue.offer("Task1.1");
            }
        }
        
        // =================================================================
        // ADVANCED: QUEUE USING TWO STACKS (INTERVIEW FAVORITE)
        // =================================================================
        
        System.out.println("\n=== QUEUE USING TWO STACKS ===");
        
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        
        // Enqueue operation - always push to stack1
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        System.out.println("After enqueue: stack1 = " + stack1);
        
        // Dequeue operation - transfer to stack2 if needed
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        System.out.println("Dequeued: " + stack2.pop());
        System.out.println("Remaining: stack2 = " + stack2);
        
        // =================================================================
        // PERFORMANCE COMPARISON
        // =================================================================
        
        System.out.println("\n=== PERFORMANCE COMPARISON ===");
        
        int elements = 10000;
        
        // Test LinkedList
        long startTime = System.nanoTime();
        Queue<Integer> testQueue1 = new LinkedList<>();
        for (int i = 0; i < elements; i++) {
            testQueue1.offer(i);
        }
        for (int i = 0; i < elements; i++) {
            testQueue1.poll();
        }
        long linkedListTime = System.nanoTime() - startTime;
        
        // Test ArrayDeque
        startTime = System.nanoTime();
        Queue<Integer> testQueue2 = new ArrayDeque<>();
        for (int i = 0; i < elements; i++) {
            testQueue2.offer(i);
        }
        for (int i = 0; i < elements; i++) {
            testQueue2.poll();
        }
        long arrayDequeTime = System.nanoTime() - startTime;
        
        System.out.println("LinkedList time: " + linkedListTime/1000000.0 + " ms");
        System.out.println("ArrayDeque time: " + arrayDequeTime/1000000.0 + " ms");
        System.out.println("ArrayDeque is " + (linkedListTime/(double)arrayDequeTime) + "x faster");
        
        // =================================================================
        // BEST PRACTICES SUMMARY
        // =================================================================
        
        System.out.println("\n=== BEST PRACTICES ===");
        System.out.println("1. Use Queue<Integer> q = new LinkedList<>() instead of LinkedList<Integer>");
        System.out.println("2. Prefer offer(), poll(), peek() over add(), remove(), element()");
        System.out.println("3. Use ArrayDeque for better performance in most cases");
        System.out.println("4. Use PriorityQueue when you need ordering");
        System.out.println("5. Always check isEmpty() before polling from queue");
    }
    
    /**
     * UTILITY METHOD: Reverse a queue using stack
     */
    public static <T> void reverseQueue(Queue<T> queue) {
        Stack<T> stack = new Stack<>();
        
        // Move all elements to stack (reverses order)
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }
        
        // Move back to queue (now reversed)
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
    }
    
    /**
     * UTILITY METHOD: Generate binary numbers using queue
     */
    public static void generateBinaryNumbers(int n) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");
        
        System.out.println("First " + n + " binary numbers:");
        for (int i = 0; i < n; i++) {
            String current = queue.poll();
            System.out.print(current + " ");
            
            queue.offer(current + "0");
            queue.offer(current + "1");
        }
        System.out.println();
    }
}