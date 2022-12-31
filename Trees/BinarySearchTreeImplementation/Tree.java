package Trees.BinarySearchTreeImplementation;

public class Tree {
    private TreeNode root;

    // Insert a new node into the tree
    public void insert(int value) {

        // If the root is null (ie the tree is empty), make the new node the root node
        if (root == null) {
            root = new TreeNode(value);
        }
        // Otherwise, insert the new node into the tree using the node insert() method
        else {
            root.insert(value);
        }
    }

    // Get the node with the inputted value
    public TreeNode get(int value) {
        // If the root is null (ie the tree is empty), return null
        if (root != null) {
            return root.get(value);
        }

        return null;
    }

    // Delete a node from the tree with the inputted value
    public void delete(int value) {
        root = delete(root, value);
    }

    private TreeNode delete(TreeNode subtreeRoot, int value) {
        // If the subtree root is null, return null
        if (subtreeRoot == null) {
            return subtreeRoot;
        }

        // If the value is less than the subtree root, recursively call the delete()
        // method
        // on the left child
        if (value < subtreeRoot.getData()) {
            subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value));
        }
        // If the value is greater than the subtree root, recursively call the delete()
        // method on the right child
        else if (value > subtreeRoot.getData()) {
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), value));
        }
        // If the value is equal to the subtree root, delete the node
        else {
            // If the node has only one child, return the child
            if (subtreeRoot.getLeftChild() == null) {
                return subtreeRoot.getRightChild();

            } else if (subtreeRoot.getRightChild() == null) {
                return subtreeRoot.getLeftChild();

            }

            // If the node has two children, replace the node with the minimum value in the
            // right subtree
            // Set the subtree root to the minimum value in the right subtree
            subtreeRoot.setData(subtreeRoot.getRightChild().min());

            // Delete the minimum value in the right subtree
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), subtreeRoot.getData()));

            // If the node has two children, replace the node with the maximum value in the
            // left subtree
            // Set the subtree root to the maximum value in the left subtree
            // subtreeRoot.setData(subtreeRoot.getLeftChild().max());
            //
            // Delete the maximum value in the left subtree
            // subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(),
            // subtreeRoot.getData()));
        }

        // Return the subtree root when the node has no children
        return subtreeRoot;
    }

    // Get the minimum value in the tree
    public int min() {
        // If the root is null (ie the tree is empty), return Integer.MIN_VALUE
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        // Otherwise, return the minimum value in the tree using the node min() method
        else {
            return root.min();
        }
    }

    // Get the maximum value in the tree
    public int max() {
        // If the root is null (ie the tree is empty), return Integer.MAX_VALUE
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        // Otherwise, return the maximum value in the tree using the node max() method
        else {
            return root.max();
        }
    }

    // in-order traversal
    public void traverseInOrder() {
        if (root != null) {
            root.traverseInOrder();
        }
    }
}
