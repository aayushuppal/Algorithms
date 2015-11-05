package interQ2;

import java.util.Collections;
import java.util.Scanner;

/**
 * Created by hellsapphire on 9/29/2015.
 */
public class NStairs {

    public static void main(String[] args) {
        String str = "abcd";
        int i=1;
        System.out.println(str.substring(0,i));
        System.out.println(str);
        System.out.println(str.substring(i+1,str.length()));


        /*Scanner in = new Scanner(System.in);
        while (true) {
            int temp = in.nextInt();
            System.out.println(NumofWays(temp));
            System.out.println(NumOfWaysDP(temp));
        }*/

    }

    public static int NumofWays(int n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        int a = 0;
        for (int i = 0; i <= n - 1; i++) {
            a += NumofWays(i);
        }
        return a;

        ///return NumofWays(n-1) + NumofWays(n-2) + NumofWays(n-3);

    }

    public static int NumOfWaysDP(int n){
        int[] M = new int[n+1];
        M[0] = 0;

        for (int i=1; i<=n; i++){
            M[i] = 1;
            for (int j=i-1; j>=0; j--){
                M[i] += M[j];
            }
        }

        return M[n];
    }


}
