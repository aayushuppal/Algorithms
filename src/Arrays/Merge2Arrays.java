package Arrays;

public class Merge2Arrays {

	
	public static void main(String[] args) {
		int [] A = {2,5,9,10,11};
		int [] B = {1,2,4,6,8,12};
		
		int[] C = new int[A.length +B.length];
		int i=0,j=0,k=0;
		
		while (i < A.length && j < B.length){
			if (A[i] < B[j]){
				C[k] = A[i];
				i++;
			}
			else {
				C[k] = B[j];
				j++;
			}
			k++;
		}
		
		while (i < A.length){	C[k] = A[i];	i++;	k++;	}
		
		while (j < B.length){	C[k] = B[j];	j++;	k++;	}
		
		for (int x:C){
			System.out.println(x);
		}
			
	}

}