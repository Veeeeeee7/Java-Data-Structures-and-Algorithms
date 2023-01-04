package HeapSortImplementation;

import java.util.PriorityQueue;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = { 80, 75, 60, 68, 55, 40, 52, 67 };

        heapSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void heapSort(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // add all elements to the priority queue
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }

        // remove the root of the heap and add it to the array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = pq.poll();
        }
    }
}
