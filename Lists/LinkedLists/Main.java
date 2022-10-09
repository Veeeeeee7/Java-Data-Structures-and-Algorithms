package LinkedLists;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        LinkedList<Employee> list = new LinkedList<>();
        list.addFirst(janeJones);
        list.addFirst(johnDoe);
        list.addFirst(marySmith);
        list.addFirst(mikeWilson);

        // the .add() or .addLast() method adds to the end of the list instead of the start
        // use .addFirst() method to add to the start
        list.add(billEnd);

        // removes the FIRST node of the list, not the last
        // .removeFirst() method also removes the FIRST node of the list
        list.remove();

        // removes the last node of the list
        // list.removeLast();

        // prints the list
        // list.forEach(employee -> System.out.println(employee));

        Iterator iter = list.iterator();
        System.out.print("HEAD -> ");
        while (iter.hasNext()) {
            System.out.print(iter.next());
            System.out.print(" <=> ");
        }
        System.out.print("null");
    }
}
