package Cormen;
import java.util.*;

public class prob2_5 {
	static int a;
	public static void main(String[] args) {
		LinkedList<Integer> aa = new LinkedList<Integer>();
		LinkedList<Integer> bb = new LinkedList<Integer>();
		LinkedList<Integer> cc = new LinkedList<Integer>();
		
		aa.add(2);
		aa.add(7);

		bb.add(2);
		bb.add(3);
		
		if(aa.size() >= bb.size()){ 
			a = aa.size();
		}
		else{ a= bb.size();}
		
		int cr = 0;
		
		for(int i=0; i<a; i++){
			int x = 0;
			int y = 0;
			if(i < aa.size()){
				x = aa.get(i);
			} 
			if(i < bb.size()){
				y = bb.get(i);
			}
			int z = x+y+cr;
			int temp = z%10;
			cc.add(temp);
			cr = z/10;
		}
		if (cr > 0){cc.add(cr);}
		System.out.println(cc);
	}

}
