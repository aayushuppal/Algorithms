package TripAdvisor;

import java.util.*;

/**
 * Created by hellsapphire on 10/30/2015.
 */
public class quotientAndRemainder {

    public static void main(String[] args) {




        Scanner in = new Scanner(System.in);

        while (true) {
            String m = in.nextLine();
            String n = in.nextLine();

            int M = Integer.parseInt(m);
            int N = Integer.parseInt(n);

            int count = 0;
            while (M >= N) {
                M = M - N;
                count++;
            }

            System.out.println("quotient: " + count);
            System.out.println("remainder: " + M);
        }
    }


}
