
public class LocalMaxMin {

	static int minextrem = 0;
	static int maxextrem = 0;

	public static void main(String[] args) {
		int[] A = {2,2,3,4,5,-1,3,3,2,5};
		///////////0,1,2,3,4, 5,6,7,8,9
		int lower = 0;
		int upper = 0;
		int cVal = A[0];		
		for (int i=1; i<A.length; i++){
			if (A[i] == cVal){
				cVal = A[i];
				upper = i;
			} else {
				isExtrm(lower,upper,A);
				lower = i;
				upper = i;
				cVal = A[i];
			}
		}
		isExtrm(lower,upper,A);
		
		System.out.println(minextrem+maxextrem);
		
	}
	
	public static boolean isExtrm(int a, int b, int[] A){
		if (a == 0){
			if (A[b] < A[b+1]){	System.out.printf("local min - %d,%d\n",a,b); minextrem++; return true; }
			else if (A[b] > A[b-1]){	System.out.printf("local max - %d,%d\n",a,b);  maxextrem++; return true;	} 
		}
		if (b == A.length-1){
			if (A[a] < A[a-1]){	System.out.printf("local min - %d,%d\n",a,b); 	minextrem++; return true; }
			else if (A[a] > A[a-1]){	System.out.printf("local max - %d,%d\n",a,b);  maxextrem++; return true;}
		}
		
		if (A[a-1]>A[a] && A[b]<A[b+1]){	System.out.printf("local min - %d,%d\n",a,b);  
			minextrem++; return true;
		}
		if (A[a-1]<A[a] && A[b]>A[b+1]){ 	System.out.printf("local max - %d,%d\n",a,b); 
			maxextrem++; return true;
			}
		else 
			return false;
		
	}

}
