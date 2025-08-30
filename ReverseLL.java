public class ReverseLL {

    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Insert at end for testing
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    // Print list
    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // Reverse using iteration
    public void reverseIterate() {
        if (head == null || head.next == null) {
            return;
        }

        Node prevNode = null;
        Node currNode = head;

        while (currNode != null) {
            Node nextNode = currNode.next; // save next
            currNode.next = prevNode;      // reverse link
            prevNode = currNode;           // move prev forward
            currNode = nextNode;           // move curr forward
        }

        head = prevNode; // update head
    }

    public Node reverseRecursive(Node head){

        if(head == null || head.next == null){
            return head;
        }
        Node newHead = reverseRecursive(head.next);

        head.next.next = head;

        head.next = null;
        return newHead;
    }

    public static void main(String args[]) {
        ReverseLL list = new ReverseLL();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        System.out.println("Original list:");
        list.printList();

        list.head = list.reverseRecursive(list.head);

        System.out.println("Reversed list:");
        list.printList();
    }
}
