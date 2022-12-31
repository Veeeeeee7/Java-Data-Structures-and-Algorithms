package Lists.CircularlyLinkedLists;

public class CircularlyLinkedList {
    private Node head = null;
    private Node tail = null;

    // Adds a node to the end of the list (ie between the previous tail and head)
    public void addNode(int data) {
        Node newNode = new Node(data);

        // If the list is empty, set the head and tail to the new node
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        }
        // Otherwise, set the node after tail to the new node, change the tail to the
        // new node, and set the head to be the node after the new node
        else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    // Prints the list
    public void printList() {
        Node currentNode = head;

        // If the list is empty, print "List is empty"
        if (head == null) {
            System.out.println("List is empty");
        }
        // Otherwise, print the data of each node in the list
        else {
            System.out.print(currentNode.data + ", ");
            currentNode = currentNode.next;
            while (currentNode != head) {
                System.out.print(currentNode.data + ", ");
                currentNode = currentNode.next;
            }
        }
    }

    // Getters and Setters
    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }
}
