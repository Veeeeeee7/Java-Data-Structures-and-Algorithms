package Algorithms;

import java.util.*;

public class StringArray {

    // Merge String Alternately
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        if (word1.length() > word2.length()) {
            for (int i = 0; i < word2.length(); i++) {
                sb.append(word1.charAt(i));
                sb.append(word2.charAt(i));
            }
            sb.append(word1.substring(word2.length()));
        } else {
            for (int i = 0; i < word1.length(); i++) {
                sb.append(word1.charAt(i));
                sb.append(word2.charAt(i));
            }
            sb.append(word2.substring(word1.length()));
        }

        return sb.toString();
    }

    // Greatest Common Divisor of Strings
    public String gcdOfStrings(String str1, String str2) {
        if ((str1 + str2).equals(str2 + str1)) {
            return str1.substring(0, gcd(str1.length(), str2.length()));
        }
        return "";
    }

    public int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    // Kids With the Greatest Number of Candies
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }

        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            if (max <= candies[i] + extraCandies) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }

    // Can Place Flowers
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean left = (i == 0) || (flowerbed[i - 1] == 0);
                boolean right = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);

                if (left && right) {
                    flowerbed[i] = 1;
                    count++;
                    if (count >= n) {
                        return true;
                    }
                }
            }
        }
        return count >= n;
    }

    // Reverse Vowels of a String
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

    // Reverse Words in a String
    public String reverseWords(String s) {
        s = s.trim();
        List<String> list = Arrays.asList(s.split("\\s+"));
        // int left = 0;
        // int right = list.size() - 1;

        // while (left < right) {
        // String temp = list.set(left, list.get(right));
        // list.set(right, temp);
        // left++;
        // right--;
        // }

        // return String.join(" ", list);

        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Product of Array Except Self
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 1;
        for (int i = 1; i < left.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        right[right.length - 1] = 1;
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = left[i] * right[i];
        }

        return ans;
    }

    // Increasing Triplet Subsequence
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= first) {
                first = nums[i];
            } else if (nums[i] <= second) {
                second = nums[i];
            } else if (first < second) {
                return true;
            }
        }
        return false;
    }
}
