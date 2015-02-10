package Sorting;
import java.util.*;

public class qst {
	static int[] arr = {2,4,1,7,23,45,12,78,44}; //   2,9,20,14,12,72,20
	public static void main(String[] args) {
		int st = 0;
		int en = arr.length-1;
		qsort(arr,st,en);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void qsort(int[] arr,int st, int en){
		if(st<en){
			int m = part(arr,st,en);
			qsort(arr,st,m);
			qsort(arr,m+1,en);
		}
	}
	
	public static int part(int[] arr, int st, int en){
		int p = arr[st];
		int i = st-1;
		int j = en+1;
		
		while(true){
			i++;	
			while(i<en && arr[i]<p)
				i++;
			j--;
			while(j>st && arr[j]>=p)
				j--;
			if(i<j)
				exchange(i,j);
			else
				return j;
		}
	}
	
	public static void exchange(int l, int r){
		int temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
	}

}
