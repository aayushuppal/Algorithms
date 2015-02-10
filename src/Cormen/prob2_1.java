package Cormen;
import java.util.*;

public class prob2_1{
	
public static void main(String[] args){
	LinkedList<Integer> nll = new LinkedList<Integer>();
	nll.add(10);
	nll.add(11);
	nll.add(10);
	nll.add(15);
	nll.add(12);
	nll.add(11);
	nll.add(10);
	nll.add(11);
	nll.add(10);
	System.out.println("print initial list");
	System.out.println(nll);
	prob2_1 pob = new prob2_1();
	pob.deldup2(nll);
	System.out.println(nll);
}
	
public void deldup(LinkedList<Integer> ll){
	Hashtable<Integer, Boolean> nht = new Hashtable<Integer, Boolean>();
	for (int i=0; i<ll.size(); i++){
		if(nht.containsKey(ll.get(i))){
			ll.remove(i);
			i--;
		}
		else{
			nht.put(ll.get(i), true);
		}
	}
}

public void deldup2(LinkedList<Integer> ll){
	for (int i=0; i<ll.size(); i++){
		int a = ll.get(i);
		for(int j=i+1; j<ll.size(); j++){
			if(ll.get(j) == a){ll.remove(j); j--;}
		}
	}
}

}