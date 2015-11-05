package strings;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by hellsapphire on 10/27/2015.
 * <p/>
 * closest pair of word in a string occurence
 *
 * linkedin
 */
public class closestPair {

    public static void main(String[] args) {
        String in = "A A C B A B";
        closestPair(in, "A", "B");
    }

    public static int[] closestPair(String s, String a, String b) {
        int[] res = {0, Integer.MAX_VALUE};
        HashMap<String, ArrayList<Integer>> dict = new HashMap<>();

        int i = 0;
        for (String x : s.split(" ")) {
            if (dict.containsKey(x)) {
                dict.get(x).add(i);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                dict.put(x, temp);
            }
            i++;
        }

        i = 0;
        ArrayList<Integer> aList = dict.get(a);
        ArrayList<Integer> bList = dict.get(b);

        for (int x : aList) {
            int j = i;
            int[] temp = {x, bList.get(j)};
            j++;

            while (j < bList.size() && Math.abs(bList.get(j) - x) < Math.abs(temp[0] - temp[1])) {
                temp[0] = x;
                temp[1] = bList.get(j);
                i = j;
                j++;
            }

            if (Math.abs(temp[1] - temp[0]) < Math.abs(res[1] - res[0])) {
                res[0] = temp[0];
                res[1] = temp[1];
            }
        }

        System.out.println(res[0] + ", " + res[1]);
        return res;
    }

}
