package bAsics;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by hellsapphire on 10/21/2015.
 * Given an unsorted integer array, find the first missing positive integer.
 * <p/>
 * Example:
 * <p/>
 * Given [1,2,0] return 3,
 * <p/>
 * [3,4,-1,1] return 2,
 * <p/>
 * [-8, -7, -6] returns 1
 * <p/>
 * Your algorithm should run in O(n) time and use constant space.
 */
public class missingPositive {

    public static void main(String[] args) {
        Integer[] x = {-8, -7, -6};

        ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(x));
        System.out.println(firstMissingPositive(a));

    }

    public static int firstMissingPositive(ArrayList<Integer> a) {
        int sz = segregate(a);
        if (a.get(0) <= 0) {
            return 1;
        }
        int len = a.size() - sz;
        for (int i = 0; i < len; i++) {
            int val = Math.abs(a.get(i)) - 1;
            if (val < len && a.get(val) > 0) {
                a.set(val, -a.get(val));
            }
        }

        for (int k = 0; k < len; k++) {
            if (a.get(k) > 0) {
                return k + 1;
            }
        }

        return len + 1;
    }

    private static int segregate(ArrayList<Integer> a) {
        int pivot = 1;
        int i = 0;
        int j = a.size() - 1;
        int count = 0;

        while (true) {
            while (i < j && a.get(i) >= pivot) {
                i++;
            }
            while (i < j && a.get(j) < pivot) {
                j--;
            }
            if (i == j) {
                break;
            }
            int temp = a.get(i);
            a.set(i, a.get(j));
            a.set(j, temp);
            count++;
        }
        return count;
    }
}
