package TripAdvisor;

/**
 * Created by hellsapphire on 11/4/2015.
 */
public class iToA {

    public static void main(String[] args) {
        Integer x = 12;

        StringBuilder sb = new StringBuilder();
        while (x > 0) {
            int r = x % 10;
            sb.insert(0, r);
            x = x / 10;
        }
        System.out.println(sb.toString());

    }
}