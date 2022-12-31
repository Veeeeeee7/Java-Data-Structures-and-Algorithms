package Lists.SinglyLinkedLists;

public class Main {
    public static void main(String[] args) {

        // Create employees
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        // Create linked list
        EmployeeLinkedList list = new EmployeeLinkedList();

        // checks if the list is empty, which it is
        System.out.println(list.isEmpty());

        // adds the employees to the list at the front, since the employees are always
        // added to the front, the last employee added will be the first employee in the
        // list
        list.addToFront(janeJones);
        list.addToFront(johnDoe);
        list.addToFront(marySmith);
        list.addToFront(mikeWilson);

        // gets the size of the list
        System.out.println(list.getSize());

        // prints the list
        list.printList();

        // removes the first employee from the list
        list.removeFromFront();
        System.out.println(list.getSize());
        list.printList();

    }
}
