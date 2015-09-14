package dp_recursion;

public class NStairs {
    // reach nth stair by taking either 1 || 2 || 3 step jump
    // here order of steps matters, so simpler

    public static void main(String[] args) {
	int n = 4;
	System.out.println(countSteps(n));
    }

    public static int countSteps(int n) {
	if (n < 0) {
	    return 0;
	}
	if (n == 0) {
	    return 1;
	}
	return countSteps(n - 1) + countSteps(n - 2) + countSteps(n - 3);
    }
}
