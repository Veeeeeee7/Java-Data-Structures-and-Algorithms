package Lists.SinglyLinkedLists;

/*
 * This class is used to create a singly linked list of Employee objects.
 */

public class EmployeeLinkedList {

    // the linkked list only needs one field the head of the node because each node
    // has a reference to the next node
    private EmployeeNode head;
    private int size;

    // Add a node to the front of the list by creating a new node, which points to
    // the current head (by setting the next node to the current head) and then sets
    // the head of the list to the current node
    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        head = node;

        // when you need the size, you can just traverse the list, which is linear time
        // complexity O(n), but you can just keep track when creating the list
        size++;
    }

    // Gets rid of the first node in the list and returns it in case you need to do
    // something with it
    public EmployeeNode removeFromFront() {

        // if the list is empty, return null because there is nothing to remove
        if (isEmpty()) {
            return null;
        }

        // sets the head to the node that the head is pointing at (the next node)
        EmployeeNode removedNode = head;
        head = head.getNext();
        size--;

        // sets the removed node's next node to null so that its not pointing to
        // anything
        removedNode.setNext(null);
        return removedNode;
    }

    // Getter for the size of the node
    public int getSize() {
        return size;
    }

    // Checks if the list is empty by seeing if the head is null
    public boolean isEmpty() {
        return head == null;
    }

    // Prints the list by starting at the head and then keep traversing the list and
    // printing the node until the next node is null
    public void printList() {
        EmployeeNode current = head;
        System.out.println("HEAD -> ");
        while (current != null) {
            System.out.println(current);
            System.out.println(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

}
