package TripAdvisor;

import java.util.*;

/**
 * Created by hellsapphire on 10/31/2015.
 * <p/>
 * Dijkstra undirected graph shortest path
 */

public class DijkstraShortest {

    public static void main(String[] args) {
        Random rn = new Random();
        int a = rn.nextInt(12);
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();

        for (int l = 0; l < testCases; l++) {
            in.nextLine();
            String s = in.nextLine();
            String[] arr = s.split(" ");

            int N = Integer.parseInt(arr[0]);
            int M = Integer.parseInt(arr[1]);
            int[][] E = new int[N + 1][N + 1];

            for (int i = 0; i <= N; i++) {
                for (int j = 0; j <= N; j++) {
                    if (i == j) {
                        E[i][j] = 0;
                    } else {
                        E[i][j] = -1;
                    }
                }
            }

            for (int t = 0; t < M; t++) {
                s = in.nextLine();
                arr = s.split(" ");
                int i = Integer.parseInt(arr[0]);
                int j = Integer.parseInt(arr[1]);
                int c = Integer.parseInt(arr[2]);

                E[i][j] = c;
                E[j][i] = c;
            }

            int S = Integer.parseInt(in.nextLine());
            distFromS(E, S);
        }

    }

    public static void distFromS(int[][] E, int S) {
        int N = E.length - 1;
        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer, Node> nodeMap = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            Node temp = new Node(i);
            nodeMap.put(i, temp);
        }

        nodeMap.get(S).dist = 0;
        visited.add(S);

        while (visited.size() < N) {
            int p = pickNearestNode(visited, E, nodeMap);
            visited.add(p);
        }

        for (int i = 1; i <= N; i++) {
            if (i != S) {
                System.out.print(nodeMap.get(i).dist + " ");
            }

        }
    }

    private static int pickNearestNode(HashSet<Integer> visited, int[][] E, HashMap<Integer, Node> nodeMap) {

        int resNode = -1;
        int resDist = Integer.MAX_VALUE;

        int N = E.length - 1;

        for (int t : visited) {
            for (int i = 1; i <= N; i++) {
                if (!visited.contains(i) && E[t][i] != -1) {
                    if (nodeMap.get(t).dist + E[t][i] < resDist) {
                        resDist = nodeMap.get(t).dist + E[t][i];
                        resNode = i;
                    }
                }
            }
        }

        nodeMap.get(resNode).dist = resDist;
        return resNode;
    }
}

class Node {
    int num;
    int dist;

    Node(int n) {
        num = n;
        dist = -1;
    }
}
