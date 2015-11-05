package bAsics;

import java.util.Scanner;

/**
 * Created by hellsapphire on 10/13/2015.
 * prime nums erasto bloomberg
 */
public class primeNums {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        erasto(n);
    }

    public static void erasto(int n) {
        int[] P = new int[n + 1];

        for (int i = 2; i * i <= n; i++) {
            for (int a = i; a * i <= n; a++) {
                P[a*i] = 1;
            }
        }

        for (int i=2; i<=n; i++){
            if (P[i] == 0){
                System.out.println(i);
            }
        }
    }

}
