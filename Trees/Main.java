package Trees;

public class Main {
    public static void main(String[] args) {
        RedBlackBinarySearchTree tree = new RedBlackBinarySearchTree();

        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        tree.insert(9);
        tree.insert(10);
        tree.insert(11);
        tree.insert(12);
        tree.insert(13);
        tree.insert(14);
        tree.insert(15);
        BinaryTreePrinter.printNode(tree.root);

        System.out.println("Level Traversal:");
        tree.levelTraversal();

        System.out.println("\nIn-Order Traversal:");
        tree.inOrderTraversal();

        System.out.println("\nPre-Order Traversal:");
        tree.preOrderTraversal();

        System.out.println("\nPost-Order Traversal:");
        tree.postOrderTraversal();

        System.out.println("\n\n Original Tree:");

        System.out.println("\n\nDeleting 3...");
        tree.delete(3);
        BinaryTreePrinter.printNode(tree.root);

        System.out.println("\n\n Searching for 10...");
        System.out.println(tree.search(10));

    }
}
