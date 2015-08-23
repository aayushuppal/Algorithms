package matrix;

import java.util.Random;

public class MatrixByLayer {
	
	public static enum DIR {TOP,RIGHT,BOTTOM,LEFT};
	public static enum ROTATION {CLOCKWISE, ANTICLOCKWISE};
	
	public static void main(String[] args) {
		int n = 9;
		Random rand = new Random();
		int[][] M = new int[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				M[i][j] = rand.nextInt(10)+1;
			}
		}
		traverseMat(M, n, ROTATION.CLOCKWISE);
	}
	
	public static void traverseMat(int[][] M,int n, ROTATION rt) {
		if (rt == ROTATION.CLOCKWISE) {
			int loop_start_r = 0, loop_start_c=0;
			int r=0, c=0, up_boundary = n-1, low_boundary = 0;
			DIR dr = DIR.TOP;
			while (r<n && c<n && up_boundary > low_boundary) {
				System.out.println(r+","+c+" "+M[r][c]);
				switch (dr) {
				case TOP:
					c++;
					if (c == up_boundary) {
						dr = DIR.RIGHT;
					}
					break;
				case RIGHT:
					r++;
					if (r == up_boundary) {
						dr = DIR.BOTTOM;
					}
					break;
				case BOTTOM:
					c--;
					if (c == low_boundary) {
						dr = DIR.LEFT;
					}
					break;
				case LEFT:
					r--;
					if (r == low_boundary) {
						dr = DIR.TOP;
					}
					break;
				default:
					break;
				}

				if (r == loop_start_r && c == loop_start_c) {
					up_boundary--; low_boundary++;
					r++; c++;
					loop_start_r = r; loop_start_c = c;
				}
				if (up_boundary == low_boundary) {
					System.out.println(r+","+c+" "+M[r][c]);
				}
			}
		}
		
	}
	
	
}
