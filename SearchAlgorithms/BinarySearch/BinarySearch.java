package SearchAlgorithms.BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] intArray = { -22, -15, 1, 7, 20, 35, 55 };

        System.out.println("Iterative Binary Search");
        System.out.println(iterativeBinarySearch(intArray, -15));
        System.out.println(iterativeBinarySearch(intArray, 1));
        System.out.println(iterativeBinarySearch(intArray, 8888));
        System.out.println(iterativeBinarySearch(intArray, -22));

        System.out.println("Recursive Binary Search");
        System.out.println(recursiveBinarySearch(intArray, -15));
        System.out.println(recursiveBinarySearch(intArray, 1));
        System.out.println(recursiveBinarySearch(intArray, 8888));
        System.out.println(recursiveBinarySearch(intArray, -22));
    }

    // iterative binary search
    public static int iterativeBinarySearch(int[] input, int value) {
        int start = 0;
        int end = input.length;

        // loops until the start >= end (ie the value is not found) and returns -1 if
        // not found
        while (start < end) {
            int midpoint = (start + end) / 2;
            // System.out.println("midpoint: " + midpoint);

            // if the midpoint is the value, return the midpoint
            if (input[midpoint] == value) {
                return midpoint;
            }

            // if the midpoint is less than the value, set the start to the midpoint + 1 (ie
            // search the right side of the midpoint)
            else if (input[midpoint] < value) {
                start = midpoint + 1;
            }

            // if the midpoint is greater than the value, set the end to the midpoint (ie
            // search the left side of the midpoint)
            else {
                end = midpoint;
            }
        }
        return -1;
    }

    // recursive binary search
    // performs slightly worse than iterative binary search because there is
    // overhead in running a method
    public static int recursiveBinarySearch(int[] input, int value) {
        return recursiveBinarySearch(input, 0, input.length, value);
    }

    public static int recursiveBinarySearch(int[] input, int start, int end, int value) {
        // if the start >= end (ie the value is not found) return -1
        if (start >= end) {
            return -1;
        }

        int midpoint = (start + end) / 2;

        // if the midpoint is the value, return the midpoint
        if (input[midpoint] == value) {
            return midpoint;
        }

        // if the midpoint is less than the value, set the start to the midpoint + 1 (ie
        // search the right side of the midpoint)
        else if (input[midpoint] < value) {
            return recursiveBinarySearch(input, midpoint + 1, end, value);
        }

        // if the midpoint is greater than the value, set the end to the midpoint (ie
        // search the left side of the midpoint)
        else {
            return recursiveBinarySearch(input, start, midpoint, value);
        }
    }
}
