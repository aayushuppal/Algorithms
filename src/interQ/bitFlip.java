package interQ;

/**
 * Created by hellsapphire on 9/24/2015.
 */
public class bitFlip {

    public static void main(String[] args) {
        // int[] inp = {1,0,0,1,0,0,1,0};
        int[] inp = {1,1,1,1};
        System.out.println(bitFlip(inp));
    }

    static int bitFlip(int[] arr) {
        int[] flag = new int[arr.length];
        int existCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                existCount++;
                flag[i] = -1;
            } else {
                flag[i] = 1;
            }
        }
        if (existCount == arr.length) {
            return existCount;
        }

        int[] flipArr = {-1, -1};
        int maxPlus = 0;
        int tempPlus = 0;
        for (int i = 0; i < arr.length; i++) {
            tempPlus += flag[i];
            if (tempPlus < 1) {
                while (i < arr.length && flag[i] == -1) {
                    i++;
                }
                tempPlus = 1;
            }
            if (maxPlus < tempPlus) {
                maxPlus = tempPlus;
            }
        }

        return existCount + maxPlus;
    }
}
