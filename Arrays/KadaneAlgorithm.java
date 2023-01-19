package Arrays;

public class KadaneAlgorithm {
    public static void maxSubArraySum(int[] arr) {
        int max = Integer.MIN_VALUE;
        int currentSum = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum > max) {
                max = currentSum;
                end = i;
            }
            if (currentSum < 0) {
                currentSum = 0;
                start = i + 1;
            }
        }

        System.out.println("Maximum contiguous sum is " + max);
        System.out.println("Starting index " + start);
        System.out.println("Ending index " + end);
    }
}
