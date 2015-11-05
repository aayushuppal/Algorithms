package interQ2;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Sert {
    /*
 * Complete the function below.
 */

    static String encodeFibonacci(int n) {
        ArrayList<Integer> fibList = new ArrayList<Integer>();

        if (n >= 2) {
            fibList.add(1);
            fibList.add(2);
            int a = 1;
            int b = 2;

            int top = 2;

            while (top <= n) {
                top = a + b;
                if (top <= n) {
                    fibList.add(top);
                }
                a = b;
                b = top;
            }
        } else {
            int a = n;
            while (a > 0) {
                fibList.add(a--);
            }
        }

        boolean[][] M = new boolean[fibList.size() + 1][n + 1];



        for (int x = 0; x <= n; x++) {
            M[0][x] = false;
        }

        for (int y = 0; y <= fibList.size(); y++) {
            M[y][0] = true;
        }


        for (int i = 1; i <= fibList.size(); i++) {

            for (int j = 1; j <= n; j++) {
                if (M[i - 1][j]) {
                    M[i][j] = true;
                } else {
                    M[i][j] = M[i-1][j-fibList.get(i-1)];
                }
            }

        }


        int [] str = new int[fibList.size()+1];

        int sI = fibList.size();
        int sJ = n;

        while (M[sI-1][sJ]){
            sI = sI-1;
        }

        int a = sI;
        int b = sJ;

        while (a>0 && b>0 && M[a][b]){
            str[a] = 1;
            b = b-fibList.get(a-1);
            a = a-1;
        }


        String res = "";
        for (int p=str.length-1; p>=1; p--){
            res+=str[p];
        }




        /*int[] str = new int[fibList.size()+1];

        int startI = fibList.size();
        int startJ = n;

        while ()M[startI-1][startJ]){
            startI = startI-1;
        }*/


        return res;

    }

    public static void main(String[] args) throws IOException {
        int _n = 20;
        String res = encodeFibonacci(_n);
        System.out.println(res);

    }
}

