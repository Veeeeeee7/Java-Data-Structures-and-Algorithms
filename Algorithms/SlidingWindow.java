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

    // Maximum Number of Vowels in a Substring of Given Length
    public int maxVowels(String s, int k) {
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }
        int max = count;
        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
            if (isVowel(s.charAt(i - k))) {
                count--;
            }

            if (count > max) {
                max = count;
            }
        }
        return max;
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    // Max Consecutive Ones III
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                k--;
            }
            if (k < 0) {
                k++;
                k -= nums[left];
                left++;
            }
            right++;
        }
        return right - left;
    }

    // longest Subarray of 1's After Deleting One Element
    public int longestSubarray(int[] nums) {
        int max = 0;
        int left = 0;
        int right = 0;
        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero++;
                while (zero > 1) {
                    if (nums[left] == 0) {
                        zero--;
                    }
                    left++;
                }
            }
            right++;
            max = Math.max(max, right - left);
        }
        return max - 1;
    }
}
