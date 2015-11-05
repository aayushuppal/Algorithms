package TripAdvisor;

import java.util.Scanner;

/**
 * Created by hellsapphire on 11/1/2015.
 */
public class parseInt {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String s = in.nextLine();
            System.out.println(parseInt(s));
        }
    }

    public static int parseInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            if (t < 48 || t > 57) {
                throw new NumberFormatException();
            } else {
                res = res * 10 + t - 48;
            }
        }
        return res;
    }
}
