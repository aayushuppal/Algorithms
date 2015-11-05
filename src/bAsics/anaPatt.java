package bAsics;

/**
 * Created by hellsapphire on 10/15/2015.
 * anagram pattern zenefits count
 * output me the number of substrings in input that is an anagram of pattern
 */
public class anaPatt {

    public static void main(String[] args) {
        String in = "cabbcadcab";
        String pat = "abc";

        System.out.println(getMatchCount(in, pat));
    }

    public static int getMatchCount(String in, String pat) {
        int res = 0;
        int[] toFind = new int[256];
        int[] hasFound = new int[256];

        for (char c : pat.toCharArray()) {
            toFind[c]++;
        }

        int count = 0;
        int pL = pat.length();
        int sL = in.length();

        for (char c : in.substring(0, pL).toCharArray()) {
            if (toFind[c] == 0) {
                continue;
            }

            hasFound[c]++;
            if (hasFound[c] <= toFind[c]) {
                count++;
            }
        }
        if (count == pL) {
            res++;
        }
        char[] inArr = in.toCharArray();

        for (int i = 1; i <= sL - pL; i++) {
            char prev = inArr[i - 1];
            char curr = inArr[i + pL - 1];

            if (toFind[prev] != 0) {
                hasFound[prev]--;
                if (hasFound[prev] < toFind[prev]) {
                    count--;
                }
            }

            if (toFind[curr] != 0) {
                hasFound[curr]++;
                if (hasFound[curr] <= toFind[curr]) {
                    count++;
                }
            }
            if (count == pL) {
                res++;
            }
        }

        return res;
    }
}
