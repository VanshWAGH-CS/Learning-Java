public class Tree {
    protected Node root;
    
    // Constructor
    public Tree() {
        this.root = null;
    }
    
    // Constructor with root
    public Tree(Node root) {
        this.root = root;
    }
    
    // Getter and setter for root
    public Node getRoot() {
        return root;
    }
    
    public void setRoot(Node root) {
        this.root = root;
    }
    
    // Check if tree is empty
    public boolean isEmpty() {
        return root == null;
    }
    
    // PREORDER TRAVERSAL (Root -> Left -> Right)
    public void preorderTraversal() {
        System.out.print("Preorder: ");
        preorderTraversal(root);
        System.out.println();
    }
    
    private void preorderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            preorderTraversal(node.getLeft());
            preorderTraversal(node.getRight());
        }
    }
    
    // INORDER TRAVERSAL (Left -> Root -> Right)
    public void inorderTraversal() {
        System.out.print("Inorder: ");
        inorderTraversal(root);
        System.out.println();
    }
    
    private void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.getLeft());
            System.out.print(node.getData() + " ");
            inorderTraversal(node.getRight());
        }
    }
    
    // POSTORDER TRAVERSAL (Left -> Right -> Root)
    public void postorderTraversal() {
        System.out.print("Postorder: ");
        postorderTraversal(root);
        System.out.println();
    }
    
    private void postorderTraversal(Node node) {
        if (node != null) {
            postorderTraversal(node.getLeft());
            postorderTraversal(node.getRight());
            System.out.print(node.getData() + " ");
        }
    }
    
    // LEVEL ORDER TRAVERSAL (Breadth-First)
    public void levelOrderTraversal() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        
        System.out.print("Level Order: ");
        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.getData() + " ");
            
            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
        System.out.println();
    }
    
    // Calculate height of the tree
    public int height() {
        return height(root);
    }
    
    private int height(Node node) {
        if (node == null) {
            return -1; // Height of empty tree is -1
        }
        
        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getRight());
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    // Count total nodes
    public int countNodes() {
        return countNodes(root);
    }
    
    private int countNodes(Node node) {
        if (node == null) {
            return 0;
        }
        
        return 1 + countNodes(node.getLeft()) + countNodes(node.getRight());
    }
    
    // Count leaf nodes
    public int countLeaves() {
        return countLeaves(root);
    }
    
    private int countLeaves(Node node) {
        if (node == null) {
            return 0;
        }
        
        if (node.isLeaf()) {
            return 1;
        }
        
        return countLeaves(node.getLeft()) + countLeaves(node.getRight());
    }
    
    // Search for a value in the tree
    public boolean search(int value) {
        return search(root, value);
    }
    
    private boolean search(Node node, int value) {
        if (node == null) {
            return false;
        }
        
        if (node.getData() == value) {
            return true;
        }
        
        return search(node.getLeft(), value) || search(node.getRight(), value);
    }
    
    // Display tree structure (simple representation)
    public void displayTree() {
        System.out.println("Tree Structure:");
        displayTree(root, 0);
    }
    
    private void displayTree(Node node, int level) {
        if (node != null) {
            displayTree(node.getRight(), level + 1);
            
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            
            System.out.println(node.getData());
            
            displayTree(node.getLeft(), level + 1);
        }
    }
}