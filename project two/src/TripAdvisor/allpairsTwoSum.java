package TripAdvisor;

import java.util.Arrays;

/**
 * Created by hellsapphire on 10/31/2015.
 */
public class allpairsTwoSum {

    public static void main(String[] args) {
        int[] A = {0, 1, 2, 2, 9, 8, 7, 6, 3, 4, 5};
        pairofK(A, 6);
    }

    public static void pairofK(int[] A, int k) {
        int l = 0;
        int r = A.length - 1;
        Arrays.sort(A);

        while (l < A.length && A[l] <= k && l < r) {
            while (A[l] + A[r] >= k && l < r) {
                if (A[l] + A[r] == k) {
                    System.out.println(A[l] + ", " + A[r]);
                }
                r--;
            }
            r++;
            l++;
        }
    }
}
