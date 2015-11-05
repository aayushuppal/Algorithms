package bAsics;

import java.util.*;

/**
 * Created by hellsapphire on 10/12/2015.
 * friend circles marketo question
 */
public class FriendCircles {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] M = new int[n][n];

        for (int i = 0; i < n; i++) {
            in.nextLine();
            String s = in.next();
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == 'Y') {
                    M[i][j] = 1;
                }
            }
        }

        in.close();

        Set<Integer> nodeSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            nodeSet.add(i);
        }
        int count = 0;
        for (int x = 0; x < n; x++) {
            if (nodeSet.contains(x)) {
                dfs(x, nodeSet, M);
                count++;
            }

        }

        System.out.println(count);
    }

    public static void dfs(int node, Set<Integer> nodeSet, int[][] M) {
        visit(node, nodeSet);

        for (int y : adjList(node, M)) {
            if (!visited(y, nodeSet)) {
                dfs(y, nodeSet, M);
            }
        }
    }

    public static void visit(int x, Set<Integer> nodeSet) {
        nodeSet.remove(x);
    }

    public static List<Integer> adjList(int node, int[][] M) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < M.length; i++) {
            if (M[node][i] == 1) {
                res.add(i);
            }
        }
        return res;
    }

    public static boolean visited(int y, Set<Integer> nodeSet) {
        if (nodeSet.contains(y)) {
            return false;
        } else {
            return true;
        }
    }
}
