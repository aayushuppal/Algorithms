package bAsics;
// bi directional BFS


import java.util.*;

/**
 * Created by hellsapphire on 10/10/2015.
 */
public class biDirBfs {

    public static void main(String[] args) {
        GraphNode zero = new GraphNode(0);
        GraphNode three = new GraphNode(3);
        GraphNode four = new GraphNode(4);
        GraphNode two = new GraphNode(2);
        GraphNode one = new GraphNode(1);
        GraphNode five = new GraphNode(5);

        zero.adj.add(four);
        zero.adj.add(three);

        four.adj.add(zero);
        four.adj.add(three);
        four.adj.add(two);

        three.adj.add(four);
        three.adj.add(two);
        three.adj.add(five);
        three.adj.add(zero);

        two.adj.add(one);
        two.adj.add(five);
        two.adj.add(three);
        two.adj.add(four);

        five.adj.add(two);
        five.adj.add(three);

        one.adj.add(two);

        System.out.println(bi_bfs(one, zero));
    }


    public static int bi_bfs(GraphNode A, GraphNode B) {
        Queue<GraphNode> qA = new LinkedList<GraphNode>();
        Queue<GraphNode> qB = new LinkedList<GraphNode>();
        qA.add(A);
        A.distA = 0;
        A.startVisited = true;
        qB.add(B);
        B.distB = 0;
        B.endVisited = true;

        HashSet<GraphNode> hsA = new HashSet<>();
        HashSet<GraphNode> hsB = new HashSet<>();

        while (!qA.isEmpty() && !qB.isEmpty()) {
            int l = qA.size();
            for (int i = 0; i < l; i++) {
                GraphNode nA = qA.poll();

                for (GraphNode n : nA.adj) {
                    if (!n.startVisited) {
                        n.distA = nA.distA + 1;
                        n.startVisited = true;
                        qA.add(n);
                    }
                }
            }

            l = qB.size();
            for (int i = 0; i < l; i++) {
                GraphNode nB = qB.poll();

                if (nB.startVisited) {
                    return nB.distA + nB.distB;
                }

                for (GraphNode n : nB.adj) {
                    if (!n.endVisited) {
                        n.distB = nB.distB + 1;
                        n.endVisited = true;
                        qB.add(n);
                    }
                }
            }
        }

        return -1;

    }


    static class GraphNode {
        int val;
        List<GraphNode> adj;
        int distA;
        int distB;
        boolean startVisited;
        boolean endVisited;

        public GraphNode(int v) {
            this.val = v;
            adj = new ArrayList<GraphNode>();
        }
    }

}
