import java.util.ArrayList;

public class BST {
    
    // A Node of the Binary Search Tree
    static class Node {
        int data;     // Value of the node
        Node left;    // Left child (contains values smaller than current node)
        Node right;   // Right child (contains values greater than or equal to current node)

        // Constructor to create a new Node
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Insert a new value into the BST
    // Time Complexity: O(h) where h is height of tree (O(n) worst case, O(log n) average)
    public static Node insert(Node root, int val) {
        // Case 1: Tree is empty → create a new node
        if (root == null) {
            return new Node(val); // create and return new Node
        }

        // Case 2: Value is smaller than root → go to left subtree
        if (val < root.data) {
            root.left = insert(root.left, val); // Recursively insert in left subtree
        } 
        // Case 3: Value is greater than or equal → go to right subtree
        else {
            root.right = insert(root.right, val); // Recursively insert in right subtree
        }

        // Return the unchanged root node (only child pointers might be updated)
        return root;
    }

    // Inorder Traversal (Left → Root → Right)
    // This will print the BST values in sorted order
    // Time Complexity: O(n) where n is number of nodes
    public static void inorder(Node root) {
        if (root == null) {
            return; // Base case: empty subtree
        }
        inorder(root.left);        // Recursively visit left subtree
        System.out.print(root.data + " ");  // Visit and print current node
        inorder(root.right);       // Recursively visit right subtree
    }

    // Search for a key in the BST
    // Time Complexity: O(h) where h is height of tree
    public static boolean search(Node root, int key) {
        if (root == null) {
            return false; // Key not found
        }

        if (root.data > key) {
            // Key is smaller than current node → search in left subtree
            return search(root.left, key);
        } else if (root.data < key) {
            // Key is larger than current node → search in right subtree
            return search(root.right, key);
        } else {
            // Key matches current node → found!
            return true;
        }
    }

    // Delete a node with given value from BST
    // Time Complexity: O(h) where h is height of tree
    public static Node delete(Node root, int val) {
        if (root == null) {
            return null; // Value not found, nothing to delete
        }
        
        if (root.data > val) {
            // Value to delete is smaller → go to left subtree
            root.left = delete(root.left, val);
        } else if (root.data < val) {
            // Value to delete is larger → go to right subtree
            root.right = delete(root.right, val);
        } else {
            // root.data == val → found the node to delete
            
            // Case 1: Leaf node (no children)
            if (root.left == null && root.right == null) {
                return null; // Simply remove the node
            }
            
            // Case 2: Node with one child
            if (root.left == null) {
                return root.right; // Replace with right child
            } else if (root.right == null) {
                return root.left;  // Replace with left child
            }

            // Case 3: Node with two children
            // Find inorder successor (smallest node in right subtree)
            Node IS = inorderSuccessor(root.right);
            // Copy inorder successor's data to current node
            root.data = IS.data;
            // Delete the inorder successor from right subtree
            root.right = delete(root.right, IS.data);
        }
        
        return root; // Return the modified tree
    }

    // Find the inorder successor (leftmost node in a subtree)
    // Inorder successor is the smallest value in the right subtree
    private static Node inorderSuccessor(Node root) {
        // Keep going left until we find the leftmost node
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Print all nodes in the BST that fall within the range [X, Y]
    // Uses inorder traversal to print in sorted order
    // Time Complexity: O(n) in worst case
    public static void printInRange(Node root, int X, int Y) {
        if (root == null) {
            return; // Base case: empty tree
        }
        
        // If current node is within range, process both subtrees
        if (root.data >= X && root.data <= Y) {
            printInRange(root.left, X, Y);    // Check left subtree
            System.out.print(root.data + " "); // Print current node
            printInRange(root.right, X, Y);   // Check right subtree
        }
        // If current node is greater than Y, only check left subtree
        else if (root.data > Y) {
            printInRange(root.left, X, Y);
        }
        // If current node is smaller than X, only check right subtree
        else {
            printInRange(root.right, X, Y);
        }
    }

    // Print all root-to-leaf paths in the BST
    // Uses backtracking to build and print paths
    // Time Complexity: O(n) for each path
    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return; // Base case: empty tree
        }

        path.add(root.data); // Add current node to path

        if (root.left == null && root.right == null) {
            // Leaf node reached → print the complete path
            System.out.println(path);
        } else {
            // Continue building path in both subtrees
            printRoot2Leaf(root.left, path);
            printRoot2Leaf(root.right, path);
        }

        // Backtrack: remove current node before returning to parent
        path.remove(path.size() - 1);
    }

    public static void main(String args[]) {
        int values[] = {5, 1, 2, 3, 2, 7}; // Values to insert into BST
        Node root = null;  // Start with an empty tree

        // Insert each value one by one into the BST
        for (int val : values) {
            root = insert(root, val);
        }

        // Print the BST using inorder traversal (sorted order)
        System.out.println("Inorder Traversal of BST:");
        inorder(root);
        System.out.println();

        // Search examples
        System.out.println("\nSearch results:");
        System.out.println("Search for 3: " + search(root, 3)); // Should be true
        System.out.println("Search for 10: " + search(root, 10)); // Should be false

        // Print in range example
        System.out.println("\nNodes in range [2, 5]:");
        printInRange(root, 2, 5);
        System.out.println();

        // Print root to leaf paths
        System.out.println("\nRoot to Leaf Paths:");
        printRoot2Leaf(root, new ArrayList<Integer>());

        // Delete example
        System.out.println("\nAfter deleting 3:");
        root = delete(root, 3);
        inorder(root);
        System.out.println();
    }
}