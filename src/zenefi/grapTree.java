package zenefi;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by hellsapphire on 10/4/2015.
 */
public class grapTree {

    public static void main(String[] args) {
        //int[][] adjMat = {{0, 1, 1, 0}, {1, 0, 1, 1}, {1, 1, 0, 0}, {0, 1, 0, 0}};
        int[][] adjMat = {{0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 1}, {0, 1, 1, 0, 1}, {0, 0, 1, 1, 0}};
        System.out.println(findTriangles(adjMat));
    }

    public static int findTriangles(int[][] M) {
        Map<Integer, ArrayList<Integer>> nodeToadjMap = new HashMap<Integer, ArrayList<Integer>>();
        HashSet<String> triangleSet = new HashSet<String>();

        for (int i = 0; i < M.length; i++) {
            List<String> temp = getTriangles(M[i], M);
            for (String tri : temp) {
                String x = i + "-" + tri;
                String[] arr = x.split("-");
                Arrays.sort(arr);
                x = Arrays.toString(arr);
                triangleSet.add(x);
            }
        }

        return triangleSet.size();

    }


    public static List<String> getTriangles(int[] A, int[][] M) {
        List<String> res = new ArrayList<String>();

        int i = 0;
        int j = A.length - 1;


        while (i < j) {

            while (i < A.length && A[i] != 1) {
                i++;
            }

            if (i == A.length - 1) {
                break;
            }

            int a = i;
            int b = j;

            while (b > a) {
                if (A[b] == 1 && M[a][b] == 1) {
                    String temp = a + "-" + b;
                    res.add(temp);
                }
                b--;
            }

            i++;
        }

        return res;
    }


    // could be done, not very optimal again similar to previous
    public static void findTrianglesDFS(int root, int maxDepth, int[][] M) {
        int level = 0;
        List<Integer> adj = getAdj(root,M);

    }

    public static List<Integer> getAdj(int root, int[][] M) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < M[root].length; i++) {
            if (M[root][i] == 1) {
                res.add(i);
            }
        }
        return res;
    }
}
