package Trees.BinarySearchTreeImplementation;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(25);
        tree.insert(20);
        tree.insert(15);
        tree.insert(27);
        tree.insert(30);
        tree.insert(29);
        tree.insert(26);
        tree.insert(22);
        tree.insert(32);

        tree.traverseInOrder();

        System.out.println("\n" + tree.get(252));
        System.out.println(tree.get(27));

        System.out.println(tree.min());
        System.out.println(tree.max());

        tree.delete(25);
        tree.traverseInOrder();
    }
}
