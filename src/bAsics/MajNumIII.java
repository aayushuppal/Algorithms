package bAsics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hellsapphire on 10/16/2015.
 */
public class MajNumIII {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 1, 5, 7, 7, 1, 5};
        int k = 3;
        System.out.println(OneKMajority(A, k));
    }

    private static int OneKMajority(int[] A, int k) {
        Map<Integer, Integer> kMap = new HashMap<>();

        for (int x : A) {
            if (!kMap.containsKey(x)) {
                if (kMap.size() > k - 1) {
                    negateAll(kMap);
                } else {
                    kMap.put(x, 1);
                }
            } else {
                kMap.put(x, kMap.get(x) + 1);
            }
        }

        int a = 0;
        int b = 0;

        for (int x : kMap.keySet()) {
            if (kMap.get(x) > b) {
                b = kMap.get(x);
                a = x;
            }
        }

        return a;

    }

    private static void negateAll(Map<Integer, Integer> map) {
        ArrayList<Integer> ks = new ArrayList<>();
        for (int x : map.keySet()) {
            if (map.get(x) == 1) {
                ks.add(x);
            } else {
                map.put(x, map.get(x) - 1);
            }

        }

        for (int x : ks) {
            map.remove(x);

        }
    }

}
