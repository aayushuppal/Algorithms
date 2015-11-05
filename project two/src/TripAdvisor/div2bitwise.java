package TripAdvisor;

import java.util.*;

/**
 * Created by hellsapphire on 10/30/2015.
 */
public class div2bitwise {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String s = in.nextLine();
            System.out.println(divby2(Integer.parseInt(s)));
        }
    }

    public static double divby2(int a) {
        double res = 0;
        if (a % 2 != 0) {
            res = 0.5;
        }

        a = a >> 1;

        return res + a;
    }
}
