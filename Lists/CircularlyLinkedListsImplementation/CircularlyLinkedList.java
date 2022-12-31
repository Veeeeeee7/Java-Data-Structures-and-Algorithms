package Lists.CircularlyLinkedListsImplementation;

public class CircularlyLinkedList {
    private Node head = null;
    private Node tail = null;

    // Adds a node to the front of the list (ie between the previous tail and head)
    public void add(int data) {
        Node newNode = new Node(data);

        // If the list is empty, set the head and tail to the new node
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        }
        // Otherwise, save the current head to temp, set the new node as the head, set
        // the node after head to temp, and set the node after tail to the new node
        else {
            Node temp = head;
            head = newNode;
            head.next = temp;
            tail.next = head;
        }
    }

    // Removes a node from the front of the list
    public void remove() {
        // If the list is empty, print "List is empty"
        if (head == null) {
            System.out.println("List is empty");
        }
        // If the list has only one node, set the head and tail to null
        else if (head == tail) {
            head = null;
            tail = null;
        }
        // Otherwise, set the head to the node after the head, and set the node after
        // the tail to the new head
        else {
            head = head.next;
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
