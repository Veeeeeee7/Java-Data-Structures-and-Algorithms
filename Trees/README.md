# Trees

Trees are a data structure that consists of nodes in a parent / child relationship.

-   a tree can only have one root node
-   a node can have multiple children
-   a leaf node is a node that has no children
-   every node except the root node has exactly one parent
-   every parent-child relationship is an edge
-   every node can be a subtree of the original tree (a tree within a tree)
-   every node that has children is an inner node (inode)
-   the depth of a node is the number of edges from the root node to that node
    -   a level is a set of nodes that are at the same depth
-   the height of a node is the number of edges on the longest path from that node to a leaf

## Binary Tree

![Binary Tree](https://www.happycoders.eu/wp-content/uploads/2021/05/binary-tree-example-600x350.png)

-   a tree where every node has at most two children
    -   referred to as the left child and the right child
    -   template used for binary search trees
-   a full binary tree is when every node has either 0 or 2 children
-   a complete binary tree is when every level is completely filled except for the last level
    -   the last level is filled from left to right
-   a perfect binary tree is when every node has either 0 or 2 children and all the leaf nodes are at the same level
-   a balanced binary tree is when the height of the left and right subtrees of every node differ by at most one

## [Binary Search Tree](/Trees/BinarySearchTree.java)

![Binary Search Tree](https://www.happycoders.eu/wp-content/uploads/2021/06/binary-search-tree-example-600x349.png)

-   binary tree where the left child is less than the parent and the right child is greater than the parent
    -   no duplicate nodes are allowed, unlike binary trees
-   made for easy searching using the binary search algorithm O(log n)
-   if you input sorted data (especially in decreasing order), you will get a linked list and binary search algorithm will be O(n)
    -   some algorithms will shift the nodes around to fix this
-   uses in-order traversal to get the data in sorted order

## [Red-Black Tree](/Trees/RedBlackBinarySearchTree.java)

![](https://www.happycoders.eu/wp-content/uploads/2021/09/red-black-tree-example-with-nil-400x274.png)

-   widely used self-balancing binary search tree
    -   after each insertion and deletion, the tree is re-balanced by recoloring and rotation
-   each node is assigned a color either red or black
    -   root node is always black
    -   red nodes cannot have red children
-   NIL nodes are used to represent empty nodes
    -   NIL nodes are always black
    -   represented by `null` in Java
-   all paths from a node to the NIL leaves contain the same number of black nodes
-   all red nodes will have either 2 NIL nodes or 2 black child nodes
-   height: the maximum number of nodes from the root to a NIL node, not including the root
-   the longest path from the root to a NIL node is at most twice as long as the shortest path from the root to a NIL node
-   black height: the number of black nodes on a path from the root to a NIL node
    -   the NIL node is counted, but the starting node is not counted

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
