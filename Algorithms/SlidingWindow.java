package Algorithms;

public class SlidingWindow {
    // Maximum Average Subarray I
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        ans = sum;

        for (int i = k; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[i - k];
            ans = ans > sum ? ans : sum;
        }

        return (double) ans / k;
    }
}
