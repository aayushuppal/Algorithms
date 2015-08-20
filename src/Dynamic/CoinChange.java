package Dynamic;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		int[] coins = {1,5,6,8};
		Arrays.sort(coins);
		int total = 8;
		int[][] sumMat = returnMinCoinsNeeded(total, coins);
		System.out.println(sumMat[coins.length-1][total]);
		printCoins(sumMat, coins.length-1, total, coins);
	}
	
	public static int[][] returnMinCoinsNeeded(int total, int[] coins) {
		int Mat[][] = new int[coins.length][total+1];
		for (int r=0; r<coins.length; r++) {
			for (int c=0; c<total+1; c++) {
				if (c == 0) {
					Mat[r][c] = 0; //because you need 0 coins to attain a total of 0
				} else if (r == 0) {
					if (c < coins[r]) { Mat[r][c] = c; }
					else { Mat[r][c] = Math.min(c,1+Mat[r][c-coins[r]]); }
				} else {
					if (c < coins[r]) { Mat[r][c] = Mat[r-1][c]; }
					else { Mat[r][c] = Math.min(Mat[r-1][c],1+Mat[r][c-coins[r]]); }
				}
				
			}
		}
		return Mat;
	}
	
	public static void printCoins(int[][] Mat, int r,int c, int[] coins) {
		int temp = Mat[r][c];
		
		while (temp !=0) {
			if (c < coins[r]) {
				r--;
			} else if (temp == 1+Mat[r][c- coins[r]]) {
				temp = Mat[r][c- coins[r]];
				c = c- coins[r];
				System.out.println(coins[r]);
			} else {
				r--;
			}
		}
	}
	
}
