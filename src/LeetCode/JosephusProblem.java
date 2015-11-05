package LeetCode;

import java.util.ArrayList;

/**
 * Created by hellsapphire on 10/22/2015.
 * N children in a circle, kth removal
 */
public class JosephusProblem {

    public static void main(String[] args) {
        int n = 14;
        int k = 2;
        ArrayList<Integer> alst = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            alst.add(i);
        }
        solveJosephus(k - 1, alst,  0);
    }

    public static void solveJosephus(int k, ArrayList<Integer> alst, int h) {
        if (alst.size() == 1) {
            System.out.println(alst.remove(0));
            return;
        }
        if (alst.size() > 1) {
            int rem = (h + k) % alst.size();
            System.out.println(alst.remove(rem));
            solveJosephus(k, alst, (rem) % alst.size());
            return;
        }

    }

}
