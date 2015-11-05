package hack_go_daddy;

/**
 * Created by hellsapphire on 10/4/2015.
 */

import java.util.*;

public class HexagonWall {
    static Map<String, HexaNode> allNodesMap = new HashMap<String, HexaNode>();
    static Set<HexaNode> romanSet = new HashSet<HexaNode>();
    static Set<HexaNode> persianSet = new HashSet<HexaNode>();
    static Set<HexaNode> romanRoots = new HashSet<HexaNode>();
    static Set<HexaNode> persianRoots = new HashSet<HexaNode>();
    static int N;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();

        int steps = in.nextInt();

        for (int i = 0; i < steps; i++) {
            in.nextLine();
            int a = in.nextInt();
            int b = in.nextInt();
            HexaNode temp = new HexaNode(a, b);
            allNodesMap.put("" + a + "-" + b, temp);

            if (i % 2 == 0) {
                addToRoman(temp);
            } else {
                addToPersian(temp);
            }
        }

        if (checkPersian()){
            System.out.println("PERSIANS");
        } else if (checkRoman()){
            System.out.println("ROMANS");
        } else {
            System.out.println("NEITHER");
        }


    }


    public static boolean checkPersian() {
        HexaNode dummyPers = new HexaNode(0,0);

        if (persianRoots.size() > 0){
            for (HexaNode node : persianRoots) {
                dummyPers.adj.add(node);
            }
        }
            HashSet<HexaNode> visited = new HashSet<HexaNode>();
            if (persianBfs(dummyPers, visited)) {
                return true;
            }

        return false;
    }

    public static boolean checkRoman() {
        HexaNode dummyRoms = new HexaNode(N+1,N+1);

        if (romanRoots.size() > 0){
            for (HexaNode node : romanRoots) {
                dummyRoms.adj.add(node);
            }
        }
        HashSet<HexaNode> visited = new HashSet<HexaNode>();
        if (romanBfs(dummyRoms, visited)) {
            return true;
        }

        return false;
    }


    public static void addToRoman(HexaNode temp) {
        romanSet.add(temp);
        if (temp.C == 1) {
            romanRoots.add(temp);
        }

        List<String> strList = validNeighbors(temp, N);

        for (String k : strList) {
            if (allNodesMap.containsKey(k)) {
                HexaNode hnode = allNodesMap.get(k);
                if (romanSet.contains(hnode)) {
                    temp.adj.add(hnode);
                    hnode.adj.add(temp);
                }
            }
        }
    }

    public static void addToPersian(HexaNode temp) {
        persianSet.add(temp);
        if (temp.R == 1) {
            persianRoots.add(temp);
        }

        List<String> strList = validNeighbors(temp, N);

        for (String k : strList) {
            if (allNodesMap.containsKey(k)) {
                HexaNode hnode = allNodesMap.get(k);
                if (persianSet.contains(hnode)) {
                    temp.adj.add(hnode);
                    hnode.adj.add(temp);
                }
            }
        }

    }


    public static List<String> validNeighbors(HexaNode temp, int N) {
        int i = temp.R;
        int j = temp.C;
        List<String> res = new ArrayList<String>();
        for (int a = -1; a <= 1; a++) {
            for (int b = -1; b <= 1; b++) {
                if (a != b) {
                    int A = i + a;
                    int B = j + b;
                    if (A > 0 && A <= N && B > 0 && B <= N) {
                        res.add("" + A + "-" + B);
                    }
                }
            }
        }
        return res;

    }

    public static boolean persianBfs(HexaNode node, HashSet<HexaNode> visited) {
        visited.add(node);


        if (node.R == N) {
            return true;
        }

        Queue<HexaNode> qe = new LinkedList<HexaNode>();
        qe = retQ(node, qe, visited);

        while (!qe.isEmpty()) {
            HexaNode temp = qe.remove();
            visited.add(temp);

            if (temp.R == N) {
                return true;
            } else {
                qe = retQ(temp, qe, visited);
            }

        }


        return false;


    }



    public static boolean romanBfs(HexaNode node, HashSet<HexaNode> visited) {
        visited.add(node);

        if (node.C == N) {
            return true;
        }

        Queue<HexaNode> qe = new LinkedList<HexaNode>();
        qe = retQ(node, qe, visited);

        while (!qe.isEmpty()) {
            HexaNode temp = qe.remove();
            visited.add(temp);

            if (temp.C == N) {
                return true;
            } else {
                qe = retQ(temp, qe, visited);
            }

        }


        return false;


    }


    public static Queue<HexaNode> retQ(HexaNode node, Queue<HexaNode> qe, HashSet<HexaNode> visited) {
        Set<HexaNode> set = node.adj;

        for (HexaNode temp : set) {
            if (!visited.contains(temp)) {
                qe.add(temp);
            }
        }

        return qe;
    }


    static class HexaNode {
        int R;
        int C;
        Set<HexaNode> adj;

        HexaNode(int r, int c) {
            R = r;
            C = c;
            adj = new HashSet<HexaNode>();
        }
    }
}