package Iterators;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MyIterator implements Iterator {
	
	Collection c;
	ArrayList objs = new ArrayList();
	Iterator itr = null;
	
	public MyIterator(Collection obj) {
		c = obj;
		if(!c.isEmpty()) {
			extractAll(c);
			itr = objs.iterator();
		}
	}
	
	private void extractAll(Collection obj) {
		Iterator itr = obj.iterator();
		while(itr.hasNext()) {
			Object o = itr.next();
			if(o != null) {
				if(o instanceof Collection) {
					extractAll((Collection)o);
				} else {
					objs.add(o);
				}				
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<ArrayList> vals = new ArrayList<ArrayList>();
		vals.add(0, new ArrayList());
		vals.add(1, new ArrayList());
		vals.add(2, new ArrayList());
		vals.add(3, new ArrayList());
		int count = 0;
		for(ArrayList v : vals) {
			int temp = count;
			for(int i=temp; i<temp+3; i++) {
				v.add(i);
				count++;
			}			
		}
		vals.add(4, new ArrayList());
		
		// Sample Input is [[0,1,2],[3,4,5],[6,7,8],[9,10,11],[]]
		
		MyIterator it = new MyIterator(vals);
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
	}

	public boolean hasNext() {
		if(itr != null) {
			return itr.hasNext();
		}
		return false;
	}

	public Object next() {
		if(itr != null) {
			return itr.next();
		}
		return null;
	}

	// Not overriden
	public void remove() {
		
	}
}