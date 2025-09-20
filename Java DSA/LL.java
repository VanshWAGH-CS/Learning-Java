public class LL {
    
    // HEAD POINTER: This is the MOST IMPORTANT concept in linked lists!
    // 'head' is a reference (pointer) that points to the first node in our list
    // In Java, we use references instead of actual pointers like in C++
    Node head;  // Initially null - represents an empty list
    private int size; // Optional: To keep track of the size of the list
    // INNER CLASS: Node represents each element in our linked list
    // Each node contains:
    // 1. Data (what we want to store)
    // 2. Reference to the next node (creates the "link" in linked list)
    
    LL() {
        this.size = 0;
    }
    
    class Node {
        String data;        // The actual data we're storing
        Node next;          // Reference to the next node (this creates the chain!)
        
        // CONSTRUCTOR: Creates a new node with given data
        Node(String data){
            this.data = data;
            this.next = null;   // New nodes initially don't point to anything
            size++;
        
        }
    }
    
    /*
     * ADD TO BEGINNING (addFirst)
     * Time Complexity: O(1) - Constant time! Very efficient!
     * 
     * WHY O(1)? Because we always know where the head is,
     * so we don't need to traverse the entire list
     */
    public void addFirst(String data){
        Node newNode = new Node(data);  // Create new node
        
        // CASE 1: Empty list
        if(head == null){
            head = newNode;             // Make new node the first (and only) node
            return;
        }
        
        // CASE 2: List has elements
        // Step 1: Connect new node to current first node
        newNode.next = head;           // New node points to old first node
        // Step 2: Update head to point to new node
        head = newNode;                // Now new node becomes the first node
        
        /* VISUAL REPRESENTATION:
         * Before: head -> [A] -> [B] -> null
         * After:  head -> [NEW] -> [A] -> [B] -> null
         */
    }
    
    /*
     * ADD TO END (addLast)
     * Time Complexity: O(n) - Linear time
     * 
     * WHY O(n)? We need to traverse the entire list to find the last node
     * This is slower than addFirst, but sometimes necessary
     */
    public void addLast(String data){
        Node newNode = new Node(data);  // Create new node
        
        // CASE 1: Empty list
        if(head == null){
            head = newNode;             // Same as addFirst for empty list
            return;
        }
        
        // CASE 2: List has elements - need to find the last node
        Node currNode = head;           // Start from the beginning
        
        // TRAVERSAL: Keep moving until we find the last node
        // Last node is identified by: node.next == null
        while(currNode.next != null){
            currNode = currNode.next;   // Move to next node
        }
        
        // Now currNode is pointing to the last node
        currNode.next = newNode;    // Connect last node to our new node
        size++;

        /* VISUAL REPRESENTATION:
         * Before: head -> [A] -> [B] -> null
         * After:  head -> [A] -> [B] -> [NEW] -> null
         */
    }
    
    /*
     * DELETE FIRST NODE
     * Time Complexity: O(1) - Constant time!
     * 
     * WHY O(1)? We just need to move the head pointer
     */
    public void deleteFirst(){
        // CASE 1: Empty list - nothing to delete
        if(head == null){
            System.out.println("Cannot delete from empty list");
            return;
        }
        
        // CASE 2: List has elements
        // Simply move head to the second node
        // Java's garbage collector will automatically clean up the old first node
        head = head.next;
        size--;
        
        /* VISUAL REPRESENTATION:
         * Before: head -> [A] -> [B] -> [C] -> null
         * After:  head --------> [B] -> [C] -> null
         * [A] gets garbage collected automatically
         */
    }
    
    /*
     * DELETE LAST NODE
     * Time Complexity: O(n) - Linear time
     * 
     * WHY O(n)? We need to find the second-to-last node to update its 'next' reference
     */
    public void deleteLast(){
        // CASE 1: Empty list
        if(head == null){
            System.out.println("Cannot delete from empty list");
            return;
        }
        
        // CASE 2: Only one node in list
        if(head.next == null){
            head = null;                // Remove the only node
            return;
        }
        
        // CASE 3: Multiple nodes - need to find second-to-last node
        Node secondLast = head;         // Will point to second-to-last node
        Node lastNode = head.next;      // Will point to last node
        
        // Traverse until lastNode reaches the actual last node
        while(lastNode.next != null){
            lastNode = lastNode.next;       // Move both pointers forward
            secondLast = secondLast.next;
        }
        
        // Now: secondLast points to second-to-last, lastNode points to last
        secondLast.next = null;         // Remove connection to last node
        size--;

        /* VISUAL REPRESENTATION:
         * Before: head -> [A] -> [B] -> [C] -> null
         * After:  head -> [A] -> [B] ----X    [C] gets garbage collected
         */
    }
    
    /*
     * DISPLAY THE LIST
     * Time Complexity: O(n) - Must visit every node
     */
    public void printList(){
        // CASE 1: Empty list
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        
        // CASE 2: List has elements - traverse and print each node
        Node currNode = head;           // Start from the beginning
        
        while(currNode != null){
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;   // Move to next node
        }
        System.out.println("null");     // Show end of list
    }
    
    /*
     * UTILITY METHOD: Get the size of the list
     * Time Complexity: O(n)
     */
    public int getSize(){
        if(head == null) return 0;
        
        int count = 0;
        Node currNode = head;
        while(currNode != null){
            count++;
            currNode = currNode.next;
        }
        return count;
    }
    
    /*
     * UTILITY METHOD: Search for an element
     * Time Complexity: O(n)
     */
    public boolean search(String data){
        Node currNode = head;
        while(currNode != null){
            if(currNode.data.equals(data)){
                return true;
            }
            currNode = currNode.next;
        }
        return false;
    }
    
    // MAIN METHOD: Testing our linked list
    public static void main(String args[]){
        LL list = new LL();
        
        System.out.println("=== LINKED LIST DEMONSTRATION ===\n");
        
        // Test adding elements
        System.out.println("1. Adding elements to the beginning:");
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");
        list.printList();  // Should print: A -> B -> C -> null
        
        System.out.println("\n2. Adding elements to the end:");
        list.addLast("D");
        list.addLast("E");
        list.printList();  // Should print: A -> B -> C -> D -> E -> null
        
        System.out.println("\n3. List size: " + list.getSize());
        
        System.out.println("\n4. Searching for elements:");
        System.out.println("Search for 'C': " + list.search("C"));  // true
        System.out.println("Search for 'X': " + list.search("X"));  // false
        
        System.out.println("\n5. Deleting first element:");
        list.deleteFirst();
        list.printList();  // Should print: B -> C -> D -> E -> null
        
        System.out.println("\n6. Deleting last element:");
        list.deleteLast();
        list.printList();  // Should print: B -> C -> D -> null
    }
}

/*
 * ======================================================================
 *                    KEY CONCEPTS EXPLAINED
 * ======================================================================
 * 
 * 1. WHY head.next INSTEAD OF -> (like in C++)?
 * 
 * In C++: 
 *   Node* ptr;
 *   ptr->next;        // Arrow operator for pointers
 *   (*ptr).next;      // Equivalent dot notation with dereference
 * 
 * In Java:
 *   Node ref;
 *   ref.next;         // Dot operator for object references
 * 
 * Java doesn't have explicit pointers like C++. Instead, it uses 
 * "references" which are automatically dereferenced. The dot operator (.)
 * is used to access members of objects through references.
 * 
 * 2. MEMORY MANAGEMENT:
 * 
 * C++: Manual memory management
 *   - You must explicitly delete nodes: delete ptr;
 *   - Risk of memory leaks if you forget
 * 
 * Java: Automatic garbage collection
 *   - When no references point to a node, it's automatically cleaned up
 *   - Much safer, but slightly less control over memory
 * 
 * 3. REFERENCES vs POINTERS:
 * 
 * Java References:
 *   - Cannot be null initially (must be explicitly set to null)
 *   - Cannot do pointer arithmetic (no ptr++ operations)
 *   - Automatically dereferenced
 *   - Safer and easier to use
 * 
 * C++ Pointers:
 *   - Can point to any memory location
 *   - Support arithmetic operations
 *   - Must be manually dereferenced
 *   - More powerful but more dangerous
 * 
 * 4. WHY LINKED LISTS?
 * 
 * Advantages:
 *   - Dynamic size (can grow/shrink during runtime)
 *   - Efficient insertion/deletion at beginning: O(1)
 *   - Memory efficient (allocate only what you need)
 * 
 * Disadvantages:
 *   - No random access (can't directly access element at index i)
 *   - Extra memory overhead for storing references
 *   - Cache performance issues (nodes may not be contiguous in memory)
 * 
 * 5. LINKED LIST vs ARRAY:
 * 
 * Array:
 *   - Fixed size (in most languages)
 *   - Random access: O(1)
 *   - Insertion/deletion in middle: O(n)
 *   - Better cache performance
 * 
 * Linked List:
 *   - Dynamic size
 *   - Sequential access only: O(n)
 *   - Insertion/deletion at beginning: O(1)
 *   - More memory overhead
 * 
 * ======================================================================
 */