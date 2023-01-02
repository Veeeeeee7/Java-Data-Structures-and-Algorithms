package Trees;

public class RedBlackBinarySearchTree extends BinarySearchTree {
    static final boolean RED = false;
    static final boolean BLACK = true;

    // Search for a node with the given data using a binary search algorithm
    @Override
    public Node search(int data) {
        Node node = root;

        // Traverse the tree until there are no more children, then return null as there
        // is no node with the given data
        while (node != null) {
            // If the data is found, return the node
            if (data == node.data) {
                return node;
            }
            // If the data is less than the current node's data, continue to the left
            else if (data < node.data) {
                node = node.left;
            }
            // If the data is greater than the current node's data, continue to the right
            else {
                node = node.right;
            }
        }

        return null;
    }

    // Insert a new node with the given data
    @Override
    public void insert(int data) {
        Node node = root;
        Node parent = null;

        // Traverse the tree until the node is null, ie the position where the new node
        // should be inputted is found and keep track of the parent node
        while (node != null) {
            parent = node;
            // If the data is less than the current node's data, continue to the left
            if (data < node.data) {
                node = node.left;
            }
            // If the data is greater than the current node's data, continue to the right
            else if (data > node.data) {
                node = node.right;
            }
            // If the data is equal to the current node's data, throw an exception
            else {
                throw new IllegalArgumentException("BST already contains a node with data " + data);
            }
        }

        // Insert new node
        Node newNode = new Node(data);

        // Initially set the color to red (changed later in fixColorAfterInsert())
        newNode.color = RED;

        // If the parent is null, the root must also be null and the new node should be
        // inserted as the root
        if (parent == null) {
            root = newNode;
        }
        // If the data is less than the parent's data, insert the new node as the left
        else if (data < parent.data) {
            parent.left = newNode;
        }
        // If the data is greater than the parent's data, insert the new node as the
        else {
            parent.right = newNode;
        }

        // Update the parent of the new node
        newNode.parent = parent;

        // Fix the color of the tree
        fixColorAfterInsert(newNode);
    }

    private void fixColorAfterInsert(Node node) {
        Node parent = node.parent;

        // if the parent is null, we've reached the root, the end of the recursion
        if (parent == null) {
            // The root node must always be black
            node.color = BLACK;
            return;
        }

        // if the parent is black, nothing needs to be changed because black nodes have
        // red children
        if (parent.color == BLACK) {
            return;
        }

        /*
         * if we reach this point, we know that the parent is red
         */

        // Get the grandparent (since the root must be black, the grandparent must exist
        // as the parent is not the root as it is red)
        Node grandparent = parent.parent;

        // Get the uncle (may be null and therefore black)
        Node uncle = parent.getUncle();

        // if the uncle is red or isnt null (ie black), we need to recolor the parent,
        // grandparent and uncle
        if (uncle != null && uncle.color == RED) {
            // change the parent and uncle to black, and the grandparent to red
            // this is because the parent (red) cannot have a red child, so the parent must
            // be changed to black. since the grandparent has two children and one of them
            // is black, then both have to be black and the grandparent has to be red
            parent.color = BLACK;
            grandparent.color = RED;
            uncle.color = BLACK;

            // recursively go up the tree to fix the color until reaching the root
            fixColorAfterInsert(grandparent);
        }

        // Since the uncle is not red or is null, it is black
        // if the parent is the left child of grandparent...
        else if (parent == grandparent.left) {
            // if the node is left of the parent (ie an inner child), we need to rotate the
            // parent subtree left to make the new node an outer child
            if (node == parent.right) {
                rotateLeft(parent);

                // after rotating, the new node is now the parent of the old parent: update the
                // parent variable
                parent = node;
            }

            // now the new node is an outer child, we need to rotate the grandparent subtree
            // to the right to make a balanced subtree
            rotateRight(grandparent);

            // update the colors of the parent and grandparent, which are moved. since the
            // uncle is black, the parent also has to be black and thus the grandparent has
            // to be red
            parent.color = BLACK;
            grandparent.color = RED;
        }

        // if the parent is the right child of grandparent...
        else {
            // if the node is right of the parent (ie an inner child), we need to rotate the
            // parent subtree right to make the new node an outer child
            if (node == parent.left) {
                rotateRight(parent);

                // after rotating, the new node is now the parent of the old parent: update the
                // parent variable
                parent = node;
            }

            // now the new node is an outer child, we need to rotate the grandparent subtree
            // to the left to make a balanced subtree
            rotateLeft(grandparent);

            // update the colors of the parent and grandparent, which are moved. since the
            // uncle is black, the parent also has to be black and thus the grandparent has
            // to be red
            parent.color = BLACK;
            grandparent.color = RED;
        }
    }

    // Delete a node with the given data
    @Override
    public void delete(int data) {
        Node node = root;

        // Traverse the tree until the node is found or the end of the tree is reached
        while (node != null && node.data != data) {
            // If the data is less than the current node's data, continue to the left
            if (data < node.data) {
                node = node.left;
            }
            // If the data is greater than the current node's data, continue to the right
            else {
                node = node.right;
            }
        }

        // If the node is not found, throw an exception
        if (node == null) {
            throw new IllegalArgumentException("BST does not contain a node with data " + data);
        }

        /*
         * at this point, the node to be deleted has been found
         */

        Node movedUpNode;
        boolean deletedNodeColor;

        // if the node has 0 or 1 child, we can delete it directly with
        // deleteNodeWithZeroOrOneChild() method
        if (node.left == null || node.right == null) {
            movedUpNode = deleteNodeWithZeroOrOneChild(node);
            deletedNodeColor = node.color;
        }

        // if the node has two children, replace it with the minimum node of the right
        // subtree
        else {
            // Copy the data of the minimum node of the right subtree to the node to be
            // deleted (saves the color of the node to be deleted)
            node.data = node.right.minNode().data;

            // Delete the minimum node of the right subtree
            movedUpNode = deleteNodeWithZeroOrOneChild(node.right.minNode());
            deletedNodeColor = node.right.minNode().color;
        }

        // if the deleted node was black, we need to fix the color of the tree
        if (deletedNodeColor == BLACK) {
            fixColorAfterDelete(movedUpNode);

            // Remove the temporary NIL node with a null child
            if (movedUpNode.getClass() == NilNode.class) {
                replaceParentsChild(movedUpNode.parent, movedUpNode, null);
            }
        }
    }

    // Delete a node with zero or one child
    private Node deleteNodeWithZeroOrOneChild(Node node) {
        // if the node only has a left child, replace it with its left child
        if (node.left != null) {
            replaceParentsChild(node.parent, node, node.left);
            // return the node that replaced the deleted node
            return node.left;
        }

        // if the node only has a right child, replace it with its right child
        else if (node.right != null) {
            replaceParentsChild(node.parent, node, node.right);
            // return the node that replaced the deleted node
            return node.right;
        }

        // Node has no children -->
        // * node is red --> just remove it
        // * node is black --> replace it by a temporary NIL node (needed to fix the R-B
        // rules)

        // if the node has no children...
        // remove it if it is red
        // replace it by a temporary NIL node if it is black
        else {
            Node newChild = node.color == BLACK ? new NilNode() : null;
            replaceParentsChild(node.parent, node, newChild);
            return newChild;
        }
    }

    // Fix the color of the tree after a node has been deleted
    private void fixColorAfterDelete(Node node) {
        // if the node is the root, recursion ends
        if (node == root) {
            node.color = BLACK;
            return;
        }

        // the sibling node could be null and thus black
        Node sibling = node.getSibling();

        // if the sibling is red, we call handleRedSibling() (updates colors and
        // rotates)
        if (sibling.color == RED) {
            handleRedSibling(node, sibling);
            sibling = node.getSibling(); // saves the new sibling
        }

        // since the sibling is not red, it is black
        // if the sibling has two black children (either null or black)...
        if ((sibling.left == null || sibling.left.isBlack()) && (sibling.right == null || sibling.right.isBlack())) {
            sibling.color = RED;

            // if the parent is red, we can just make it black
            if (node.parent.color == RED) {
                node.parent.color = BLACK;
            }

            // if the parent is black, we need to recursively fix the color of the parent
            else {
                fixColorAfterDelete(node.parent);
            }
        }

        // if the sibling has at least one red child...
        else {
            handleBlackSiblingWithAtLeastOneRedChild(node, sibling);
        }
    }

    // handleRedSibling() method
    private void handleRedSibling(Node node, Node sibling) {
        // updates colors
        sibling.color = BLACK;
        node.parent.color = RED;

        // if the node is the left child of its parent, rotate left around the parent
        if (node == node.parent.left) {
            rotateLeft(node.parent);
        }
        // if the node is the right child of its parent, rotate right around the parent
        else {
            rotateRight(node.parent);
        }
    }

    // handleBlackSiblingWithAtLeastOneRedChild() method
    private void handleBlackSiblingWithAtLeastOneRedChild(Node node, Node sibling) {
        boolean nodeIsLeftChild = node == node.parent.left;

        // if the node is the left child and its outer nephew is black or null...
        if (nodeIsLeftChild && (sibling.right == null || sibling.right.isBlack())) {
            // updates colors
            sibling.left.color = BLACK;
            sibling.color = RED;
            // rotate right around the sibling so that the sibling becomes the outer nephew,
            // the inner nephew becomes the sibling, and the outer nephew becomes the inner
            // nephew
            rotateRight(sibling);
            sibling = node.parent.right; // saves the new sibling
        }
        // if the node is the right child and its outer nephew is black or null...
        else if (!nodeIsLeftChild && (sibling.left == null || sibling.left.isBlack())) {
            // updates colors
            sibling.right.color = BLACK;
            sibling.color = RED;
            // rotate left around the sibling so that the sibling becomes the outer nephew,
            // the inner nephew becomes the sibling, and the outer nephew becomes the inner
            // nephew
            rotateLeft(sibling);
            sibling = node.parent.left;
        }

        // now the black sibling has a red outer nephew

        // updates colors
        sibling.color = node.parent.color;
        node.parent.color = BLACK;
        // if the node is the left child, rotate left around the parent
        if (nodeIsLeftChild) {
            sibling.right.color = BLACK;
            rotateLeft(node.parent);
        }
        // if the node is the right child, rotate right around the parent
        else {
            sibling.left.color = BLACK;
            rotateRight(node.parent);
        }
    }

    // rotateRight() method
    private void rotateRight(Node node) {
        Node parent = node.parent;
        Node leftChild = node.left;

        node.left = leftChild.right;
        if (leftChild.right != null) {
            leftChild.right.parent = node;
        }

        leftChild.right = node;
        node.parent = leftChild;

        replaceParentsChild(parent, node, leftChild);
    }

    // rotateLeft() method
    private void rotateLeft(Node node) {
        Node parent = node.parent;
        Node rightChild = node.right;

        node.right = rightChild.left;
        if (rightChild.left != null) {
            rightChild.left.parent = node;
        }

        rightChild.left = node;
        node.parent = rightChild;

        replaceParentsChild(parent, node, rightChild);
    }

    // replaceParentsChild() method
    private void replaceParentsChild(Node parent, Node oldChild, Node newChild) {
        if (parent == null) {
            root = newChild;
        } else if (parent.left == oldChild) {
            parent.left = newChild;
        } else if (parent.right == oldChild) {
            parent.right = newChild;
        } else {
            throw new IllegalStateException("Node is not a child of its parent");
        }

        if (newChild != null) {
            newChild.parent = parent;
        }
    }
}
