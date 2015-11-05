package LeetCode;

/**
 * Created by hellsapphire on 10/24/2015.
 */
public class StockMax {

    public static void main(String[] args) {
        int[] prc = {1, 1};

        System.out.println(maxProf(prc));
    }


    public static int maxProf(int[] in) {
        int lmin = -1;
        int lmax = -1;
        int n = in.length - 1;
        int profit = 0;
        while (lmin < n) {
            lmin = getLocalmin(lmin + 1, in, n);

            if (lmin < n) {
                lmax = getLocalMax(lmin + 1, in, n);
            }

            if (lmax > lmin && (in[lmax] - in[lmin]) > 0) {
                profit += (in[lmax] - in[lmin]);
            }

        }
        return profit;

    }

    private static int getLocalmin(int i, int[] A, int n) {
        while (i + 1 <= n && A[i + 1] <= A[i]) {
            i++;
        }
        return i;
    }

    private static int getLocalMax(int i, int[] A, int n) {
        while (i + 1 <= n && A[i + 1] >= A[i]) {
            i++;
        }
        return i;

    }
}
