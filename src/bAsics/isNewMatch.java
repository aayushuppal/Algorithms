package bAsics;

/**
 * Created by hellsapphire on 10/21/2015.
 * coffee meets bagel
 */
public class isNewMatch {

    public static void main(String[] args) {
        int mid = 5;
        int[] oid = {3, 7, 9, 11};
        System.out.println(IsNewMatch(mid, oid));
    }

    static boolean IsNewMatch(int match_id, int[] sorted_old_match_ids) {
        if (bSrch(sorted_old_match_ids,match_id,0,sorted_old_match_ids.length-1)){
            return false;
        } else {
            return true;
        }
    }


    private static boolean bSrch(int[] A, int val, int i, int j) {
        if (i > j) {
            return false;
        }
        int m = (i + j) / 2;
        if (A[m] == val) {
            return true;
        } else if (A[m] > val) {
            return bSrch(A, val, i, m - 1);
        } else {
            return bSrch(A, val, m + 1, j);
        }
    }
}
