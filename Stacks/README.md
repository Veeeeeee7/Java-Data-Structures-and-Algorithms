# Stacks

This folder focuses on Stacks and its array and linked list implementations.

-   Abstract data type
-   No random access (only used for accessing and modifying the last item that was added)
-   Ideal backing dtat structure: linked list
-   Stack Operations
    -   push: adds an item to the top of a stack
    -   pop: removes the top item of a stack
    -   peek: accesses the top item of a stack
-   O(1) time complexity for push, pop, and peek when using a linked list
-   O(n) time complexity for push when using an array (resizing)
-   If you know the maximum number of items or if memory is limited, array is a better choice (there's no overhead with needing to store the top variable)
-
