# Heap

![Complete Binary Tree](https://static.javatpoint.com/ds/images/binary-tree.png)

-   Complete binary tree
    -   all levels are filled except possibly the last level
-   children are added to each level from left to right
    -   no required ordering between siblings
-   must satisfy the heap property
    -   max heap property: every node is greater than or equal to its children
    -   min heap property: every node is less than or equal to its children
-   the maximum/minimum element is always at the root
-   insertions/deletions at random indices are not efficient
    -   O(n) time because the tree must be restructured
-   most efficient when changing/accessing the root
    -   O(1) time
-   usually implemented as arrays

## Storing Heaps as Arrays

-   the root is stored at index 0
-   for each node stored at index i
    -   the left child is stored at index 2i + 1
    -   the right child is stored at index 2i + 2
    -   the parent is stored at index floor((i - 1) / 2)

## Priority Queues Class

-   deleting in priority queues removes the highest priority element
    -   the highest priority element is always at the root of the heap
    -   getting the priority element is O(1) time as it is the root, which is updated every time an element is deleted
-   array implementation
    -   unbounded (ie resizing the array when neccessary)
    -   min heap by default

Code:

    // create the priority queue
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

    // add items to the priority queue
    pq.add(5);

    // save the highest priority element and remove it from the priority queue
    int removedHighestPriorityElement = pq.poll();

    // save the highest priority element of the priority queue
    int highestPriorityElement = pq.peek());

    // remove the highest priority element of the priority queue
    pq.remove();
