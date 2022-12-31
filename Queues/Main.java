package Queues;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Main {
    public static void main(String[] args) {

        /*
         * Queues
         */

        ConcurrentLinkedQueue<Node> queue = new ConcurrentLinkedQueue<>();

        // Add items to the back of the queue
        queue.add(new Node(1));
        queue.add(new Node(5));
        queue.add(new Node(-7));
        queue.add(new Node(3));

        // 1, 5, -7, 3

        // Remove items from the front of the queue
        queue.remove(); // removes 1

        // Peek at the front of the queue
        System.out.println(queue.peek().data);

        /*
         * Deques
         */

        ConcurrentLinkedDeque<Node> deque = new ConcurrentLinkedDeque<>();

        // Add items to the back of the deque
        deque.addLast(new Node(-7));
        deque.addLast(new Node(3));

        // -7, 3

        // Add items to the front of the deque
        deque.addFirst(new Node(5));
        deque.addFirst(new Node(1));

        // 1, 5, -7, 3

        // Remove items from the front/back of the deque
        deque.removeFirst(); // removes 1
        deque.removeLast(); // removes 3

        // Peek at the front/back of the deque
        System.out.println(deque.peekFirst().data);
        System.out.println(deque.peekLast().data);

    }
}
