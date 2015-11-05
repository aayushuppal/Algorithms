package bAsics;

/**
 * Created by hellsapphire on 10/15/2015.
 * Majority Number I
 */
public class MajNumI {

    public static void main(String[] args) {
        int[] A = {1, 1, 2, 1, 2, 2, 1};

        int voted = A[0];
        int votes = 1;

        for (int x : A) {
            if (x == voted) {
                votes++;
            } else {
                votes--;
            }

            if (votes == 0) {
                voted = x;
                votes = 1;
            }
        }

        System.out.println(voted);
    }
}
