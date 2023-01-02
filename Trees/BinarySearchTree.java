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

    private void insert(int data, Node node) {
        if (data < node.data) {
            if (node.left == null) {
                node.left = new Node(data);
                node.left.parent = node;
            } else {
                insert(data, node.left);
            }
        } else if (data > node.data) {
            if (node.right == null) {
                node.right = new Node(data);
                node.right.parent = node;
            } else {
                insert(data, node.right);
            }
        } else {
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

    private void delete(int data, Node node) {
        if (data < node.data) {
            if (node.left != null) {
                delete(data, node.left);
            }
        } else if (data > node.data) {
            if (node.right != null) {
                delete(data, node.right);
            }
        } else {
            if (node.left != null && node.right != null) {
                node.data = node.right.min();
                delete(node.data, node.right);
            } else if (node.parent.left == node) {
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

    private Node search(int data, Node node) {
        if (data == node.data) {
            return node;
        } else if (data < node.data) {
            if (node.left != null) {
                return search(data, node.left);
            }
        } else {
            if (node.right != null) {
                return search(data, node.right);
            }
        }

        return null;
    }

    // Level Traversal
    public void levelTraversal() {
        if (root == null) {
            return;
        }

        ConcurrentLinkedQueue<Node> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);

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

    private void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

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

    private void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

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

    private void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + " ");
    }
}
