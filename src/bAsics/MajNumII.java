package bAsics;

/**
 * Created by hellsapphire on 10/15/2015.
 * Majority Number II Zenefits
 */
public class MajNumII {

    public static void main(String[] args) {
        int[] A = {1, 1, 3, 3, 5, 7, 3, 3, 5};

        int m = 0, n = 0, c1 = 0, c2 = 0;

        for (int x : A) {
            if (x == m) {
                c1++;
            } else if (x == n) {
                c2++;
            } else if (c1 == 0) {
                m = x;
                c1++;
            } else if (c2 == 0) {
                n = x;
                c2++;
            } else {
                c1--;
                c2--;
            }
        }

        c1 = 0;
        c2 = 0;

        for (int x : A) {
            if (x == m) {
                c1++;
            } else if (x == n) {
                c2++;
            }
        }

        int x = c1 > c2 ? m : n;
        System.out.println(x);
    }
}
