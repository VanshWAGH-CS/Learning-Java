public class Node {
    int data;
    Node left;
    Node right;
    
    // Constructor
    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
    // Constructor for general tree nodes (can have multiple children)
    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    
    // Getter and setter methods
    public int getData() {
        return data;
    }
    
    public void setData(int data) {
        this.data = data;
    }
    
    public Node getLeft() {
        return left;
    }
    
    public void setLeft(Node left) {
        this.left = left;
    }
    
    public Node getRight() {
        return right;
    }
    
    public void setRight(Node right) {
        this.right = right;
    }
    
    // Check if node is a leaf
    public boolean isLeaf() {
        return left == null && right == null;
    }
    
    // String representation
    @Override
    public String toString() {
        return "Node{" + "data=" + data + "}";
    }
}
