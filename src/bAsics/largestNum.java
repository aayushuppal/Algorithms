package bAsics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by hellsapphire on 10/20/2015.
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * <p/>
 * For example:
 * <p/>
 * Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * <p/>
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class largestNum {

    public static void main(String[] args) {
        int[] in = {931, 94, 209, 448, 716, 903, 124, 372, 462, 196, 715, 802, 103, 740, 389, 872, 615, 638, 771, 829, 899, 999, 29, 163, 342, 902, 922, 312, 326, 817, 288, 75, 37, 286, 708, 589, 975, 747, 743, 699, 743, 954, 523, 989, 114, 402, 236, 855, 323, 79, 949, 176, 663, 587, 322};
        PriorityQueue<Integer> pq = new PriorityQueue<>(in.length, new myComp());

        for (int x : in) {
            pq.add(x);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
            //sb.append(pq.poll());
            //sb.append(" ");
        }

        //String s = remLeadZero(sb.toString());
        //System.out.println(s);

        String h = new String("999 989 975 954 94 949 931 922 903 902 89987285582981780279771757477437437407167157086996636386155895875234624484023893737234232632332231229288286236209196176163124114103");
        String j = new String("999 989 975 954 949 94 931 922 903 902 89987285582981780279771757477437437407167157086996636386155895875234624484023893737234232632332231229288286236209196176163124114103");

        h.equals(j);
    }

    private static String remLeadZero(String s) {
        int i = -1;
        while (i + 1 < s.length() && s.charAt(i + 1) == '0') {
            i++;
        }
        if (i > -1) {
            return "0" + s.substring(i + 1);
        } else {
            return s;
        }
    }

}

class myComp implements Comparator<Integer> {

    /*public int compare(Integer a, Integer b) {
        String q = Integer.toString(a);
        String w = Integer.toString(b);

        int res = 0;

        int k = q.length() < w.length() ? w.length() : q.length();
        for (int i = 0; i < k; i++) {
            char x;
            char y;
            if (i >= q.length()) {
                x = q.charAt(0);
            } else {
                x = q.charAt(i);
            }
            if (i >= w.length()) {
                y = w.charAt(0);
            } else {
                y = w.charAt(i);
            }

            if (x == y) {
                continue;
            } else if (x > y) {
                res = -1;
                break;
            } else {
                res = 1;
                break;
            }
        }

        return res;
    }*/

    public int compare(Integer a, Integer b) {
        String q = Integer.toString(a);
        String w = Integer.toString(b);

        String aa = w + q;
        String bb = q + w;

        if (Integer.parseInt(aa) > Integer.parseInt(bb)) {
            return 1;
        } else if (Integer.parseInt(bb) > Integer.parseInt(aa)) {
            return -1;
        } else {
            return 0;
        }
    }
}
