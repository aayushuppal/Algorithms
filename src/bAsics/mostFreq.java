package bAsics;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by hellsapphire on 10/13/2015.
 */
public class mostFreq {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 1, 4, 2, 3, 2, 4, 2, 5};
        HashMap<Integer, IntNode> nodeMap = new HashMap<>();
        PriorityQueue<IntNode> freqQ = new PriorityQueue<>(A.length, new freqComp());

        for (int x : A) {
            if (nodeMap.containsKey(x)) {
                IntNode temp = nodeMap.get(x);
                freqQ.remove(temp);
                temp.incFreq();
                freqQ.add(temp);
            } else {
                IntNode temp = new IntNode(x);
                freqQ.add(temp);
                nodeMap.put(x, temp);
            }
        }

        while (!freqQ.isEmpty()) {
            IntNode t = freqQ.poll();
            System.out.println(t.getVal() + " " + t.getFreq());
        }
    }

    static class freqComp implements Comparator<IntNode> {

        public int compare(IntNode o1, IntNode o2) {
            return o2.getFreq() - o1.getFreq();
        }
    }

    static class IntNode {
        private int val;
        private int freq;

        public IntNode(int v) {
            this.val = v;
            this.freq = 1;
        }

        public void incFreq() {
            freq++;
        }

        public int getFreq() {
            return freq;
        }

        public int getVal() {
            return val;
        }
    }
}
