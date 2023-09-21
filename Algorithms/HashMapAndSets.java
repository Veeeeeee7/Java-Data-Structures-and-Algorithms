package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class HashMapAndSets {
    // Find the Difference of Two Arrays
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (int num : nums1) {
            set1.add(num);
        }

        HashSet<Integer> only2 = new HashSet<Integer>();
        for (int num : nums2) {
            if (!set1.contains(num)) {
                only2.add(num);
            }
        }

        HashSet<Integer> set2 = new HashSet<Integer>();
        for (int num : nums2) {
            set2.add(num);
        }

        HashSet<Integer> only1 = new HashSet<Integer>();
        for (int num : nums1) {
            if (!set2.contains(num)) {
                only1.add(num);
            }
        }
        return Arrays.asList(new ArrayList<>(only1), new ArrayList<>(only2));
    }

    // Unique Number of Occurrences
    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<>();
        for (Integer a : arr) {
            if (map.containsKey(a)) {
                map.put(a, (map.get(a) + 1));
            } else {
                map.put(a, 1);
                list.add(a);
            }
        }

        return list.size() == new HashSet<>(map.values()).size();
    }

    // Determine if Two Strings are Close
    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        Map<Character, Integer> m1 = new HashMap<>();
        for (char c : word1.toCharArray()) {
            if (m1.containsKey(c)) {
                m1.put(c, m1.get(c) + 1);
            } else {
                m1.put(c, 0);
            }
        }

        Map<Character, Integer> m2 = new HashMap<>();
        for (char c : word2.toCharArray()) {
            if (m2.containsKey(c)) {
                m2.put(c, m2.get(c) + 1);
            } else {
                m2.put(c, 0);
            }
        }

        List<Integer> l1 = new ArrayList<>(m1.values());
        List<Integer> l2 = new ArrayList<>(m2.values());
        Collections.sort(l1);
        Collections.sort(l2);

        return l1.equals(l2) && m1.keySet().equals(m2.keySet());
    }

    // Equal Row and Column Pairs
    public static int equalPairs(int[][] grid) {
        Map<String, Integer> rows = new HashMap<>();
        int count = 0;

        for (int[] row : grid) {
            if (rows.containsKey(Arrays.toString(row))) {
                rows.put(Arrays.toString(row), rows.get(Arrays.toString(row)) + 1);
            } else {
                rows.put(Arrays.toString(row), 1);
            }
        }

        for (int i = 0; i < grid.length; i++) {
            int[] col = new int[grid.length];

            for (int j = 0; j < grid[i].length; j++) {
                col[j] = grid[j][i];
            }
            count = rows.containsKey(Arrays.toString(col)) ? count + rows.get(Arrays.toString(col)) : count;
        }
        return count;

    }
}
