package bAsics;

/**
 * Created by hellsapphire on 10/21/2015.
 * coffee meets bagel
 */
public class primeOrNot {

    public static void main(String[] args) {
        long n = 4;
        System.out.println(isPrime(n));
    }

    static int isPrime(long n) {
        return primeCheck(n);
    }

    private static int primeCheck(long number) {
        long res = 1;

        for (long i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                res = i;
                break;
            }
        }
        return (int) res;

    }
}
