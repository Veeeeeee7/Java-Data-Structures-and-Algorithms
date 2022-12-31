package Lists.CircularlyLinkedLists;

public class Main {
    public static void main(String[] args) {
        CircularlyLinkedList cll = new CircularlyLinkedList();
        cll.add(5);
        cll.add(8);
        cll.add(-2);
        cll.add(11);

        cll.printList();

        cll.remove();
        System.out.println();
        cll.printList();
    }
}
