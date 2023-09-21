package Algorithms;

public class PrefixSum {
    // Find the Highest Altitude
    public static int largestAltitude(int[] gain) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < gain.length; i++) {
            sum += gain[i];
            max = Math.max(sum, max);
        }
        return max;
    }

    // Find Pivot Index
    public static int pivotIndex(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        int leftTotal = 0;
        for (int i = 0; i < nums.length; i++) {
            leftTotal += nums[i];
            if (total - leftTotal == leftTotal - nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
