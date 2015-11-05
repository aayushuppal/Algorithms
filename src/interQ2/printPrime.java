package interQ2;

import java.util.Scanner;

/**
 * Created by hellsapphire on 9/29/2015.
 */
public class printPrime {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int temp = in.nextInt();
            printPrime(temp);
            SieveofErasto(temp);
        }
    }

    public static void printPrime(int n) {

        for (int i = 2; i <= n; i++) {

            boolean bool = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    bool = false;
                    break;
                }
            }

            if (bool) {
                System.out.println(i);
            }

        }
    }

    public static void SieveofErasto(int n){
        boolean[] isPrime = new boolean[n+1];
        for (int i=2; i<=n; i++){
            isPrime[i] = true;
        }

        for (int i=2; i<=Math.sqrt(n); i++){

            if (isPrime[i]){
                for(int j=i; i*j<=n; j++){
                    isPrime[i*j] = false;
                }
            }
        }

        for (int i=2; i<=n; i++){
            if (isPrime[i]){
                System.out.println(i);
            }
        }
    }

}
