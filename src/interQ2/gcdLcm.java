package interQ2;

/**
 * Created by hellsapphire on 9/29/2015.
 */
public class gcdLcm {

    public static void main(String[] args) {
        System.out.println(getGCD(5, 2));
        System.out.println(getLCM(5, 2));

    }

    public static int getGCD(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;

    }

    public static int getLCM(int a, int b) {
        return a * (b / (getGCD(a, b)));

    }
}
