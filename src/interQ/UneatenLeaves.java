package interQ;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by hellsapphire on 9/24/2015.
 */
public class UneatenLeaves {

    public static void main(String[] args) {
        int[] A = {4, 5, 2};
        System.out.println(countUneatenLeaves(10, A));
    }

    static int countUneatenLeaves(int N, int[] A) {
        int lcm = A[0];
        if (A.length > 1) {
            int i=1;
            while (i < A.length) {
                lcm = getLcm(lcm, A[i]);
                i++;
            }
        }
        int leafCount = N;
        Set<Integer> jumpSet = new TreeSet<Integer>();
        for (int x : A) {
            jumpSet.add(x);
        }

        for (int i = 1; i <= N; i++) {
            if (isDivisible(i, jumpSet)) {
                leafCount--;
            }
        }

        return leafCount;
    }

    static boolean isDivisible(int leafNum, Set<Integer> Jum) {
        for (int a : Jum) {
            if (leafNum % a == 0) {
                if (a < leafNum && Jum.contains(leafNum)) {
                    Jum.remove(leafNum);
                }
                return true;
            }
        }
        return false;
    }

    static int getLcm(int a, int b)
    {
        return a * (b / findGCD (a, b));
    }

    static int findGCD(int number1, int number2) {
        //base case
        if(number2 == 0)
        {
            return number1;
        }

        return findGCD(number2, number1%number2);
    }
}
