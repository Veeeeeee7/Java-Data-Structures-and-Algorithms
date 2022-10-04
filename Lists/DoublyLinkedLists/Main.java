package DoublyLinkedLists;

public class Main {

    public static void main(String[] args) {

        // Create the employees
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        // Create the doubly linked list
        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();

        // Add the employees to the list
        list.addToFront(janeJones);
        list.addToFront(johnDoe);
        list.addToFront(marySmith);
        list.addToFront(mikeWilson);

        // Print the list
        list.printList();
        System.out.println(list.getSize());

        // add Bill to the end of the list
        Employee billEnd = new Employee("Bill", "End", 78);
        list.addToEnd(billEnd);
        list.printList();
        System.out.println(list.getSize());

        // removes the first node from the front of the list
        list.removeFromFront();
        list.printList();
        System.out.println(list.getSize());

        // removes the last node from the end of the list
        list.removeFromEnd();
        list.printList();
        System.out.println(list.getSize());

    }
}
