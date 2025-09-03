import java.util.LinkedList;
import java.util.Queue;

public class BinayTrees1 {

    // ---------------------------
    // NODE STRUCTURE OF THE TREE
    // ---------------------------
    static class Node {
        int data;     // Value stored in the node
        Node left;    // Pointer to the left child
        Node right;   // Pointer to the right child

        Node(int data) {
            this.data = data;
            this.left = null;   // Initially no child
            this.right = null;
        }
    }

    // ---------------------------
    // BUILD TREE FROM AN ARRAY
    // ---------------------------
    static class BinaryTree {
        static int idx = -1; // Keeps track of the index in the array

        // Build tree using preorder traversal
        // Input format: {root, leftSubtree, rightSubtree}, -1 means "null node"
        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null; // Base case: -1 represents no node
            }

            // Create a new node with the current value
            Node newNode = new Node(nodes[idx]);

            // Recursively build left and right subtrees
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    // ---------------------------
    // TREE TRAVERSALS
    // ---------------------------

    // 1. PREORDER Traversal: Root -> Left -> Right
    public static void preorder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");  // Process root first
        preorder(root.left);                // Recurse left
        preorder(root.right);               // Recurse right
    }

    // 2. INORDER Traversal: Left -> Root -> Right
    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);                 // Visit left subtree
        System.out.print(root.data + " ");  // Then root
        inorder(root.right);                // Then right
    }

    // 3. POSTORDER Traversal: Left -> Right -> Root
    public static void postorder(Node root) {
        if (root == null) return;
        postorder(root.left);               // Visit left
        postorder(root.right);              // Visit right
        System.out.print(root.data + " ");  // Process root last
    }

    // 4. LEVEL ORDER Traversal (BFS)
    public static void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null); // null marks the end of each level

        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println(); // End of level
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null); // Mark next level end
                }
            } else {
                System.out.print(currNode.data + " "); // Print current node
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    // ---------------------------
    // TREE PROPERTIES
    // ---------------------------

    // Count total nodes in tree
    public static int countOfNodes(Node root) {
        if (root == null) return 0;
        int leftNodes = countOfNodes(root.left);
        int rightNodes = countOfNodes(root.right);
        return leftNodes + rightNodes + 1; // 1 for current node
    }

    // Sum of all node values
    public static int sumOfNodes(Node root) {
        if (root == null) return 0;
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        return leftSum + rightSum + root.data;
    }

    // Height of the tree (max depth)
    public static int height(Node root) {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Diameter of tree (longest path between 2 nodes)
    // Naive approach: O(n^2)
    public static int diameter(Node root) {
        if (root == null) return 0;

        int diam1 = diameter(root.left);     // Diameter of left subtree
        int diam2 = diameter(root.right);    // Diameter of right subtree
        int diam3 = height(root.left) + height(root.right) + 1; // Path through root

        return Math.max(diam3, Math.max(diam1, diam2));
    }

    // Optimized Diameter Calculation: O(n)
    static class TreeInfo {
        int ht;   // height of subtree
        int diam; // diameter of subtree

        TreeInfo(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }
    }

    public static TreeInfo diameter2(Node root) {
        if (root == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo left = diameter2(root.left);
        TreeInfo right = diameter2(root.right);

        int myHeight = Math.max(left.ht, right.ht) + 1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.ht + right.ht + 1;

        int mydiam = Math.max(Math.max(diam1, diam2), diam3);

        return new TreeInfo(myHeight, mydiam);
    }

    // ---------------------------
    // MAIN METHOD TO TEST
    // ---------------------------
    public static void main(String args[]) {
        // Preorder representation: root, left, right
        // -1 means no child
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, -1};

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("Binary tree constructed successfully.\n");

        System.out.println("Preorder traversal:");
        preorder(root);
        System.out.println("\n");

        System.out.println("Inorder traversal:");
        inorder(root);
        System.out.println("\n");

        System.out.println("Postorder traversal:");
        postorder(root);
        System.out.println("\n");

        System.out.println("Level order traversal:");
        levelOrder(root);
        System.out.println();

        System.out.println("Count of nodes = " + countOfNodes(root));
        System.out.println("Sum of nodes = " + sumOfNodes(root));
        System.out.println("Height of tree = " + height(root));
        System.out.println("Diameter (O(n^2)) = " + diameter(root));
        System.out.println("Diameter (O(n)) = " + diameter2(root).diam);
    }
}
