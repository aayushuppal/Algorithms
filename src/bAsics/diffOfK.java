package bAsics;

import java.util.Arrays;

/**
 * Created by hellsapphire on 10/12/2015.
 */
public class diffOfK {

    public static void main(String[] args) {
        //int[] A = {3, 7, 2, 1, 1, 9, 4, 9};
        int[] A = {1, 3, 2, 4, 4, 5};
        System.out.println(calKdiff(A, 2));
    }

    public static int calKdiff(int[] A, int K) {
        int count = 0;
        Arrays.sort(A);
        int cPoint = 1;
        int start = 0;

        while (start != A.length - 1) {

            while (cPoint < A.length && A[cPoint] - A[start] <= K) {
                if (A[cPoint] - A[start] == K) {
                    count++;
                    System.out.println(A[cPoint] + "," + A[start]);
                }
                cPoint++;
            }
            cPoint--;
            start++;
        }

        return count;
    }
}
