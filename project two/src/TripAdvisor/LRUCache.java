package TripAdvisor;

import java.util.HashMap;

/**
 * Created by hellsapphire on 11/2/2015.
 */
public class LRUCache {
    int capacity;
    HashMap<Integer, DoubleNode> map;
    DoubleNode head;
    DoubleNode tail;

    LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DoubleNode temp = map.get(key);
            remove(temp);
            setHead(temp);
            return temp.val;
        }
        return -1;
    }

    public void set(int key, int value) {

        // adding a new value
        if (!map.containsKey(key)) {
            DoubleNode temp = new DoubleNode(key, value);

            if (map.size() == capacity) {
                map.remove(tail.key);
                remove(tail);
                map.put(key, temp);
                setHead(temp);
            } else {
                map.put(key, temp);
                setHead(temp);
            }

        } else {
            DoubleNode temp = map.get(key);
            temp.val = value;
            remove(temp);
            setHead(temp);
        }
    }

    public void remove(DoubleNode node) {
        if (node.prev == null && node.next == null) {
            head = null;
            tail = null;
        } else if (node.prev == null) {
            head = node.next;
        } else if (node.next == null) {
            tail = node.prev;
        } else {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
        node.next = null;
        node.prev = null;
    }

    public void setHead(DoubleNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public static void main(String[] args) {
        LRUCache lrc = new LRUCache(2);
        lrc.set(2, 1);
        lrc.set(1, 1);
        lrc.get(2);
        lrc.set(4, 1);
        lrc.get(1);
        lrc.get(2);
    }
}

class DoubleNode {
    int key;
    int val;
    DoubleNode prev;
    DoubleNode next;

    DoubleNode(int k, int v) {
        key = k;
        val = v;
    }
}

