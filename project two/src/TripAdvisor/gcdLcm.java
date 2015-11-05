package TripAdvisor;

/**
 * Created by hellsapphire on 11/3/2015.
 */
public class gcdLcm {

    public static void main(String[] args) {
        int a = 4;
        int b = 6;
        System.out.println(gcd(a, b));
        System.out.println(lcm(a, b));
    }

    public static int gcd(int a, int b) {
        while (b > 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return (a * b) / (gcd(a, b));
    }
}
