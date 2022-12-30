# Trees

Trees are a data structure that consists of nodes in a parent / child relationship.

-   a tree can only have one root node
-   a node can have multiple children
-   a leaf node is a node that has no children
-   every node except the root node has exactly one parent
-   every parent-child relationship is an edge
-   every node can be a subtree of the original tree (a tree within a tree)
-   the depth of a node is the number of edges from the root node to that node
    -   a level is a set of nodes that are at the same depth
-   the height of a node is the number of edges on the longest path from that node to a leaf

## Binary Tree

-   a tree where every node has at most two children
    -   referred to as the left child and the right child
    -   template used for binary search trees

### Traversal

![Sample Binary Search Tree](https://upload.wikimedia.org/wikipedia/commons/thumb/d/da/Binary_search_tree.svg/180px-Binary_search_tree.svg.png)

-   level traversal
    -   look at nodes on each level at a time starting at level 0
    -   from left to right
    -   level order: 8, 3, 10, 1, 6, 14, 4, 7, 13
-   in-order traversal
    -   looks at the nodes from left to right
    -   the left child is visited first, then the root, then the right child
    -   the data will be sorted in ascending order
    -   in-order order: 1, 3, 4, 6, 7, 8, 10, 13, 14
-   pre-order traversal
    -   looks at the root of each subtree first
    -   goes to the left child first then the right child
    -   pre-order order: 8, 3, 1, 6, 4, 7, 10, 14, 13
-   post-order traversal
    -   looks at the root of each subtree last
    -   goes from bottom to top of the tree starting with the leftmost child
    -   post-order order: 1, 4, 7, 6, 3, 13, 14, 10, 8

_kinda of confusing but for level traversal think of a horizontal line moving down; in-order traversal think of a vertical line moving right; pre-order traversal it recursively checks the left child until there isnt anymore and then checks the right child when coming back to the original node; post-order traversal is like going from the leftmost child and checking what child is needed to make up the parent node and if that child is made up of more children, check those first_
