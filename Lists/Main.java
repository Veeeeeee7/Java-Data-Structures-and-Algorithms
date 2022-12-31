package Lists;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        /*
         * Array Lists
         */

        ArrayList<Employee> arrayList = new ArrayList<>();

        // adds element to the list at the end
        arrayList.add(janeJones);
        arrayList.add(johnDoe);
        arrayList.add(marySmith);
        arrayList.add(mikeWilson);

        // sets the element at a specified index
        arrayList.set(2, billEnd); // replaces marySmith with billEnd
        // arrayList.add(2, billEnd);

        // removes the element at a specified index
        arrayList.remove(0); // deleted janeJones

        // gets the element at a specified index
        System.out.println("\nElement at index 1 of arrayList: " + arrayList.get(1));

        /*
         * Linked Lists
         */

        LinkedList<Employee> linkedList = new LinkedList<>();

        // adds element to the list at the end
        linkedList.add(johnDoe);
        linkedList.addLast(marySmith);
        linkedList.addLast(mikeWilson);
        linkedList.add(billEnd);

        // adds element to the beginning of the list
        linkedList.addFirst(janeJones);

        // removes element from the beginning/end of the list
        linkedList.removeFirst(); // deleted janeJones
        linkedList.removeLast(); // deleted billEnd

        // gets the element from the beginning/end of the list
        System.out.println("\nElement at the beginning of linkedList: " + linkedList.getFirst());
        System.out.println("Element at the end of linkedList: " + linkedList.getLast());

    }
}
