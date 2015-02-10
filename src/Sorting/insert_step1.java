package Sorting;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class insert_step1 {
    
    

    public static void insertionSortPart2(int[] ar) {
       int max = ar.length-1;
       for(int i=1; i<=max; i++){
    	   int base = i;
    	   while(i>0 && ar[i]<ar[i-1]){
    		   int temp = ar[i-1];
    		   ar[i-1] = ar[i];
    		   ar[i] = temp;
    		   i--;
    	   }
    	   i = base;
    	   printArray(ar);
       }
    }
    
    
/* Tail starts here */
     public static void main(String[] args) {
    	 Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
         for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
         }
         in.close();
         insertionSortPart2(ar);
    }
    
    
    private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
   }
    
    
}
