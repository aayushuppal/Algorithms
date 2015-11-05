package LeetCode;

import java.util.ArrayList;

/**
 * Created by hellsapphire on 10/24/2015.
 */
public class StringCombs {

    public static void main(String[] args) {
        String in = "1213";
        recurse(in, 0, "");

        ArrayList<Integer> a = new ArrayList<>();
        a.add(12);
        a.add(13);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        recurseList(a, 0, temp, res);

    }

    public static void recurse(String s, int i, String temp) {
        if (i == s.length()) {
            System.out.println(temp);
            return;
        }

        if (i < s.length()) {
            recurse(s, i + 1, temp);
            String tempCopy = temp;
            tempCopy += s.charAt(i);
            recurse(s, i + 1, tempCopy);
        }
    }

    public static void recurseList(ArrayList<Integer> a, int i, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res) {
        if (i == a.size()) {
            res.add(temp);
            return;
        }

        if (i < a.size()) {
            recurseList(a, i + 1, temp, res);
            ArrayList<Integer> tempCopy = new ArrayList<>(temp);
            tempCopy.add(a.get(i));
            recurseList(a, i + 1, tempCopy, res);
        }
    }

}
