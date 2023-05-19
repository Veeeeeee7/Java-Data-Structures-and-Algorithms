package Algorithms;

public class GCDStrings {
    public static void main(String[] args) {
        String str1 = "ABCABC";
        String str2 = "ABC";
        GCDStrings gcd = new GCDStrings();
        System.out.println(gcd.gcdOfStrings(str1, str2));
    }

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

}
