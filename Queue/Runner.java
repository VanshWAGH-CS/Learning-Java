public class Runner {
    public static void main(String[] args) {
        System.out.println("=== Queue Implementation Demo ===\n");
        
        // Create a queue with default capacity (5)
        Queue queue = new Queue();
        
        // Demo 1: Basic operations
        System.out.println("1. Basic Queue Operations:");
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        queue.show();
        System.out.println("Front element: " + queue.peek());
        System.out.println("Queue size: " + queue.getSize());
        System.out.println();
        
        // Demo 2: Dequeue operations
        System.out.println("2. Dequeue Operations:");
        queue.deQueue();
        queue.show();
        queue.deQueue();
        queue.show();
        System.out.println();
        
        // Demo 3: Fill the queue to test full condition
        System.out.println("3. Testing Full Condition:");
        queue.enQueue(40);
        queue.enQueue(50);
        queue.enQueue(60);
        queue.enQueue(70); // This should fail - queue is full
        queue.show();
        System.out.println();
        
        // Demo 4: Circular queue behavior
        System.out.println("4. Circular Queue Behavior:");
        queue.deQueue(); // Remove one element
        queue.enQueue(80); // Add new element - should work now
        queue.show();
        System.out.println();
        
        // Demo 5: Empty queue operations
        System.out.println("5. Empty Queue Operations:");
        queue.clear();
        queue.deQueue(); // Should show error message
        queue.peek(); // Should show error message
        queue.show();
        System.out.println();
        
        // Demo 6: Custom capacity queue
        System.out.println("6. Custom Capacity Queue:");
        Queue customQueue = new Queue(3);
        customQueue.enQueue(100);
        customQueue.enQueue(200);
        customQueue.enQueue(300);
        customQueue.enQueue(400); // Should fail - queue is full
        customQueue.displayDetails();
        System.out.println();
        
        // Demo 7: Complete cycle demonstration
        System.out.println("7. Complete Cycle Demonstration:");
        Queue cycleQueue = new Queue(4);
        
        // Fill the queue
        for (int i = 1; i <= 4; i++) {
            cycleQueue.enQueue(i * 10);
        }
        cycleQueue.displayDetails();
        
        // Remove some elements
        cycleQueue.deQueue();
        cycleQueue.deQueue();
        cycleQueue.displayDetails();
        
        // Add more elements (circular behavior)
        cycleQueue.enQueue(50);
        cycleQueue.enQueue(60);
        cycleQueue.displayDetails();
        
        // Remove all elements
        while (!cycleQueue.isEmpty()) {
            cycleQueue.deQueue();
        }
        cycleQueue.displayDetails();
        
        System.out.println("=== Demo Complete ===");
    }
}
