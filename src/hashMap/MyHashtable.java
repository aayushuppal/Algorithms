package hashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyHashtable<K, V> {
    private int size = 10;
    private List<EntryObject<K, V>> map;

    static class EntryObject<K, V> {
	K key;
	V value;
	EntryObject next;

	public EntryObject(K k, V v, EntryObject<K, V> n) {
	    this.key = k;
	    this.value = v;
	    this.next = n;
	}
    }

    public MyHashtable() {
	map = new ArrayList<MyHashtable.EntryObject<K, V>>(size);
	for (int i = 0; i < size; i++) {
	    map.add(null);
	}
    }

    public static void main(String args[]) throws Exception {
	new TestHarness(new MyHashtable<String, String>()).run();
    }

    public synchronized void put(K key, V value) {
	if (key == null) {
	    return;
	}
	int position = hash(key);
	EntryObject<K, V> previous = null;
	EntryObject<K, V> current = map.get(position);
	EntryObject<K, V> temp = new EntryObject(key, value, null);
	if (current == null) {
	    map.set(position, temp);
	    return;
	}
	while (current != null) {
	    if (current.key.equals(key)) {
		current.value = value;
		return;
	    }
	    previous = current;
	    current = current.next;
	}
	previous.next = temp;
	return;
    }

    public synchronized V get(K key) {
	int position = hash(key);
	EntryObject<K, V> current = map.get(position);

	while (current != null) {
	    if (current.key.equals(key)) {
		return current.value;
	    }
	    current = current.next;
	}
	return null;
    }

    private int hash(K key) {
	return Math.abs(key.hashCode()) % size;
    }

    /**
     * A helper class that tests MyHashtable by feeding it puts and gets from
     * STDIN.
     */
    public static class TestHarness implements Runnable {
	final MyHashtable<String, String> hashtable;

	public TestHarness(MyHashtable<String, String> hashtable) {
	    this.hashtable = hashtable;
	}

	public void run() {
	    Scanner scanner = new Scanner(System.in);
	    while (scanner.hasNext()) {
		String k = scanner.next();
		String v = null;
		if (k.contains("=")) {
		    String[] split = k.split("\\=");
		    k = split[0];
		    v = split[1];
		}
		if (v == null) {
		    System.out.println(hashtable.get(k));
		} else {
		    hashtable.put(k, v);
		}
	    }
	}
    }
}