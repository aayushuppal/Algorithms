package zenefi;

/**
 * Created by hellsapphire on 10/5/2015.
 * Rain water trap
 * Zenefits
 */
public class RainTrap {

    public static void main(String[] args) {
        int[] E = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(calWater(E));
    }

    public static int calWater(int[] E) {
        int[] maxToRight = new int[E.length];
        int maxYet = E[E.length - 1];

        for (int i = E.length - 2; i >= 1; i--) {
            maxToRight[i] = Math.max(maxYet, E[i + 1]);
            maxYet = maxToRight[i];
        }

        int maxToLeft = E[0];
        int rainWater = 0;

        for (int i = 1; i <= E.length - 2; i++) {
            maxToLeft = Math.max(maxToLeft, E[i - 1]);
            rainWater += Math.max(Math.min(maxToRight[i], maxToLeft) - E[i], 0);
        }


        return rainWater;

    }

}
