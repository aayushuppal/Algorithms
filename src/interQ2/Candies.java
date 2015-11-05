package interQ2;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Candies {

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] S = new int[num];
        for (int i=0; i<num; i++){
            in.nextLine();
            S[i] = in.nextInt();
        }*/
        int[] S = {1, 2, 2};
        calCandy(S);
    }

    public static void calCandy(int[] S) {
        int[] C = new int[S.length];

        for (int j = 0; j < S.length; j++) {
            if (trough(j, S)) {
                C[j] = 1;
            }
        }

        for (int j = 0; j < S.length; j++) {
            if (j < S.length - 1 && C[j] == 1) {
                j++;
                while (C[j] != 1 && !crest(j, S)) {
                    C[j] = Math.max(C[j - 1] + 1, C[j]);
                    j++;
                }
                if (crest(j, S)) {
                    C[j] = Math.max(C[j - 1] + 1, C[j]);
                }

            }
        }

        for (int j = S.length - 1; j >= 0; j--) {
            if (j > 0 && C[j] == 1) {
                j--;
                while (C[j] != 1 && !crest(j, S)) {
                    C[j] = Math.max(C[j + 1] + 1, C[j]);
                    j--;
                }
                if (crest(j, S)) {
                    C[j] = Math.max(C[j + 1] + 1, C[j]);
                }

            }
        }

        int res = 0;
        for (int o : C) {
            res += o;
        }

        System.out.println(res);

    }

    public static boolean trough(int index, int[] S) {
        if (index == 0) {
            return S[index] <= S[index + 1];
        } else if (index == S.length - 1) {
            return S[index] <= S[index - 1];
        } else if (S[index] <= S[index + 1] && S[index - 1] >= S[index]) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean crest(int index, int[] S) {
        if (index == 0) {
            return S[index] > S[index + 1];
        } else if (index == S.length - 1) {
            return S[index] > S[index - 1];
        } else if (S[index] > S[index + 1] && S[index - 1] < S[index]) {
            return true;
        } else {
            return false;
        }
    }


}