package bAsics;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hellsapphire on 10/10/2015.
 */
public class nTonRec {
    static int count = 0;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        int n = 3;
        int[] A = new int[n];
        processNToN(n, 0, n - 1, A);
        System.out.println(count);
    }

    public static void processNToN(int n, int start, int end, int[] A) {

        if (start > end) {
            count++;
            StringBuilder str = new StringBuilder();
            for (int x : A) {
                str.append(x);
            }
            System.out.println(str.toString());
            set.add(str.toString());
            return;
        }


        for (int j = 0; j < n; j++) {
            A[start] = j;
            processNToN(n, start + 1, end, A);
        }


    }
}
