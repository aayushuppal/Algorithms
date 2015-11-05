package TripAdvisor;

import java.util.*;

/**
 * Created by hellsapphire on 11/1/2015.
 */
public class randomGen {

    public static void main(String[] args) {

        while (true) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            System.out.println((int) random(n));
        }

    }

    public static long random(int n) {
        if (n <= 0) {
            return -1;
        }
        long s = System.nanoTime();
        s = s + n;
        return s % n;
    }
}
