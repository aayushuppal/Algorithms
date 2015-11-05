package sorting;

import java.util.Arrays;

/**
 * Created by hellsapphire on 10/27/2015.
 * <p/>
 * Search for range of number in a sorted array in O(logn)
 */
public class binaryRangeSearch {
    static int a;

    public static void main(String[] args) {
        int[] A = {4, 1, 1, 2, 9, 2, 3, 3, 3, 4, 4, 5};
        getRange(A, 1);
    }


    public static void getRange(int[] A, int k) {

        IntWrap i = new IntWrap();
        int l = 0;
        int r = A.length - 1;

        int left = -1;
        int right = -1;


        while (recursiveSearch(A, l, r, k, i)) {
            left = i.val;
            r = left - 1;
        }

        l = 0;
        r = A.length - 1;
        while (recursiveSearch(A, l, r, k, i)) {
            right = i.val;
            l = right + 1;
        }

        System.out.println(left + ", " + right);
    }

    public static boolean recursiveSearch(int[] A, int l, int r, int k, IntWrap i) {

        if (l > r) {
            return false;
        }

        int m = (l + r) / 2;

        if (A[m] == k) {
            i.val = m;
            return true;
        }
        return recursiveSearch(A, l, m - 1, k, i) || recursiveSearch(A, m + 1, r, k, i);
    }
}

class IntWrap {
    int val;
}


    