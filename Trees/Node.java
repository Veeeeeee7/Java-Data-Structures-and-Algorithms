package Trees;

public class Node {
    int data;
    Node left;
    Node right;
    Node parent;
    boolean color; // false = red, true = black
    private static final boolean RED = false;
    private static final boolean BLACK = true;

    // Constructor
    public Node(int data) {
        this.data = data;
    }

    // toString() method
    public String toString() {
        return "Node=[" + Integer.toString(data) + "]";
    }

    // Get the minimum value in the tree
    public int min() {
        // If there is no left child, return the current node
        if (left == null) {
            return data;
        }
        // Otherwise, recursively call the min() method on the left child
        else {
            return left.min();
        }
    }

    // Get the maximum value in the tree
    public int max() {
        // If there is no right child, return the current node
        if (right == null) {
            return data;
        }
        // Otherwise, recursively call the max() method on the right child
        else {
            return right.max();
        }
    }

    // Get the uncle of a node
    public Node getUncle() {
        if (this.parent == null || this.parent.parent == null) {
            return null;
        }

        Node grandparent = this.parent.parent;
        if (grandparent.left == this.parent) {
            return grandparent.right;
        } else if (grandparent.right == this.parent) {
            return grandparent.left;
        } else {
            // throw new IllegalStateException("Parent is not a child of its grandparent");
            return null;
        }
    }

    // Get the sibling of a node
    public Node getSibling() {
        Node parent = this.parent;
        if (this == parent.left) {
            return parent.right;
        } else if (this == parent.right) {
            return parent.left;
        } else {
            throw new IllegalStateException("Parent is not a child of its grandparent");
        }
    }

    public void rotateRight() {
        Node parent = this.parent;
        Node leftChild = this.left;

        this.left = leftChild.right;
        if (leftChild.right != null) {
            leftChild.right.parent = this;
        }

        leftChild.right = this;
        this.parent = leftChild;

        replaceParentsChild(parent, this, leftChild);
    }

    public void rotateLeft() {
        Node parent = this.parent;
        Node rightChild = this.right;

        this.right = rightChild.left;
        if (rightChild.left != null) {
            rightChild.left.parent = this;
        }

        rightChild.left = this;
        this.parent = rightChild;

        replaceParentsChild(parent, this, rightChild);
    }

    public static void replaceParentsChild(Node parent, Node oldChild, Node newChild) {
        if (parent == null) {
            return;
        } else if (parent.left == oldChild) {
            parent.left = newChild;
        } else if (parent.right == oldChild) {
            parent.right = newChild;
        } else {
            // throw new IllegalStateException("Node is not a child of its parent");
            return;
        }

        if (newChild != null) {
            newChild.parent = parent;
        }
    }

    public void handleRedSibling(Node sibling) {
        // Recolor...
        sibling.color = BLACK;
        this.parent.color = RED;

        // ... and rotate
        if (this == this.parent.left) {
            this.parent.rotateLeft();
        } else {
            this.parent.rotateRight();
        }
    }

    public void handleBlackSiblingWithAtLeastOneRedChild(Node sibling) {
        boolean nodeIsLeftChild = this == this.parent.left;

        // Case 5: Black sibling with at least one red child + "outer nephew" is black
        // --> Recolor sibling and its child, and rotate around sibling
        if (nodeIsLeftChild && sibling.right.isBlack()) {
            sibling.left.color = BLACK;
            sibling.color = RED;
            sibling.rotateRight();
            sibling = this.parent.right;
        } else if (!nodeIsLeftChild && sibling.left.isBlack()) {
            sibling.right.color = BLACK;
            sibling.color = RED;
            sibling.rotateLeft();
            sibling = this.parent.left;
        }

        // Fall-through to case 6...

        // Case 6: Black sibling with at least one red child + "outer nephew" is red
        // --> Recolor sibling + parent + sibling's child, and rotate around parent
        sibling.color = this.parent.color;
        this.parent.color = BLACK;
        if (nodeIsLeftChild) {
            sibling.right.color = BLACK;
            this.parent.rotateLeft();
        } else {
            sibling.left.color = BLACK;
            this.parent.rotateRight();
        }
    }

    public boolean isBlack() {
        return this == null || this.color == BLACK;
    }

}
