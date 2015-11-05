package zenefi;

import java.util.HashMap;

/**
 * Created by hellsapphire on 10/5/2015.
 */
public class LRUCache {
    private Node head;
    private Node end;
    private int capacity;
    private int current;
    private HashMap<Integer, Node> lruMap;

    public LRUCache(int N) {
        capacity = N;
        current = 0;
        lruMap = new HashMap<>(N);
        head = null;
        end = null;
    }

    public void set(int k, int v) {

        if (lruMap.containsKey(k)) {
            Node curr = lruMap.get(k);
            curr.setVal(v);
            // remove curr
            // push to start
        }

        if (current < capacity){
            Node nd = new Node(k,v);
        }
    }


    static class Node {
        private int key;
        private int val;
        Node next;
        Node prev;

        public Node(int k, int v) {
            key = k;
            val = v;
        }

        public void setVal(int v) {
            val = v;
        }
    }


}
