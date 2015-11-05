package bAsics;

import java.util.*;
import java.util.List;

/**
 * Created by hellsapphire on 10/16/2015.
 * check if graph is a tree
 * check no cycles
 * check all connected
 */
public class GraphTree {
    static Map<Character, GraphNode> grapMap = new HashMap<>();
    static List<GraphNode> graphList = new ArrayList<>();
    static boolean cycFlag = false;

    public static void main(String[] args) {
        // inp ex: "<A,B> <B,C> <D,H> <A,D> <D,F> <F,E>"
        String in = "<A,B> <B,C> <D,H> <A,D> <D,F> <F,E>";
        String[] arr = in.split(" ");
        for (String s : arr) {
            char[] temp = s.toCharArray();
            char a = temp[1];
            char b = temp[3];
            GraphNode NodeA;
            GraphNode NodeB;
            if (grapMap.containsKey(a)) {
                NodeA = grapMap.get(a);
            } else {
                NodeA = new GraphNode(a);
                grapMap.put(a, NodeA);
                graphList.add(NodeA);
            }
            if (grapMap.containsKey(b)) {
                NodeB = grapMap.get(b);
            } else {
                NodeB = new GraphNode(b);
                grapMap.put(b, NodeB);
                graphList.add(NodeB);
            }
            NodeA.adjList.add(NodeB);
            NodeB.adjList.add(NodeA);
        }

        GraphNode start = graphList.get(0);
        start.parent = null;

        if (!hasCycle(start) && isConnected(graphList)){
            System.out.println("TREE");
        } else {
            System.out.println("NOT A TREE");
        }

    }


    public static boolean hasCycle(GraphNode nd) {
        nd.visited = true;

        for (GraphNode x : nd.adjList) {
            if (!x.visited) {
                x.parent = nd;
                if (hasCycle(x)) {
                    return true;
                }
            } else if (x != nd.parent) {
                return true;
            }
        }

        return false;
    }

    public static boolean isConnected(List<GraphNode> nodeList) {
        for (GraphNode x : nodeList) {
            if (!x.visited) {
                return false;
            }
        }
        return true;
    }
}

class GraphNode {
    char val;
    Set<GraphNode> adjList;
    boolean visited;
    GraphNode parent;

    public GraphNode(char c) {
        this.val = c;
        adjList = new HashSet<>();
    }
}
