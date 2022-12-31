# Queues

-   Abstract data type
-   first in, first out
-   add (enqueue) and remove (dequeue) operations O(1)
-   items can only be added to the back and only removed from the front
-   peek: accesses the front item of a queue O(1)

## Linked Queues and Deques

-   Linked list implementation of a queue
-   in linked queues, it is only possible to add to the back and remove from the front
-   in linked deques, it is possible to add and remove from both the front and the back (ie basically the same as a doubly linked list)
-   circular queues are a special case of array queues where the last node points to the first node
    -   saves memory because the null indexes created when removing items will be filled up

Code _(since linked deques are just better)_:

    // Creating the deque
    ConcurrentLinkedDeque<Node> deque = new ConcurrentLinkedDeque<>();

    // Add items to the back of the deque
    deque.addLast(new Node(-7));
    deque.addLast(new Node(3));

    // Add items to the front of the deque
    deque.addFirst(new Node(5));
    deque.addFirst(new Node(1));

    // Remove items from the front/back of the deque
    deque.removeFirst(); // removes 1
    deque.removeLast(); // removes 3

    // Peek at the front/back of the deque
    Node firstNode = deque.peekFirst();
    Node lastNode = deque.peekLast();
