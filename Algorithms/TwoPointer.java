package Algorithms;

import java.util.*;

public class TwoPointer {
    public static void main(String[] args) {
        TwoPointer tp = new TwoPointer();
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> res = tp.threeSum(nums);
        System.out.println(res);

        String s = "bottle";
        String ans = tp.reverseVowels(s);
        System.out.println(ans);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSum(nums, i, res);
            }
        }
        return res;
    }

    public void twoSum(int[] nums, int i, List<List<Integer>> res) {
        int low = i + 1;
        int high = nums.length - 1;
        int sum = 0;
        while (low < high) {
            sum = nums[i] + nums[low] + nums[high];
            if (sum < 0) {
                low++;
            } else if (sum > 0) {
                high--;
            } else {
                List<Integer> ans = new ArrayList<>();
                ans.add(nums[i]);
                ans.add(nums[low++]);
                ans.add(nums[high--]);
                res.add(ans);
                while (low < high && nums[low] == nums[low - 1]) {
                    low++;
                }
            }
        }
    }

    public boolean isVowel(char x) {
        return (x == 'a') || (x == 'e') || (x == 'i') || (x == 'o') || (x == 'u') || (x == 'A') || (x == 'E')
                || (x == 'I') || (x == 'O') || (x == 'U');
    }

    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;

        char[] chars = s.toCharArray();

        while (left < right) {
            while (left < s.length() && !isVowel(chars[left])) {
                left++;
            }
            while (right >= 0 && !isVowel(chars[right])) {
                right--;
            }

            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;

                left++;
                right--;
            }
        }

        return new String(chars);
    }
}
