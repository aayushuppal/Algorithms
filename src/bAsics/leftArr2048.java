package bAsics;

/**
 * Created by hellsapphire on 10/25/2015.
 * <p/>
 * left double up and shift to left routine for 2048 game   "leftDoublerShifter"
 * next step is to bubble up zeros and maintain order of other elments  "zeroshiftLefter"
 * <p/>
 * bloomberg
 */
public class leftArr2048 {

    public static void main(String[] args) {
        int[] A = {4, 0, 2, 0, 0, 2, 4};
        int[] B = {8, 0, 0, 0, 4};
        int[] C = {16, 0, 0, 0, 0};

        int[] X = A;
        pushToLeft(X);
        for (int x : X) {
            System.out.print(x + ", ");
        }
    }


    public static void pushToLeft(int[] A) {
        leftDoublerShifter(A);
        zeroshiftLefter(A);
    }

    private static void leftDoublerShifter(int[] A) {
        int n = A.length;
        int i = 0;
        // find first non zero starting point
        while (A[i] == 0) {
            i++;
        }

        boolean whileFlag = true;
        while (i < n - 1 && whileFlag) {
            int j;
            for (j = i + 1; j <= n - 1; j++) {
                if (A[j] == 0) {
                    continue;
                } else if (A[j] != A[i]) {
                    i = j;
                    break;
                } else {
                    A[i] = 2 * A[i];
                    A[j] = 0;
                    whileFlag = false;
                    leftDoublerShifter(A);
                    break;
                }
            }

            if (j == n) {
                whileFlag = false;
            }

        }

    }

    private static void zeroshiftLefter(int[] A) {
        int n = A.length;
        int i = 0;

        while (i < n) {

            // get first zero
            while (i < n && A[i] != 0) {
                i++;
            }
            if (i >= n || A[i] != 0) {
                break;
            }

            // get first non zero
            int j = i + 1;
            while (j < n && A[j] == 0) {
                j++;
            }
            if (j >= n || A[j] == 0) {
                break;
            }

            // swap
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;

        }
    }
}
