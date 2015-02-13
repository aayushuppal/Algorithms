package pastAmaz;
import java.util.Stack;

public class SunBuilding {

	public static void main(String[] args) {
	int[] BuilHeight = {20,30,40,30,20,30,20,30,30};
	Stack<Integer> st = new Stack<Integer>(); // building heights
	Stack<Integer> st2 = new Stack<Integer>(); // building numbers
	
	// Traversing Left to right
	// if we encounter a bigger building remove the buildings smaller than it and then add it
	
	for (int i=0;i<BuilHeight.length;i++){
				
		while (!st.isEmpty() && BuilHeight[i]>st.peek()){
			st.pop();
			st2.pop();
		}
		st.add(BuilHeight[i]);
		st2.add(i+1);
		
	}
	
		/* Traversing from right to left -- simpler solution add the greater values only
		int base = 0;
		for (int i=BuilHeight.length-1; i>=0; i--){
			if (BuilHeight[i] >= base){
				st.add(BuilHeight[i]);
				st2.add(i+1);
				base = BuilHeight[i];
			}
		}
		*/

		System.out.println("asasa");
	
	}
}
