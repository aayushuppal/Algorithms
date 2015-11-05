package bAsics;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hellsapphire on 10/13/2015.
 * cube sum a b c d
 */
public class cubesumABCD {

    public static void main(String[] args) {
        int[] A = {1, 3, 2, 2};
        Map<Integer, int[]> sumTopairMap = new HashMap<>();

        for (int i = 0; i < A.length; ++i) {
            for (int j = i + 1; j < A.length; ++j) {
                int cubed = cubeFunc(A[i], A[j]);
                if (sumTopairMap.containsKey(cubed)) {
                    int[] a = sumTopairMap.get(cubed);
                    System.out.println(a[0] + " " + a[1] + "-" + i + " " + j);
                } else {
                    int[] temp = {i, j};
                    sumTopairMap.put(cubed, temp);
                }
            }
        }

    }

    public static int cubeFunc(int a, int b) {
        /*double x = Math.pow(a, 3) + Math.pow(b, 3);
        return (int) x;*/
        return a+b;
    }

}
