package Algorithms;

import java.math.BigInteger;

public class BitManipulation {
    public static void main(String[] args) {
        BitManipulation bm = new BitManipulation();
        String a = "11";
        String b = "1";
        String ans = bm.addBinary(a, b);
        System.out.println(ans);
    }

    public String addBinary(String a, String b) {
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        BigInteger carry;
        BigInteger ans;

        while (y.compareTo(new BigInteger("0", 2)) != 0) {
            ans = x.xor(y); // 1 for different bits 0 for same bits
            carry = x.and(y).shiftLeft(1); // finds same bits and shifts them left by 1
            x = ans;
            y = carry;
        }

        return x.toString(2);
    }
}
