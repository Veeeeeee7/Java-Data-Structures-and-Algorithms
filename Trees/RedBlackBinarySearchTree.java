package Trees;

public class RedBlackBinarySearchTree extends BinarySearchTree {
    private static final boolean RED = false;
    private static final boolean BLACK = true;

    // Insert Node
    @Override
    public void insert(int data) {
        Node node = root;
        Node parent = null;

        // Traverse the tree to the left or right depending on the data
        while (node != null) {
            parent = node;
            if (data < node.data) {
                node = node.left;
            } else if (data > node.data) {
                node = node.right;
            } else {
                throw new IllegalArgumentException("BST already contains a node with key " + data);
            }
        }

        // Insert new node
        Node newNode = new Node(data);
        newNode.color = RED;
        if (parent == null) {
            root = newNode;
        } else if (data < parent.data) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        newNode.parent = parent;

        fixRedBlackPropertiesAfterInsert(newNode);
    }

    private void fixRedBlackPropertiesAfterInsert(Node node) {
        Node parent = node.parent;

        // Case 1: Parent is null, we've reached the root, the end of the recursion
        if (parent == null) {
            // Uncomment the following line if you want to enforce black roots (rule 2):
            // node.color = BLACK;
            return;
        }

        // Parent is black --> nothing to do
        if (parent.color == BLACK) {
            return;
        }

        // From here on, parent is red
        Node grandparent = parent.parent;

        // Case 2:
        // Not having a grandparent means that parent is the root. If we enforce black
        // roots
        // (rule 2), grandparent will never be null, and the following if-then block can
        // be
        // removed.
        if (grandparent == null) {
            // As this method is only called on red nodes (either on newly inserted ones -
            // or -
            // recursively on red grandparents), all we have to do is to recolor the root
            // black.
            parent.color = BLACK;
            return;
        }

        // Get the uncle (may be null/nil, in which case its color is BLACK)
        Node uncle = parent.getUncle();

        // Case 3: Uncle is red -> recolor parent, grandparent and uncle
        if (uncle != null && uncle.color == RED) {
            parent.color = BLACK;
            grandparent.color = RED;
            uncle.color = BLACK;

            // Call recursively for grandparent, which is now red.
            // It might be root or have a red parent, in which case we need to fix more...
            fixRedBlackPropertiesAfterInsert(grandparent);
        }

        // Note on performance:
        // It would be faster to do the uncle color check within the following code.
        // This way
        // we would avoid checking the grandparent-parent direction twice (once in
        // getUncle()
        // and once in the following else-if). But for better understanding of the code,
        // I left the uncle color check as a separate step.

        // Parent is left child of grandparent
        else if (parent == grandparent.left) {
            // Case 4a: Uncle is black and node is left->right "inner child" of its
            // grandparent
            if (node == parent.right) {
                parent.rotateLeft();

                // Let "parent" point to the new root node of the rotated sub-tree.
                // It will be recolored in the next step, which we're going to fall-through to.
                parent = node;
            }

            // Case 5a: Uncle is black and node is left->left "outer child" of its
            // grandparent
            grandparent.rotateRight();

            // Recolor original parent and grandparent
            parent.color = BLACK;
            grandparent.color = RED;
        }

        // Parent is right child of grandparent
        else {
            // Case 4b: Uncle is black and node is right->left "inner child" of its
            // grandparent
            if (node == parent.left) {
                parent.rotateRight();

                // Let "parent" point to the new root node of the rotated sub-tree.
                // It will be recolored in the next step, which we're going to fall-through to.
                parent = node;
            }

            // Case 5b: Uncle is black and node is right->right "outer child" of its
            // grandparent
            grandparent.rotateLeft();

            // Recolor original parent and grandparent
            parent.color = BLACK;
            grandparent.color = RED;
        }
    }

    // Delete Node
    @Override
    public void delete(int key) {
        Node node = root;

        // Find the node to be deleted
        while (node != null && node.data != key) {
            // Traverse the tree to the left or right depending on the key
            if (key < node.data) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        // Node not found?
        if (node == null) {
            return;
        }

        // At this point, "node" is the node to be deleted

        // In this variable, we'll store the node at which we're going to start to fix
        // the R-B
        // properties after deleting a node.
        Node movedUpNode;
        boolean deletedNodeColor;

        // Node has zero or one child
        if (node.left == null || node.right == null) {
            if (node.left != null) {
                if (node.parent == null) {
                    root = node.left;
                }
                Node.replaceParentsChild(node.parent, node, node.left);
                movedUpNode = node.left;
            } else if (node.right != null) {
                if (node.parent == null) {
                    root = node.left;
                }
                Node.replaceParentsChild(node.parent, node, node.right);
                movedUpNode = node.right;
            } else {
                Node newChild = node.color == BLACK ? new NilNode() : null;
                movedUpNode = newChild;
            }

            // movedUpNode = deleteNodeWithZeroOrOneChild(node);
            deletedNodeColor = node.color;
        }

        // Node has two children
        else {
            // Find minimum node of right subtree ("inorder successor" of current node)
            Node inOrderSuccessor = new Node(node.right.min());

            // Copy inorder successor's data to current node (keep its color!)
            node.data = inOrderSuccessor.data;

            // Delete inorder successor just as we would delete a node with 0 or 1 child
            if (node.left != null) {
                if (node.parent == null) {
                    root = node.left;
                }
                Node.replaceParentsChild(node.parent, node, node.left);
                movedUpNode = node.left;
            } else if (node.right != null) {
                if (node.parent == null) {
                    root = node.left;
                }
                Node.replaceParentsChild(node.parent, node, node.right);
                movedUpNode = node.right;
            } else {
                Node newChild = node.color == BLACK ? new NilNode() : null;
                movedUpNode = newChild;
            }
            // movedUpNode = deleteNodeWithZeroOrOneChild(inOrderSuccessor);
            deletedNodeColor = inOrderSuccessor.color;
        }

        if (deletedNodeColor == BLACK) {
            fixRedBlackPropertiesAfterDelete(movedUpNode);

            // Remove the temporary NIL node
            if (movedUpNode.getClass() == NilNode.class) {
                if (node.parent == null) {
                    root = node.left;
                }
                Node.replaceParentsChild(movedUpNode.parent, movedUpNode, null);
            }
        }
    }

    private void fixRedBlackPropertiesAfterDelete(Node node) {
        // Case 1: Examined node is root, end of recursion
        if (node == root) {
            // Uncomment the following line if you want to enforce black roots (rule 2):
            // node.color = BLACK;
            return;
        }

        Node sibling = node.getSibling();

        // Case 2: Red sibling
        if (sibling.color == RED) {
            node.handleRedSibling(sibling);
            sibling = node.getSibling(); // Get new sibling for fall-through to cases 3-6
        }

        // Cases 3+4: Black sibling with two black children
        if (sibling.left.isBlack() && sibling.right.isBlack()) {
            sibling.color = RED;

            // Case 3: Black sibling with two black children + red parent
            if (node.parent.color == RED) {
                node.parent.color = BLACK;
            }

            // Case 4: Black sibling with two black children + black parent
            else {
                fixRedBlackPropertiesAfterDelete(node.parent);
            }
        }

        // Case 5+6: Black sibling with at least one red child
        else {
            node.handleBlackSiblingWithAtLeastOneRedChild(sibling);
        }

    }
}
