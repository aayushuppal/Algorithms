package TripAdvisor;

import java.util.Arrays;

/**
 * Created by hellsapphire on 10/31/2015.
 */
public class TripletSum {

    public static void main(String[] args) {
        int[] A = {0, 1, 2, 2, 9, 8, 7, 6, 3, 4, 5};
        tripletOfK(A, 6);
    }

        public static void tripletOfK(int[] A, int k) {
            int i = 0;
            int r = A.length - 1;

            Arrays.sort(A);

            while (A[i] <= k && i <= A.length - 3) {

                int l = i + 1;

                while (l <= A.length - 2 && l < r) {
                    while (l < r && A[l] + A[r] >= k - A[i]) {
                        if (A[l] + A[r] == k - A[i]) {
                            System.out.println(A[i] + ", " + A[l] + ", " + A[r]);
                        }
                        r--;
                    }
                    r++;
                    l++;
                }
                i++;
            }
        }

}
