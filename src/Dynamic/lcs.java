package Dynamic;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class lcs {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("inputs");
        int len1 = inp.nextInt();
        int len2 = inp.nextInt();
        int[] arr1 = new int[len1];
        int[] arr2 = new int[len2];
        
        for(int i=0; i<len1; i++){
        	arr1[i] = inp.nextInt();	
        }
        for(int i=0; i<len2; i++){
        	arr2[i]=inp.nextInt();
        }
        inp.close();
        

		arr1 = skipByOne(arr1);
		arr2 = skipByOne(arr2);
		ArrayList<Integer> ll = new ArrayList<Integer>();
		
        int[][] C = new int[arr1.length][arr2.length];
        int[][] D = new int[arr1.length][arr2.length];
        for(int i=0; i<=len1; i++){
        	for(int j=0; j<=len2; j++){
        		if(i==0 || j==0){ C[i][j] = 0; D[i][j] = 0;}
        		else if(arr1[i] == arr2[j]){
        			C[i][j] = C[i-1][j-1]+1;
        			D[i][j] = 1;
        		}
        		else{
        			C[i][j] = maxOf(C[i][j-1],C[i-1][j]);
        			if(C[i][j-1] > C[i-1][j]){
        				D[i][j] = 2;
        			}
        			else{ D[i][j] = 3; }
        		}
        	}
        }
        //System.out.println(C[len1][len2]);
        int l = len1;
		int p = len2;		
		while(D[l][p] != 0 ){
			if (D[l][p] == 1){
				ll.add(arr1[l]);
				p--;
				l--;
			}
			else if(D[l][p] == 2){
				p--;
			}
			else if(D[l][p] == 3){
				l--;
			}
		}
		int v = ll.size();
		String zs = "";
		for (int b=v-1; b>=0; b--){
			zs = zs+" "+ll.get(b);
		}
		System.out.println(zs.substring(1));
    }
    
	public static int[] skipByOne(int[] a){
		int last = a.length;
		int[] temp = new int[last+1];
		temp[0]=0;
		int i=1;
		for(int x:a){
			temp[i] = x;
			i++;
		}
		return temp;
	}

	public static int maxOf(int a, int b){
		if (a>=b){
			return a;
		}
		else{
			return b;
		}
	}
}