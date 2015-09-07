package hashMap;

import java.util.ArrayList;
import java.util.List;

public class CustomHashMap<Key, Value> {
    private int size = 10;
    private List<EntryObject<Key, Value>> map;

    static class EntryObject<Key, Value> {
	Key key;
	Value value;
	EntryObject next;

	public EntryObject(Key k, Value v, EntryObject<Key, Value> n) {
	    this.key = k;
	    this.value = v;
	    this.next = n;
	}
    }

    public CustomHashMap() {
	map = new ArrayList<CustomHashMap.EntryObject<Key, Value>>(size);
	for (int i = 0; i < size; i++) {
	    map.add(null);
	}
    }

    public void put(Key k, Value v) {
	if (k == null) {
	    return;
	}
	int position = hash(k);
	EntryObject<Key, Value> previous = null;
	EntryObject<Key, Value> current = map.get(position);
	EntryObject<Key, Value> temp = new EntryObject(k, v, null);
	if (current == null) {
	    map.set(position, temp);
	    return;
	}
	while (current != null) {
	    if (current.key.equals(k)) {
		current.value = v;
		return;
	    }
	    previous = current;
	    current = current.next;
	}
	previous.next = temp;
	return;
    }

    public boolean remove(Key k) {
	int position = hash(k);
	EntryObject<Key, Value> previous = null;
	EntryObject<Key, Value> current = map.get(position);
	while (current != null) {
	    if (current.key.equals(k)) {
		if (previous == null) {
		    map.set(position, current.next);
		    return true;
		} else {
		    previous.next = current.next;
		    return true;
		}
	    }
	    previous = current;
	    current = current.next;
	}

	return false;

    }

    public Value get(Key k) {
	int position = hash(k);
	EntryObject<Key, Value> current = map.get(position);

	while (current != null) {
	    if (current.key.equals(k)) {
		return current.value;
	    }
	    current = current.next;
	}
	return null;
    }

    public void display() {
	for (int i = 0; i < size; i++) {
	    System.out.print("\n[" + i + "]");
	    EntryObject<Key, Value> current = map.get(i);
	    while (current != null) {
		System.out.print(">" + "(" + current.key + "," + current.value
			+ ")");
		current = current.next;
	    }
	}
    }

    private int hash(Key key) {
	return Math.abs(key.hashCode()) % size;
    }

    public static void main(String[] args) {
	CustomHashMap<Integer, String> cMap = new CustomHashMap();
	cMap.put(12, "twelve");
	cMap.put(10, "ten");
	cMap.put(2, "two");
	cMap.put(22, "twenty two");
	cMap.display();

	cMap.put(12, "XII");

	cMap.display();
	System.out.println("\n" + cMap.get(2));
	System.out.println(cMap.remove(2));
	cMap.display();

    }

}
