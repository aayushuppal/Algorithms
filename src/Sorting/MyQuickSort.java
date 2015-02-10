package Sorting;

import java.util.*;

public class MyQuickSort {

    
    public static void main(String[] args) {

        //int[] a = { 1, 23, 45, 2, 8, 134, 9, 4, 2000 };
    	//int a[]={23,44,1,2009,2,88,123,7,2009,1040,88};
    	int[] a = {2,4,1,7,23,45,12,78,44};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
        
    }

    public static void quickSort(int[] a, int p, int r)
    {
        if(p<r)
        {
            int q=partition(a,p,r);
            quickSort(a,p,q);
            quickSort(a,q+1,r);
        }
    }

    private static int partition(int[] a, int p, int r) {

        int x = a[p];
        int i = p-1 ;
        int j = r+1 ;

        while (true) {
            i++;
            while ( i< r && a[i] < x)
                i++;
            j--;
            while (j>p && a[j] >= x)
                j--;

            if (i < j)
                swap(a, i, j);
            else
                return j;
        }
    }

    private static void swap(int[] a, int i, int j) {
        // TODO Auto-generated method stub
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}