package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * SUBSET
 * Sorted subset combinations
 * <p/>
 * Created by hellsapphire on 10/24/2015.
 * <p/>
 * Given a set of distinct integers, S, return all possible subsets.
 * <p/>
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * Also, the subsets should be sorted in ascending ( lexicographic ) order.
 * Example :
 * <p/>
 * If S = [1,2,3], a solution is:
 * <p/>
 * [
 * [],
 * [1],
 * [1, 2],
 * [1, 2, 3],
 * [1, 3],
 * [2],
 * [2, 3],
 * [3],
 * ]
 */
public class SubsetCombinations {

    public static void main(String[] args) {
        SubsetCombinations scm = new SubsetCombinations();
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(15);
        a.add(20);
        a.add(12);
        a.add(19);
        a.add(4);
        scm.subsets(a);
    }

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        recurse(a, 0, temp, res);
        Collections.sort(res, new myComparator());
        return res;
    }

    public static void recurse(ArrayList<Integer> a, int i, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res) {
        if (i == a.size()) {
            Collections.sort(temp);
            res.add(temp);
            return;
        }

        if (i < a.size()) {
            recurse(a, i + 1, temp, res);
            ArrayList<Integer> tempCopy = new ArrayList<>(temp);
            tempCopy.add(a.get(i));
            recurse(a, i + 1, tempCopy, res);
        }
    }

    static class myComparator implements Comparator<ArrayList<Integer>> {

        public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
            if (o1.size() == 0) {
                return -1;
            } else if (o2.size() == 0) {
                return 1;
            } else {
                int i;
                for (i = 0; i < Math.min(o1.size(), o2.size()); i++) {
                    if (o1.get(i) < o2.get(i)) {
                        return -1;
                    } else if (o2.get(i) < o1.get(i)) {
                        return 1;
                    }
                }
                if (o1.size() < o2.size()) {
                    return -1;
                } else if (o2.size() < o1.size()) {
                    return 1;
                }
            }
            return 0;
        }

    }
}
