package bAsics;

/**
 * Created by hellsapphire on 10/15/2015.
 * 2D Matrix iterator
 * Zenefits
 */
public class TwoDMatrixIter {

    public static void main(String[] args) {
        int[][] M = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        int R = M.length - 1;
        int C = M[0].length - 1;
        Iter(M, 0, R, 0, C);
    }

    public static void Iter(int[][] M, int rS, int rE, int cS, int cE) {
        if (rS > rE || cS > cE) {
            return;
        }

        for (int i = cS; i <= cE; i++) {
            System.out.println(M[rS][i]);
        }

        for (int i = rS + 1; i <= rE; i++) {
            System.out.println(M[i][cE]);
        }

        for (int i = cE - 1; i >= cS; i--) {
            System.out.println(M[rE][i]);
        }

        for (int i = rE - 1; i >= rS + 1; i--) {
            System.out.println(M[i][cS]);
        }

        rS++;
        rE--;

        cS++;
        cE--;

        Iter(M, rS, rE, cS, cE);

    }
}
