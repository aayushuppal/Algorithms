package lrmp;

public class Solution {

    public static void main(String[] args) {
	int[] A = { 1, 5, 3, 4, 2, 5 };
	int X = 7;
	int D = 3;
	System.out.println(new Solution().solution(A, X, D));
    }

    public int solution(int[] A, int X, int D) {
	int Current = 0;
	int Final = X;
	int MaxJump = D;
	int[] availLeafs = new int[X + 1];

	// base case if frog's max jump is big enough to cross
	if (MaxJump >= X) {
	    return 0;
	}

	for (int i = 0; i < A.length; i++) {
	    availLeafs[A[i]] = 1;
	    if (A[i] > Current) {
		Current = A[i] - Current <= MaxJump ? A[i] : Current;
		Current = processAvailableLeafs(Current, availLeafs, MaxJump);
		if (checkFinalJump(Current, Final, MaxJump)) {
		    return i;
		}
	    }
	}

	// returning -1 when no jump is possible
	return -1;
    }

    /**
     * 
     * subroutine to check possibility of final landing on X
     */
    public boolean checkFinalJump(int current, int fin, int mj) {
	if (fin - current <= mj) {
	    return true;
	} else {
	    return false;
	}
    }

    /**
     * 
     * process existing leafs available in the pond to calculate max jump
     * feasible
     */
    public int processAvailableLeafs(int curr, int[] avail, int mj) {
	int i = curr + 1;

	while (i < avail.length && i - curr <= mj) {
	    if (avail[i] == 1 && i > curr) {
		curr = i;
	    }
	    i++;
	}

	return curr;
    }
}