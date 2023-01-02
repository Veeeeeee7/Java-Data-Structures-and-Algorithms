package Trees;

import java.util.concurrent.ConcurrentLinkedQueue;

public class BinarySearchTree {
    protected Node root;

    // Root Getter
    public Node getRoot() {
        return root;
    }

    // Insert Node
    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            insert(data, root);
        }
    }

    // Recursively Insert Node
    private void insert(int data, Node node) {
        // if the inputted data is less than the current node's data, continue to the
        // left subtree
        if (data < node.data) {
            // if the left child is null, insert the node here
            if (node.left == null) {
                node.left = new Node(data);
                node.left.parent = node;
            }
            // otherwise, insert into the left subtree
            else {
                insert(data, node.left);
            }
        }
        // if the inputted data is greater than the current node's data, continue to the
        // right subtree
        else if (data > node.data) {
            // if the right child is null, insert the node here
            if (node.right == null) {
                node.right = new Node(data);
                node.right.parent = node;
            }
            // otherwise, insert into the right subtree
            else {
                insert(data, node.right);
            }
        }
        // if the inputted data is equal to the current node's data, throw an exception
        else {
            throw new IllegalArgumentException("This tree already contains a node with value " + data);
        }
    }

    // Delete Node
    public void delete(int data) {
        if (root == null) {
            return;
        } else {
            delete(data, root);
        }
    }

    // Recursively Delete Node
    private void delete(int data, Node node) {
        // if the inputted data is less than the current node's data, continue to the
        // left subtree
        if (data < node.data) {
            if (node.left != null) {
                delete(data, node.left);
            }
        }
        // if the inputted data is greater than the current node's data, continue to the
        // right subtree
        else if (data > node.data) {
            if (node.right != null) {
                delete(data, node.right);
            }
        }
        // once the recursion has found the node to delete, delete it
        else {
            // if the node has 2 children, replace the node with the minimum value in the
            // right subtree and delete that node
            if (node.left != null && node.right != null) {
                node.data = node.right.min();
                delete(node.data, node.right);
            }
            // if the node only has one child, replace the node with its child
            // checks to see if the node is a left or right child of the parent and then
            // updates the parent to update the child
            else if (node.parent.left == node) {
                node.parent.left = node.left != null ? node.left : node.right;
            } else if (node.parent.right == node) {
                node.parent.right = node.left != null ? node.left : node.right;
            }
        }
    }

    // Search Node
    public Node search(int data) {
        if (root == null) {
            return null;
        } else {
            return search(data, root);
        }
    }

    // Recursively Search Node
    private Node search(int data, Node node) {
        // if the inputted data is equal to the current node's data, return the node
        if (data == node.data) {
            return node;
        }
        // if the inputted data is less than the current node's data, continue to the
        else if (data < node.data) {
            if (node.left != null) {
                return search(data, node.left);
            }
        }
        // if the inputted data is greater than the current node's data, continue to the
        else {
            if (node.right != null) {
                return search(data, node.right);
            }
        }

        // if the inputted data is not found, return null
        return null;
    }

    // Level Traversal
    public void levelTraversal() {
        if (root == null) {
            return;
        }

        // Create a queue and add the root node
        ConcurrentLinkedQueue<Node> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);

        // While the queue is not empty, poll the queue and print the data polling
        // removes the first node in the queue and saves it to temp after polling, add
        // the left node and then the right node if applicable to the end of the queue
        // it will run until the queue is empty when there are no more children nodes
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.data + " ");

            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    // In-Order Traversal
    public void inOrderTraversal() {
        if (root == null) {
            return;
        }

        inOrderTraversal(root);
    }

    // Recursively In-Order Traversal
    private void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        // Traversing the left subtree until there are not more left children and then
        // on the way back print the left node and traverse the right subtree of each
        // traversal
        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }

    // Pre-Order Traversal
    public void preOrderTraversal() {
        if (root == null) {
            return;
        }

        preOrderTraversal(root);
    }

    // Recursively Pre-Order Traversal
    private void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        // Traverse the left subtree while printing the node and then on the way back
        // traverse the right subtree of each traversal while printing the node
        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    // Post-Order Traversal
    public void postOrderTraversal() {
        if (root == null) {
            return;
        }

        postOrderTraversal(root);
    }

    // Recursively Post-Order Traversal
    private void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        // Traverse the left subtree and on the way back traverse the right subtree of
        // each traversal while printing the node and then print the left node
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + " ");
    }
}
