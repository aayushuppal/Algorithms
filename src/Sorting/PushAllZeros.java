package Sorting;

public class PushAllZeros {

	public static void main(String[] args) {
		int[] IP = {1,4,5,6,7,8,9,0,2,0,1,0,4,5,0,-1,-2};
		//System.out.println(partition(IP,1,IP.length-1));
		AbsModPart(IP,1);
		System.out.println("asas");
	}
	
	 private static int[] partition(int[] a, int p, int r) {

	        int x = p;
	        int i = 0 ;
	        int j = r+1 ;

	        while (true) {
	            
	            while ( i< r && a[i] < x)
	                i++;
	            j--;
	            while (j>p && a[j] >= x)
	                j--;

	            if (i < j)
	                swap(a, i, j);
	            else
	                return a;
	        }
	    }
	 private static void swap(int[] a, int i, int j){
		 int temp = a[i];
		 a[i] = a[j];
		 a[j] = temp; 
	 }	

	 private static int[] ModPart(int[] a, int k){ // normal partition arranges smaller numbers on left
		 int i = 0;
		 int j = a.length-1;
		 
		 while(true){
			 if (i<j && a[i]<k ){
				 i++;
			 }
			 if (i<j && a[i] >= k){
				 swap(a,i,j);
				 j--;
			 }
			 if (i>=j){
				 return a;
			 }
		 }
		 
	 }
	 
	 private static int[] AbsModPart(int[] a, int k){ // partition arranges smaller numbers on right, compares absolute values
		 int i = 0;
		 int j = a.length-1;
		 
		 while(true){
			 if (j>i && Math.abs(a[j])<k ){
				 j--;
			 }
			 if (j>i && Math.abs(a[j]) >= k){
				 swap(a,i,j);
				 i++;
			 }
			 if (j<=i){
				 return a;
			 }
		 }
		 
	 }
}

