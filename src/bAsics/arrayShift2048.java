package bAsics;

/**
 * Created by hellsapphire on 10/25/2015.
 */
public class arrayShift2048 {

    public static void main(String[] args) {
        //int[] A = {2, 0, 2, 4, 0, 8, 2, 0, 2};
        int[] A = {4, 0, 2, 0, 2,4};
        leftShift(A);

        for (int x : A) {
            System.out.print(x + ", ");
        }

    }

    public static void leftShift(int[] A) {
        zeroshiftLefter(A);
        lefter(A);
    }

    private static void lefter(int[] A){
        int n = A.length;
        int i = 0;

        while (i < n - 1) {

            if (A[i] == 0) {
                i++;
            } else {
                int j = i + 1;

                while (true) {
                    if (j >= n) {
                        i = j;
                        break;
                    } else if (A[j] == 0) {
                        j++;
                    } else if (A[j] != A[i]) {
                        i = j;
                        break;
                    } else {
                        A[j] = 0;
                        A[i] = 2 * A[i];
                        //j++;

                        i = n;
                        zeroshiftLefter(A);
                        lefter(A);
                    }
                }

            }
        }
    }

    private static void zeroshiftLefter(int[] A){
        int n = A.length;
        int i = 0;

        while (i < n) {

            while (i < n && A[i] != 0) {
                i++;
            }
            if (i >= n || A[i] != 0) {
                break;
            }

            int j = i + 1;
            while (j < n && A[j] == 0) {
                j++;
            }
            if (j >= n || A[j] == 0) {
                break;
            }

            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;

        }
    }
    public static void rightShift(int[] A) {
        int n = A.length;
        int i = n - 1;

        while (i > 0) {

            if (A[i] == 0) {
                i--;
            } else {
                int j = i - 1;

                while (true) {
                    if (j < 0) {
                        i = j;
                        break;
                    } else if (A[j] == 0) {
                        j--;
                    } else if (A[j] != A[i]) {
                        i = j;
                        break;
                    } else {
                        A[j] = 0;
                        A[i] = 2 * A[i];
                        j--;
                    }
                }

            }
        }
    }

}
