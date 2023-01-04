package Heaps;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // adds items to the priority queue
        pq.add(5);
        pq.add(3);
        pq.add(17);
        pq.add(10);
        pq.add(84);
        pq.add(19);
        pq.add(6);
        pq.add(22);

        // saves the highest priority element and removes it from the priority queue
        int highestPriorityElement = pq.poll();

        // prints the saved highest priority element of the priority queue
        System.out.println("Saved Highest Priority Element: " + highestPriorityElement);

        // prints the highest priority element of the priority queue
        System.out.println("Highest Priority Element: " + pq.peek());

        // removes the highest priority element of the priority queue
        pq.remove();
    }
}
