package Cormen;

import java.util.Random;
import java.util.ArrayList;

public class prob7b {

	public static void main(String[] args) {
		Random ran = new Random();
		int m =5; int n= 4;
		
		int[][] mat = new int[m][n];
		for (int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				mat[i][j] = ran.nextInt((10-0)+0)+0;
			}
		}
		ArrayList<Integer> row = new ArrayList<Integer>();
		ArrayList<Integer> col = new ArrayList<Integer>();
		for(int i=0; i<m; i++){ row.add(i);}
		for(int i=0; i<n; i++){ col.add(i);}
		
		for (int k:row){
			for(int p:col){
				if (mat[k][p] == 0){
					// the work around could be setting a row and col flag and not setting zeros until mak k and p is reached
					//set all elements of row k 0
					for(int l=0;l<n;l++){mat[k][l] = 0;}
					//set all elements of col p 0
					for(int l=0;l<m;l++){mat[l][p] = 0;}
					row.remove(k);
					col.remove(p);
				}
			}
		}
		
		System.out.println("done");	
	}

}
