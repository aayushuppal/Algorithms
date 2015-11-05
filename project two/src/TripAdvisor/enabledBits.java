package TripAdvisor;

/**
 * Created by hellsapphire on 11/2/2015.
 */
public class enabledBits {

    public static void main(String[] args) {
        int n = 3;
        int count = 0;

        if ((n & 1) == 1) {
            count++;
        }

        for (int i = 1; i <= 30; i++) {
            n = n >> 1;
            if ((n & 1) == 1) {
                count++;
            }
        }
        System.out.print(count);
    }
}
