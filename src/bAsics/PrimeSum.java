package bAsics;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by hellsapphire on 10/21/2015.
 * Prime Sum
 * <p/>
 * Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.
 * <p/>
 * NOTE A solution will always exist. read Goldbach’s conjecture
 * <p/>
 * Example:
 * <p/>
 * <p/>
 * Input : 4
 * Output: 2 + 2 = 4
 * <p/>
 * If there are more than one solutions possible, return the lexicographically smaller solution.
 * <p/>
 * If [a, b] is one solution with a <= b,
 * and [c,d] is another solution with c <= d, then
 * [a, b] < [c, d]
 * If a < c OR a==c AND b < d.
 */
public class PrimeSum {

    public static void main(String[] args) {
        int n = 16777214;
        ArrayList<Integer> arLs = primesum(n);
        System.out.println(arLs.get(0) + "," + arLs.get(1));

    }

    public static ArrayList<Integer> primesum(int a) {
        int[] setOP = sieveErasto(a);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 2; i < setOP.length; i++) {
            int x = i;
            int y = a - i;
            if (setOP[x] == 0 && setOP[y] == 0) {
                res.add(x);
                res.add(y);
                break;
            }
        }


        return res;
    }

    public static int[] sieveErasto(int n) {
        int[] res = new int[n + 1];
        for (int i = 2; i * i <= n; i++) {
            int s = i;
            while (s * i <= n) {
                res[s * i] = 1;
                s++;
            }
        }
        return res;
    }

}
