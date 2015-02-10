package Cormen;

import java.util.Random;
import java.util.Scanner;

public class prob7 {

	public static void main(String[] args) {
		Random ran = new Random();
		System.out.println("start input m and n");
		Scanner inp = new Scanner(System.in);
		int m = inp.nextInt();
		int n = inp.nextInt();
		inp.close(); 
		
		//int m =5; int n= 4;
		
		int[][] mat = new int[m][n];
		for (int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				mat[i][j] = ran.nextInt((10-0)+0)+0;
			}
		}
		boolean[] row = new boolean[mat.length];
		boolean[] col = new boolean[mat[0].length];
		
		for (int k=0; k<m;k++){
			for(int p=0; p<n; p++){
			if (mat[k][p] == 0){
				row[k] = true; col[p] = true;
				}	
			}
		}
		
		for (int k=0; k<m;k++){
			for(int p=0; p<n; p++){
			if(row[k]||col[p]){ mat[k][p] = 0; }
			}
		}
		System.out.println("done");	
	}

}
