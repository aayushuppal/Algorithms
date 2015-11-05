package Test;

import java.util.*;

/**
 * Created by hellsapphire on 11/1/2015.
 */
public class Solution {

    public static void main(String[] args) {
        int[] l = {7, 5, 4, 2};
        calChocs(6, 2, 2, 0);


    }


    public static int calChocs(int N, int C, int M, int wrappers) {
        if (N < C && wrappers < M) {
            return 0;
        }

        int count = 0;

        if (N >= C) {
            count += N / C;
            wrappers = count;
            N = 0;
        }

        while (wrappers >= M) {
            int newChocs = wrappers / M;
            count += newChocs;
            wrappers = (wrappers - (M * newChocs)) + newChocs;
        }

        System.out.println(count);
        return count;
    }


}
