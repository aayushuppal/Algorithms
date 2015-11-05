package LeetCode;

import java.util.Arrays;

/**
 * Created by hellsapphire on 10/23/2015.
 * GoDaddy
 * cloest numbers
 * hackerrank
 */
public class ClosestNums {

    public static void main(String[] args) {
        String s = "-20 -3916237 -357920 -3620601 7374819 -7330761 30 80 6246457 -6461594 266854";
        int len = 10;
        System.out.println(closestNumbers(len, s));
    }

    static String closestNumbers(int len, String s) {
        String[] arr = s.split(" ");
        int[] iArr = new int[arr.length];
        int k = 0;
        for (String sx : arr) {
            iArr[k++] = Integer.parseInt(sx);
        }

        Arrays.sort(iArr);

        int minDiff = Integer.MAX_VALUE;
        String res = "";

        for (int i = 0; i <= len - 2; i++) {
            int a = iArr[i];
            int b = iArr[i + 1];
            if (Math.abs(b - a) < minDiff) {
                res = a + " " + b;
                minDiff = Math.abs(b - a);
            } else if (Math.abs(b - a) == minDiff) {
                res += " " + a + " " + b;
            }
        }
        return res;
    }
}
