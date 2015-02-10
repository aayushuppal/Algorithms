package Cormen;
import java.util.LinkedList;

public class prob2_4{
	
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
	prob2_4 pob = new prob2_4();
	nll = pob.SortBy2(nll, 11);
	System.out.println("print sorted list");
	System.out.println(nll);
	
}


public LinkedList<Integer> SortBy2(LinkedList<Integer> ll, int a){
	LinkedList<Integer> aa = new LinkedList<Integer>(); 
	LinkedList<Integer> bb = new LinkedList<Integer>();
	LinkedList<Integer> cc = new LinkedList<Integer>();
	
	for(int i=0; i<ll.size(); i++){
		if(ll.get(i) < a){
			aa.add(ll.get(i));
		}
		else if(ll.get(i) == a){
			bb.add(ll.get(i));
		}
		else{
			cc.add(ll.get(i));
		}
	}
	aa.addAll(bb);
	aa.addAll(cc);
	return aa;
}









public LinkedList<Integer> SortBy(LinkedList<Integer> ll, int a){
	LinkedList<Integer> kll = new LinkedList<Integer>();
	for(int i=0; i<ll.size(); i++){
		if (ll.get(i)<a){
			kll.add(ll.get(i));
			ll.remove(i);
			i--;
		}
	}
	for(int i=0; i<ll.size(); i++){
		if (ll.get(i)==a){
			kll.add(ll.get(i));
			ll.remove(i);
			i--;
		}
	}
	for(int i=0; i<ll.size(); i++){
		if (ll.get(i)>a){
			kll.add(ll.get(i));
			ll.remove(i);
			i--;
		}
	}
	return kll;
}


}