package uncategorised;

import java.util.Scanner;

public class PointDistance {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int x1 = in.nextInt();
	int y1 = in.nextInt();
	int x2 = in.nextInt();
	int y2 = in.nextInt();
	in.close();
	int[] res = findPoint(x1, y1, x2, y2);
	System.out.println(res[0] + ", " + res[1]);
    }

    public static int[] findPoint(int x1, int y1, int x2, int y2) {
	int C = (int) (Math.pow(x1, 2) + Math.pow(y1, 2) - Math.pow(x2, 2) - Math
		.pow(y2, 2));
	int A = x1 - x2;
	int B = y1 - y2;
	int[] a = new int[2];
	for (int x3 = -100; x3 <= 100; x3++) {
	    for (int y3 = -100; y3 <= 100; y3++) {
		a[0] = x3;
		a[1] = y3;
		if (isCondition(C, A, B, a)) {
		    return a;
		}
	    }
	}
	return a;
    }

    public static boolean isCondition(int C, int A, int B, int[] c) {
	return C > 2 * c[0] * A + 2 * c[1] * B ? true : false;
    }

}