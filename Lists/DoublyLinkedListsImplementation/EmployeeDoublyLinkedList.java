package Lists.DoublyLinkedListsImplementation;

public class EmployeeDoublyLinkedList {

    /*
     * This class is used to create a doubly linked list of Employee objects.
     */

    private EmployeeNode head;
    private EmployeeNode tail;
    private int size;

    // Add a node to the front of the list.
    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);

        // If the list is empty, set the tail to the new node. later both the head and
        // the tail will be set to the same node
        if (head == null) {
            tail = node;
        }
        // Otherwise, set the new node to the head, which points to the next node (the
        // original head)
        else {
            head.setPrevious(node);
            node.setNext(head);
        }

        head = node;
        size++;
    }

    // Add a node to the end of the list.
    public void addToEnd(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);

        // If the list is empty, set the head to the new node. later both the head and
        // the tail will be set to the same node
        if (tail == null) {
            head = node;
        }
        // Otherwise, set the new node to the tail, which points to the previous node
        // (the original tail)
        else {
            tail.setNext(node);
            node.setPrevious(tail);
        }

        tail = node;
        size++;
    }

    // Remove a node from the front of the list.
    public EmployeeNode removeFromFront() {

        // If the list is empty, return null (nothing to remove)
        if (isEmpty()) {
            return null;
        }

        // set the head of the current list to the node being removed
        EmployeeNode removedNode = head;

        // if the head is the only node, set the tail also to null because when the list
        // only has one object the head and tail both have the same node
        if (head.getNext() == null) {
            tail = null;
        }
        // otherwise, set the current head to null
        else {
            head.getNext().setPrevious(null);
        }

        // set the head to the next node in the list
        head = head.getNext();
        size--;

        // set the removed node's (the head being removed) next node to null
        removedNode.setNext(null);
        return removedNode;
    }

    public EmployeeNode removeFromEnd() {

        // If the list is empty, return null (nothing to remove)
        if (isEmpty()) {
            return null;
        }

        // set the tail of the current list to the node being removed
        EmployeeNode removedNode = tail;

        // if the tail is the only node, set the head also to null because when the list
        // only has one object the head and tail both have the same node
        if (tail.getPrevious() == null) {
            head = null;
        }
        // otherwise, set the current tail to null
        else {
            tail.getPrevious().setNext(null);
        }

        // set the tail to the previous node in the list
        tail = tail.getPrevious();
        size--;

        // set the removed node's (the tail being removed) previous node to null
        removedNode.setPrevious(null);
        return removedNode;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        EmployeeNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" <=> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

}
