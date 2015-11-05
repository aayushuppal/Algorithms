package interQ2;

/**
 * Created by hellsapphire on 9/28/2015.
 */
public class minToMaxDiff {

    public static void main(String[] args) {
        int[] input = {3, 1, 5, 2, 3, 7, 8, 2, 4, 9, 4, 6};
        //int [] input = {3,3};
        System.out.println(maxDiff(input));
    }

    public static int maxDiff(int[] in) {
        if (in.length == 1) {
            return -1;
        }
        int a = -1, b = -1;
        int maxDiff = -1;
        int left = 0;

        for (int right = 1; right < in.length; right++) {
            if (in[right] < in[left]) {
                left = right;
            } else {
                if (in[right] - in[left] > maxDiff) {
                    maxDiff = in[right] - in[left];
                    a = left;
                    b = right;
                }
            }
        }
        System.out.println(a + " " + b);
        return maxDiff;
    }
}
