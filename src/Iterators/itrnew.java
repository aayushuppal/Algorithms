package Iterators;

import java.util.*;

public class itrnew implements Iterator{
	Collection c;
	Iterator itr;
	ArrayList objs = new ArrayList();
	
	itrnew(Collection x){
		c = x;
		if(!c.isEmpty()){
			extall(c);
			itr = objs.iterator();
		}
		else{
			System.out.println("empty condition");
		}
	}
	
	private void extall(Collection obj){
		Iterator itr = obj.iterator();
		while(itr.hasNext()){
			Object o = itr.next();
			if(o != null){
				if(o instanceof Collection){
					extall((Collection)o);
				} else {
					objs.add(o);
				}
			}
		}
	}
	
	public static void main(String[] args) {
	ArrayList<ArrayList> al = new ArrayList<ArrayList>();
	al.add(0,new ArrayList());
	al.add(1,new ArrayList());
	al.add(2,new ArrayList());
	al.add(3,new ArrayList());
	
	for(ArrayList v : al){
		v.add("gsdvada");
		v.add("sdbshdbsand");
		v.add("gbjhsdsda");
	}
	itrnew it = new itrnew(al);
		while(it.hasNext()){
			System.out.print(it.next()+" ");
		}
	}

	@Override
	public boolean hasNext() {
		if(itr != null) {
			boolean cc = itr.hasNext(); 
			return cc;
		}
		return false;
	}

	@Override
	public Object next() {
		if(itr != null) {
			return itr.next();
		}
		return null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

}