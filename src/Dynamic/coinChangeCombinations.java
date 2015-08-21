package Dynamic;

import java.math.BigInteger;
import java.util.*;

public class coinChangeCombinations {
	public static BigInteger ONE = new BigInteger("1");
	public static BigInteger ZERO = new BigInteger("0");
	
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int total = scan.nextInt();
        int numCoins = scan.nextInt();
        int[] coins = new int[numCoins];
        for (int i=0; i<numCoins; i++) {
        	coins[i] = scan.nextInt();
        }
        Arrays.sort(coins);
        scan.close();
        
        System.out.println(dynamicChangeCount(coins, total));
        
    }
	
	
	public static int recursiveChangeCount(int[] C, int m, int n) {
		if (m == 0) { return 1; };
		if (m < 0) {return 0;};
		if (m>=1 && n<=0) {return 0;}
		return recursiveChangeCount(C,m,n-1) + recursiveChangeCount(C,m-C[n-1],n);
	}
	
	public static BigInteger dynamicChangeCount(int[] C, int total) {
		BigInteger[][] M = new BigInteger[C.length+1][total+1];
		
		for (int r=0; r<C.length+1; r++) {
			for (int c=0; c<total+1; c++) {
				if (c == 0) { M[r][c] = ONE;}
				else if (r == 0) { M[r][c] = ZERO;}
				else {
					BigInteger temp = c-C[r-1] < 0 ? ZERO : M[r][c-C[r-1]];
					M[r][c] = temp.add(M[r-1][c]);
				}
			}
		}
		return M[C.length][total];
	}
	    
}
