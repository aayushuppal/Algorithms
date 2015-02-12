package Sorting;

public class MyMergeSort{
	
	public static void main(String[] args){
	int arr[] = {9,6,1,2,4,7,8};
	arr = MergeSort(arr,0,arr.length-1);
	System.out.println(arr);
	}
	
	public static int[] MergeSort(int[] A,int low, int high){
	if(low<high){
		int m = (low+high)/2;
		MergeSort(A,low,m);
		MergeSort(A,m+1,high);
		return Merger(A,low,m,high);
	}
	else return null;
	}
	
	public static int[] Merger(int[] A,int low, int mid, int high){
		int[] tempArr = new int[high+1]; 
		for(int i=low;i<=high;i++){
			tempArr[i] = A[i];
		}
		int i=low,j=mid+1,k=low;
		while(i<=mid && j<=high){
			if (tempArr[i]<tempArr[j]){
				A[k] = tempArr[i];
				i++;
			}
			else{
				A[k] = tempArr[j];
				j++;
			}
			k++;
		}
		while(i<=mid){ // because all the upper half values are already in A we need to check for the case when
					   // the bigger values in lower half of temp array and they need to be updated here.
			A[k] = tempArr[i];
			k++;
			i++;
		}
		return A;
	} 
}
	
