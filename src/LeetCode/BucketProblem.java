package LeetCode;


import java.util.*;

/**
 * Created by hellsapphire on 10/23/2015.
 * bucket problem
 * gcd calculate
 */
public class BucketProblem {
    static int maxA = 3;
    static int maxB = 5;
    static int K = 4;

    public static void main(String[] args) {
        if (isPossible(maxA, maxB, K)) {
            String root = "0-0";
            bfsBucket(root);
        } else {
            System.out.println("no solution possible");
        }
    }

    public static boolean isPossible(int a, int b, int k) {
        if (k % gcd(a, b) == 0) {
            return true;
        }
        return false;
    }

    public static int gcd(int a, int b) {
        if (0 == b) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static boolean bfsBucket(String root) {
        Queue<String> qe = new LinkedList<>();
        HashMap<String, Integer> visited = new HashMap<>();
        HashMap<String, gNode> vNodemap = new HashMap<>();
        gNode rootNode = new gNode(root);
        vNodemap.put(root, rootNode);
        qe.add(root);
        visited.put(root, 0);


        while (!qe.isEmpty()) {
            String temp = qe.poll();

            if (kReached(temp)) {
                System.out.println(temp);
                System.out.println(visited.get(temp));

                gNode tail = vNodemap.get(temp);
                while (tail != null){
                    System.out.println(tail.val);
                    tail = tail.parent;
                }
                return true;
            }

            ArrayList<String> adj = getadj(temp);
            for (String sr : adj) {
                if (!visited.keySet().contains(sr)) {
                    qe.add(sr);
                    gNode tempNode = new gNode(sr);
                    tempNode.parent = vNodemap.get(temp);
                    vNodemap.put(sr, tempNode);
                    visited.put(sr, visited.get(temp) + 1);
                }
            }
        }
        return false;
    }

    public static ArrayList<String> getadj(String str) {
        ArrayList<String> res = new ArrayList<>();
        String[] sArr = str.split("-");
        int a = Integer.parseInt(sArr[0]);
        int b = Integer.parseInt(sArr[1]);

        res.add(0 + "-" + b);
        res.add(a + "-" + 0);

        if (a > 0) {
            int tempb = Math.min(maxB - b, a);
            res.add((a - tempb) + "-" + (b + tempb));
        }

        if (b > 0) {
            int tempa = Math.min(maxA - a, b);
            res.add((a + tempa) + "-" + (b - tempa));
        }

        res.add(maxA + "-" + b);
        res.add(a + "-" + maxB);
        return res;
    }

    public static boolean kReached(String str) {
        String[] sArr = str.split("-");
        int a = Integer.parseInt(sArr[0]);
        int b = Integer.parseInt(sArr[1]);
        if (a == K || b == K) {
            return true;
        }
        return false;
    }

}

class gNode {
    String val;
    gNode parent;

    gNode(String v) {
        val = v;
    }
}