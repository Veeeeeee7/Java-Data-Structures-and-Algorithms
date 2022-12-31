# Lists

## List Interface

-   ordered collection of elements
-   allows duplicate items
-   typically can only insert, delete, and access elements at present positions (no random access)
-   useful for maintaining a collection of items in a particular order
-   not for searching or sorting
-   includes a ListIterator

Code:

    ListIterator<Employee> iter = employeesList.listIterator();
    while (iter.hasNext()) {
        System.out.println(iter.next());
    }

## Array List and Vector

-   basically an array with a list interface
-   size is limited (unlike other lists) by the size of the backing array and therefore adding a lot of items will be slow O(n)
-   accessing data will be fast O(1) because it just finds the data at a certain index of the backing array
-   ArrayList is not thread safe (not synchronized) and therefore is faster than Vector
-   Vector is thread safe (synchronized) and therefore is slower than ArrayList

Code:

    // Creating the arrayList
    List<Employee> arrayList = new ArrayList<>();

    // Adding items to the list at the end
    arrayList.add(new Employee("Jane", "Jones", 123));

    // Adding items to the list at a specific index
    arrayList.add(2, billEnd);
    arrayList.set(2, billEnd);

    // Removing items from the list at a specific index
    arrayList.remove(0);

    // Random access
    Employee secondEmployee = arrayList.get(1);

## Linked List

-   a linked list is a list of nodes
-   a singly linked list has a node that points to the next node
    -   only has a head node and therefore can only add/remove/access items from the front of the list
-   a doubly linked list has a node that points to the next node and the previous node
    -   has both a head and tail node and therefore can add/remove/access items from the front and back of the list
-   a circularly linked list is a singly linked list with a tail node that points to the head node
    -   not implemented in JDK, but is used in the JDK implementation of circular queues
-   fast at adding and removing items from the beginning of the list O(1)
-   slow at random access because it has to traverse the list to find the item O(n)

Code:

    // Creating the linkedList
    LinkedList<Employee> linkedList = new LinkedList<>();

    // adds element to the list at the end
    linkedList.add(johnDoe);
    linkedList.addLast(janeJones);

    // adds element to the beginning of the list
    linkedList.addFirst(janeJones);

    // removes element from the beginning/end of the list
    linkedList.removeFirst(); // deleted janeJones
    linkedList.removeLast(); // deleted billEnd

    // gets the element from the beginning/end of the list
    Employee firstEmployee = linkedList.getFirst();
    Employee lastEmployee = linkedList.getLast();
