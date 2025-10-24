public class BinarySearchTree extends Tree {
    
    // Constructor
    public BinarySearchTree() {
        super();
    }
    
    // Insert a new node into the BST
    public void insert(int data) {
        root = insert(root, data);
    }
    
    private Node insert(Node node, int data) {
        // If the tree is empty, create a new node
        if (node == null) {
            return new Node(data);
        }
        
        // Otherwise, recur down the tree
        if (data < node.getData()) {
            node.setLeft(insert(node.getLeft(), data));
        } else if (data > node.getData()) {
            node.setRight(insert(node.getRight(), data));
        }
        // If data is equal, do nothing (no duplicates in BST)
        
        return node;
    }
    
    // Search for a value in BST (more efficient than general tree search)
    public boolean searchBST(int value) {
        return searchBST(root, value);
    }
    
    private boolean searchBST(Node node, int value) {
        if (node == null) {
            return false;
        }
        
        if (value == node.getData()) {
            return true;
        } else if (value < node.getData()) {
            return searchBST(node.getLeft(), value);
        } else {
            return searchBST(node.getRight(), value);
        }
    }
    
    // Delete a node from BST
    public void delete(int data) {
        root = delete(root, data);
    }
    
    private Node delete(Node node, int data) {
        if (node == null) {
            return null;
        }
        
        if (data < node.getData()) {
            node.setLeft(delete(node.getLeft(), data));
        } else if (data > node.getData()) {
            node.setRight(delete(node.getRight(), data));
        } else {
            // Node to be deleted found
            
            // Case 1: Node with only one child or no child
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }
            
            // Case 2: Node with two children
            // Get the inorder successor (smallest in the right subtree)
            node.setData(minValue(node.getRight()));
            
            // Delete the inorder successor
            node.setRight(delete(node.getRight(), node.getData()));
        }
        
        return node;
    }
    
    // Find minimum value in a subtree
    private int minValue(Node node) {
        int minValue = node.getData();
        while (node.getLeft() != null) {
            minValue = node.getLeft().getData();
            node = node.getLeft();
        }
        return minValue;
    }
    
    // Find maximum value in a subtree
    public int maxValue() {
        if (root == null) {
            throw new RuntimeException("Tree is empty");
        }
        return maxValue(root);
    }
    
    private int maxValue(Node node) {
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node.getData();
    }
    
    // Find minimum value in the entire tree
    public int minValue() {
        if (root == null) {
            throw new RuntimeException("Tree is empty");
        }
        return minValue(root);
    }
    
    // Check if the tree is a valid BST
    public boolean isValidBST() {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean isValidBST(Node node, int min, int max) {
        if (node == null) {
            return true;
        }
        
        if (node.getData() <= min || node.getData() >= max) {
            return false;
        }
        
        return isValidBST(node.getLeft(), min, node.getData()) &&
               isValidBST(node.getRight(), node.getData(), max);
    }
    
    // Find the kth smallest element
    public int kthSmallest(int k) {
        if (k <= 0 || k > countNodes()) {
            throw new IllegalArgumentException("Invalid k value");
        }
        
        int[] count = {0};
        int[] result = {-1};
        kthSmallest(root, k, count, result);
        return result[0];
    }
    
    private void kthSmallest(Node node, int k, int[] count, int[] result) {
        if (node == null) {
            return;
        }
        
        kthSmallest(node.getLeft(), k, count, result);
        count[0]++;
        if (count[0] == k) {
            result[0] = node.getData();
            return;
        }
        kthSmallest(node.getRight(), k, count, result);
    }
    
    // Find the kth largest element
    public int kthLargest(int k) {
        if (k <= 0 || k > countNodes()) {
            throw new IllegalArgumentException("Invalid k value");
        }
        
        int[] count = {0};
        int[] result = {-1};
        kthLargest(root, k, count, result);
        return result[0];
    }
    
    private void kthLargest(Node node, int k, int[] count, int[] result) {
        if (node == null) {
            return;
        }
        
        kthLargest(node.getRight(), k, count, result);
        count[0]++;
        if (count[0] == k) {
            result[0] = node.getData();
            return;
        }
        kthLargest(node.getLeft(), k, count, result);
    }
    
    // Get all elements in sorted order
    public java.util.List<Integer> getSortedElements() {
        java.util.List<Integer> elements = new java.util.ArrayList<>();
        inorderTraversal(root, elements);
        return elements;
    }
    
    private void inorderTraversal(Node node, java.util.List<Integer> elements) {
        if (node != null) {
            inorderTraversal(node.getLeft(), elements);
            elements.add(node.getData());
            inorderTraversal(node.getRight(), elements);
        }
    }
    
    // Range sum query
    public int rangeSum(int low, int high) {
        return rangeSum(root, low, high);
    }
    
    private int rangeSum(Node node, int low, int high) {
        if (node == null) {
            return 0;
        }
        
        int sum = 0;
        if (node.getData() >= low && node.getData() <= high) {
            sum += node.getData();
        }
        
        if (node.getData() > low) {
            sum += rangeSum(node.getLeft(), low, high);
        }
        
        if (node.getData() < high) {
            sum += rangeSum(node.getRight(), low, high);
        }
        
        return sum;
    }
}
