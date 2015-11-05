package LeetCode;

import java.util.ArrayList;

/**
 * Created by hellsapphire on 10/22/2015.
 * Convert preorder to postorder bst
 */
public class preToPost {

    public static void main(String[] args) {
        int[] preIn = {5, 3, 2, 1, 4, 9, 7};
        ArrayList<Integer> postL = new ArrayList<>();
        preToPost(preIn, postL, 0, preIn.length - 1);

    }

    public static void preToPost(int[] pre, ArrayList<Integer> postL, int l, int r) {
        if (l == r) {
            postL.add(pre[l]);
            return;
        }

        if (l < r) {
            int i;
            for (i = l; i <= r; i++) {
                if (pre[i] > pre[l]) {
                    break;
                }
            }
            preToPost(pre, postL, l + 1, i - 1);
            preToPost(pre, postL, i, r);
            postL.add(pre[l]);
            return;
        }

    }

}

