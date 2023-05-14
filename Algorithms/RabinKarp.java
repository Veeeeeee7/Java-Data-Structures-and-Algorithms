package Algorithms;

public class RabinKarp {
    public static void main(String[] args) {
        String haystack = "ccaccaacdba";
        String needle = "dba";

        RabinKarp rk = new RabinKarp();
        int index = rk.solution(haystack, needle);
        System.out.println(index);
    }

    public int hashValue(String s, int MOD) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash += ((s.charAt(i) - 'a') * Math.pow(26, i)) % MOD;
        }
        return hash;
    }

    public int solution(String haystack, String needle) {
        if (needle.length() > haystack.length())
            return -1;

        int needleHash = hashValue(needle, 9737333);

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            String sub = haystack.substring(i, i + needle.length());
            int subHash = hashValue(sub, 9737333);
            if (subHash == needleHash) {
                if (sub.equals(needle))
                    return i;
            }
        }

        return -1;
    }
}
