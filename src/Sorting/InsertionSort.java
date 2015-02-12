package Sorting;

public class InsertionSort {

	public static void main(String[] args) {
		int[] a = {2,5,1,4,3,7,8,9};
		
		for (int i=1; i<a.length;i++){
			int activeNum = a[i];
			int activeElementIndex = i;
			while(activeElementIndex > 0 && a[activeElementIndex-1] > activeNum){
				a[activeElementIndex] = a[activeElementIndex-1];
				activeElementIndex--;
			}
			a[activeElementIndex] = activeNum;
			
		}
		System.out.println(a);
	}

}
