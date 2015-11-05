package bAsics;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by hellsapphire on 10/17/2015.
 */
public class patMatch {

    public static void main(String[] args) {
        HashMap<Integer,Integer> mpas = new HashMap<>();
        mpas.put(1,2);
        Collection x = mpas.values();

        String in = "asnfdsfbcsdisdsnbcdbc";
        String pat = "a*b+c";
        System.out.println(isMatch(in, pat));
    }

    public static boolean isMatch(String a, String p) {
        char[] A = a.toCharArray();
        char[] P = p.toCharArray();
        char[] T = new char[A.length];
        int patI = -1;

        for (int i = 0; i < A.length; i++) {
            if (patI == -1) {
                if (A[i] == P[patI + 1]) {
                    patI++;
                } else {
                    break;
                }
            }

            if (funcCheck(A[i], P[patI + 1])) {
                patI++;
            } else if (funcCheck(A[i], P[patI])) {

            }


        }

        if (patI < P.length - 1) {
            return false;
        }
        return true;
    }

    private static boolean funcCheck(char a, char b) {
        if (b == '*') {
            return true;
        } else if (a == '+') {
            return true;
        } else if (a == b) {
            return true;
        } else {
            return false;
        }
    }
}
