package BucketSortImplementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSort {
    public static void main(String[] args) {
        int[] intArray = { 54, 46, 83, 66, 95, 92, 43 };

        bucketSort(intArray);

        for (int i : intArray) {
            System.out.println(i);
        }
    }

    public static void bucketSort(int[] input) {
        List<Integer>[] buckets = new List[10];

        // Creates the buckets
        for (int i = 0; i < buckets.length; i++) {
            // buckets[i] = new LinkedList<Integer>();
            buckets[i] = new ArrayList<Integer>();
        }

        // Distributes the values into the buckets using their hashed value
        for (int i = 0; i < input.length; i++) {
            buckets[hash(input[i])].add(input[i]);
        }

        // Sorts the buckets using the Collections.sort() method (uses merge sort)
        for (List bucket : buckets) {
            Collections.sort(bucket);
        }

        // Concatenates the buckets back into the input array
        int j = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int value : buckets[i]) {
                input[j++] = value;
            }
        }
    }

    // Hashes the value
    private static int hash(int value) {
        return value / (int) 10;
    }
}
