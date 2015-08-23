package matrix;

import java.util.Random;

public class Matrix90TurnClockwise {
	
	public static void main(String[] args) {
		int n = 3;
		Random rand = new Random();
		int[][] M = new int[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				M[i][j] = rand.nextInt(10)+1;
			}
		}
		turn90(M,3);
	}
	
	public static int[][] turn90 (int[][] M, int n) {
		for (int layer=0; layer<n/2; layer++){
			// layer corresponds to start row,col value
			int last = n-1-layer;
			for (int i=layer; i<last; i++){
				int top = M[layer][i];
				M[layer][i] = M[last-i][layer];
				//left 
				M[last-i][layer] = M[last][last-i];
				//bottom 
				M[last][last-i] = M[i][last];
				//right
				M[i][last] = top;
			}
			
		}
		return M;
	}
	
}
