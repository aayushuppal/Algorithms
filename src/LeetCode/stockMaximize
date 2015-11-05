/*
Stock Maximize

Sample Input

3
3
5 3 2
3
1 2 100
4
1 3 1 2
Sample Output

0
197
3

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        while (in.hasNext()) {
            in.nextLine();
            String[] arr = in.nextLine().split(" ");
            int[] iArr = new int[arr.length];
            int i=0;
            for (String h: arr){
                iArr[i++] = Integer.parseInt(h);
            }
            System.out.println(maxProfit(iArr));
        }
    }
    
    public static long maxProfit(int[] A){
        int[] M = new int[A.length];
        M[A.length-1] = -1;
        long profit = 0;
        for (int i = A.length-2; i>=0; i--){
            M[i] = Math.max(M[i+1],A[i+1]);
            if (M[i]-A[i]>0){
                profit += M[i]-A[i];
            }
        }
        return profit;
    }
    
    
}