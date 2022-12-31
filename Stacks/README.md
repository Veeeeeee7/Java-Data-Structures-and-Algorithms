# Stacks

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

## Stack Class

-   extends Vector class
-   uses an array implementation instead of a linked list implementation
-   might take extra time to resize the backing array, but requires much less memory compared to a linked list implementation

Code:

    // Creates a stack
    Stack<Node> stack = new Stack<>();

    // Add elements to the end of the stack using push()
    stack.push(new Node(2));
    stack.push(new Node(8));
    stack.push(new Node(5));

    // Remove elements from the end of the stack using pop()
    stack.pop(); // removes 5

    // Peek at the last element in the stack
    Node lastNode = stack.peek();
