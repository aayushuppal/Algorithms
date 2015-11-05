package bAsics;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by hellsapphire on 10/15/2015.
 * lexicographic rank of a string
 */
public class wordRank {

    public static void main(String[] args) {
        String sub = "lary";
        double res = getRank(sub);
        //res = res % 1000003;
        System.out.println(res);

    }

    public static double getRank(String str) {
        double count = 1;
        for (int i = 0; i < str.length(); i++) {
            String sub = str.substring(i);
            Set<Character> lChar = getUniqueSmaller(sub, str.charAt(i));
            if (!lChar.isEmpty()){
                count += findCount(lChar,sub);
            }

        }
        return count;
    }

    private static Set<Character> getUniqueSmaller(String str, Character c) {
        Set<Character> res = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < c){
                res.add(str.charAt(i));
            }
        }
        return res;
    }

    private static double findCount(Set<Character> lChar, String sub) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < sub.length(); i++) {
            char k = sub.charAt(i);
            if (map.containsKey(k)) {
                map.put(k, map.get(k) + 1);
            } else {
                map.put(k, 1);
            }
        }

        double n = factorial(sub.length() - 1);
        double count = 0;

        for (Character x : lChar) {
            double temp = n;
            for (Character k : map.keySet()) {
                if (k == x) {
                    temp = temp / factorial((map.get(k) - 1));
                } else {
                    temp = temp / factorial((map.get(k)));
                }
            }
            count += temp;
        }

        return count;
    }

    private static double factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        double res = n;

        for (int i = n - 1; i >= 1; i--) {
            res = res * i;
        }

        return res;
    }
}
