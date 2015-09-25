package uncategorised;

public class FindTriangles {

    public static void main(String[] args) {
	// int[] A = { 1, 3, 4, 7, 7, 9 };
	int[] A = { 1, 3, 4 };
	System.out.println(calTriangles(A));
    }

    public static int calTriangles(int[] Edges) {
	int len = Edges.length;
	int triangleCount = 0;
	for (int i = 0; i <= len - 2; i++) {
	    int k = i + 1;
	    for (int j = i + 1; j < len; j++) {
		int temp = Edges[i] + Edges[j];
		while (k + 1 < len && Edges[k + 1] < temp) {
		    k++;
		}
		triangleCount += k - 1;// (k + 1) - (j + 1); // k+1 - j+1
	    }
	}
	return triangleCount;
    }
}
