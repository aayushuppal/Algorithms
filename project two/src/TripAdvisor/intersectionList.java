package TripAdvisor;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by hellsapphire on 11/2/2015.
 */
public class intersectionList {


    public static void main(String[] args) {
        Integer[] A = {1, 2, 5, 7, 8};
        Integer[] B = {2, 3, 4, 7, 9, 10};
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(A));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(B));
        ArrayList<Integer> res = intersect(a, b);
    }

    public static ArrayList<Integer> intersect(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (true) {
            if (i >= a.size() || j >= b.size())
                break;

            // searching for element from a in b, moving the j pointer in b  for O(n) traversal
            while (b.get(j) <= a.get(i)) {

                if (b.get(j) == a.get(i))
                    res.add(a.get(i));

                j++;
            }
            i++;
        }

        return res;
    }

}



