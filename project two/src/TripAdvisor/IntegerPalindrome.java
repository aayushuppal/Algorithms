package TripAdvisor;

import java.util.*;

/**
 * Created by hellsapphire on 10/30/2015.
 */
public class IntegerPalindrome {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String s = in.nextLine();

            System.out.println(isIntPal(Integer.parseInt(s)));
        }
    }


    public static boolean isIntPal(int a) {

        for (int i = 0; i <= 14; i++) {
            int temp = a;
            int x = (int) Math.pow(2, i);
            int y = (int) Math.pow(2, 30 - i);

            x = temp & x;
            y = temp & y;

            if (x > 0 && y > 0) {
                continue;
            } else if (x == 0 && y == 0) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
