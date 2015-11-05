package TripAdvisor;

/**
 * Created by hellsapphire on 11/1/2015.
 * <p/>
 * list of coins and minimum number of coins needed for it
 */
public class coinsAndAList {

    public static void main(String[] args) {
        int[] coins = {3, 5};
        int K = 11;

        System.out.print(minNeeded(coins, K));
    }

    public static int minNeeded(int[] coins, int K) {
        int[] M = new int[K + 1];
        for (int i = 1; i <= K; i++) {
            M[i] = K;
        }

        for (int i = 1; i <= K; i++) {

            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    M[i] = Math.min(M[i - coins[j]] + 1, M[i]);
                }
            }

        }
        return M[K];
    }
}
