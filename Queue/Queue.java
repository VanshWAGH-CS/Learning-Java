public class Queue {
    
    private int[] queue;
    private int size;
    private int front;
    private int rear;
    private int capacity;

    // Constructor
    public Queue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = -1;
    }

    // Default constructor with capacity 5
    public Queue() {
        this(5);
    }

    // Add element to the rear of the queue
    public void enQueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full! Cannot add " + data);
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = data;
        size++;
        System.out.println("Added " + data + " to queue");
    }

    // Remove element from the front of the queue
    public int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return -1;
        }
        int data = queue[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println("Removed " + data + " from queue");
        return data;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Get the front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return queue[front];
    }

    // Get current size of the queue
    public int getSize() {
        return size;
    }

    // Get the capacity of the queue
    public int getCapacity() {
        return capacity;
    }

    // Display all elements in the queue
    public void show() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        
        System.out.print("Queue elements: ");
        int count = 0;
        int index = front;
        
        while (count < size) {
            System.out.print(queue[index] + " ");
            index = (index + 1) % capacity;
            count++;
        }
        System.out.println();
    }

    // Display queue with detailed information
    public void displayDetails() {
        System.out.println("=== Queue Details ===");
        System.out.println("Size: " + size + "/" + capacity);
        System.out.println("Front: " + front);
        System.out.println("Rear: " + rear);
        System.out.println("Empty: " + isEmpty());
        System.out.println("Full: " + isFull());
        if (!isEmpty()) {
            System.out.println("Front element: " + peek());
        }
        show();
        System.out.println("====================");
    }

    // Clear the queue
    public void clear() {
        size = 0;
        front = 0;
        rear = -1;
        System.out.println("Queue cleared!");
    }
}
