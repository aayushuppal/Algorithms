package Arrays;
/*use a hashmap of key=arr value and value= arr index 
 * search for the number-key and if it exists in hashmap return it's value
*/

import java.util.HashMap;

public class SumAndArray {
	public static void main(String[] args) {
		int[] a = {1,7,9,10,12};
		int k = 22;
		HashMap<Integer, Integer> hmp = new HashMap<Integer,Integer>();
		
		for (int i=0; i<a.length;i++){
			hmp.put(a[i],i);
		}
		
		for (int i=0; i<a.length;i++){
			if(hmp.containsKey((k-a[i]))){
				System.out.printf("%d,%d",i,hmp.get(k-a[i]));
				break;
			}
		}
		
	}

}
