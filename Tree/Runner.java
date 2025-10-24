public class Runner {
    public static void main(String[] args) {
        System.out.println("=== TREE DATA STRUCTURE IMPLEMENTATION ===\n");
        
        // Test 1: Basic Tree Operations
        testBasicTree();
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Test 2: Binary Search Tree Operations
        testBinarySearchTree();
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Test 3: Advanced BST Operations
        testAdvancedBST();
    }
    
    public static void testBasicTree() {
        System.out.println("1. BASIC TREE OPERATIONS");
        System.out.println("-".repeat(30));
        
        // Create a sample tree
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        Node root = new Node(1);
        root.setLeft(new Node(2));
        root.setRight(new Node(3));
        root.getLeft().setLeft(new Node(4));
        root.getLeft().setRight(new Node(5));
        
        Tree tree = new Tree(root);
        
        // Display tree structure
        tree.displayTree();
        
        // Test traversals
        tree.preorderTraversal();
        tree.inorderTraversal();
        tree.postorderTraversal();
        tree.levelOrderTraversal();
        
        // Test utility methods
        System.out.println("Height: " + tree.height());
        System.out.println("Total nodes: " + tree.countNodes());
        System.out.println("Leaf nodes: " + tree.countLeaves());
        System.out.println("Search for 3: " + tree.search(3));
        System.out.println("Search for 6: " + tree.search(6));
    }
    
    public static void testBinarySearchTree() {
        System.out.println("2. BINARY SEARCH TREE OPERATIONS");
        System.out.println("-".repeat(30));
        
        BinarySearchTree bst = new BinarySearchTree();
        
        // Insert elements
        int[] elements = {50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 45};
        System.out.print("Inserting elements: ");
        for (int element : elements) {
            System.out.print(element + " ");
            bst.insert(element);
        }
        System.out.println();
        
        // Display BST structure
        bst.displayTree();
        
        // Test traversals
        bst.preorderTraversal();
        bst.inorderTraversal();
        bst.postorderTraversal();
        bst.levelOrderTraversal();
        
        // Test BST-specific operations
        System.out.println("Is valid BST: " + bst.isValidBST());
        System.out.println("Min value: " + bst.minValue());
        System.out.println("Max value: " + bst.maxValue());
        
        // Test search
        System.out.println("Search for 40: " + bst.searchBST(40));
        System.out.println("Search for 100: " + bst.searchBST(100));
        
        // Test kth smallest/largest
        System.out.println("3rd smallest: " + bst.kthSmallest(3));
        System.out.println("2nd largest: " + bst.kthLargest(2));
        
        // Test sorted elements
        System.out.println("Sorted elements: " + bst.getSortedElements());
        
        // Test range sum
        System.out.println("Range sum [30, 60]: " + bst.rangeSum(30, 60));
    }
    
    public static void testAdvancedBST() {
        System.out.println("3. ADVANCED BST OPERATIONS");
        System.out.println("-".repeat(30));
        
        BinarySearchTree bst = new BinarySearchTree();
        
        // Insert elements
        int[] elements = {50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 45, 55, 65, 75, 85};
        System.out.print("Inserting elements: ");
        for (int element : elements) {
            System.out.print(element + " ");
            bst.insert(element);
        }
        System.out.println();
        
        System.out.println("Initial BST:");
        bst.displayTree();
        
        // Test deletion
        System.out.println("\nDeleting 20 (leaf node):");
        bst.delete(20);
        bst.displayTree();
        
        System.out.println("\nDeleting 30 (node with one child):");
        bst.delete(30);
        bst.displayTree();
        
        System.out.println("\nDeleting 70 (node with two children):");
        bst.delete(70);
        bst.displayTree();
        
        // Test after deletion
        System.out.println("\nAfter deletions:");
        bst.inorderTraversal();
        System.out.println("Height: " + bst.height());
        System.out.println("Total nodes: " + bst.countNodes());
        System.out.println("Is valid BST: " + bst.isValidBST());
    }
    
    // Utility method to demonstrate different tree types
    public static void demonstrateTreeTypes() {
        System.out.println("\n4. DIFFERENT TREE TYPES DEMONSTRATION");
        System.out.println("-".repeat(30));
        
        // Perfect Binary Tree
        System.out.println("Perfect Binary Tree:");
        BinarySearchTree perfectBST = new BinarySearchTree();
        int[] perfectElements = {4, 2, 6, 1, 3, 5, 7};
        for (int element : perfectElements) {
            perfectBST.insert(element);
        }
        perfectBST.displayTree();
        System.out.println("Height: " + perfectBST.height());
        
        // Skewed Tree (worst case for BST)
        System.out.println("\nSkewed Tree (worst case):");
        BinarySearchTree skewedBST = new BinarySearchTree();
        for (int i = 1; i <= 5; i++) {
            skewedBST.insert(i);
        }
        skewedBST.displayTree();
        System.out.println("Height: " + skewedBST.height());
    }
    
    // Performance comparison
    public static void performanceComparison() {
        System.out.println("\n5. PERFORMANCE COMPARISON");
        System.out.println("-".repeat(30));
        
        // Test search performance
        BinarySearchTree bst = new BinarySearchTree();
        
        // Insert 1000 random elements
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < 1000; i++) {
            int value = random.nextInt(10000);
            bst.insert(value);
        }
        
        // Create a general tree with same elements (for comparison)
        // Note: This is just for demonstration - general tree search is O(n)
        // while BST search is O(log n) on average
        
        long startTime = System.nanoTime();
        boolean found = bst.searchBST(5000);
        long endTime = System.nanoTime();
        
        System.out.println("BST search time: " + (endTime - startTime) + " nanoseconds");
        System.out.println("Search result: " + found);
    }
}