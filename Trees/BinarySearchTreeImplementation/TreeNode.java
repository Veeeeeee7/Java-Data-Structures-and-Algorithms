package Trees.BinarySearchTreeImplementation;

public class TreeNode {
    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    // Constructor
    public TreeNode(int data) {
        this.data = data;
    }

    // Insert a new node into the tree
    public void insert(int value) {
        // If there are duplicate values, just don't insert for this implementation
        if (value == data) {
            return;
        }

        // If the value is less than the current node, insert it into the left subtree
        if (value < data) {
            // If there is no left child, let the new node be the left child
            if (leftChild == null) {
                leftChild = new TreeNode(value);
            }
            // If there is a left child, recursively call the insert() method on the left
            // child
            else {
                leftChild.insert(value);
            }
        }
        // If the value is greater than the current node, insert it into the right
        // subtree
        else {
            // If there is no right child, let the new node be the right child
            if (rightChild == null) {
                rightChild = new TreeNode(value);
            }
            // If there is a right child, recursively call the insert() method on the right
            // child
            else {
                rightChild.insert(value);
            }
        }
    }

    // Get the node with the inputted value
    public TreeNode get(int value) {
        // If the value is equal to the current node, return the current node
        if (value == data) {
            return this;
        }

        // If the value is less than the current node, search the left subtree
        if (value < data) {
            // If there is no left child, return null
            if (leftChild != null) {
                return leftChild.get(value);
            }
        }
        // If the value is greater than the current node, search the right subtree
        else {
            // If there is no right child, return null
            if (rightChild != null) {
                return rightChild.get(value);
            }
        }

        // If the value is not found, return null
        return null;
    }

    // Get the minimum value in the tree
    public int min() {
        // If there is no left child, return the current node
        if (leftChild == null) {
            return data;
        }
        // Otherwise, recursively call the min() method on the left child
        else {
            return leftChild.min();
        }
    }

    // Get the maximum value in the tree
    public int max() {
        // If there is no right child, return the current node
        if (rightChild == null) {
            return data;
        }
        // Otherwise, recursively call the max() method on the right child
        else {
            return rightChild.max();
        }
    }

    // in-order traversal
    public void traverseInOrder() {
        // If there is a left child, recursively call the traverseInOrder() method on
        // the
        // left child
        if (leftChild != null) {
            leftChild.traverseInOrder();
        }

        // Print the current node
        System.out.print(data + ", ");

        // If there is a right child, recursively call the traverseInOrder() method on
        // the right child
        if (rightChild != null) {
            rightChild.traverseInOrder();
        }
    }

    // Getters and setters
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    // toString() method
    @Override
    public String toString() {
        return "TreeNode [data=" + data + "]";
    }

}
