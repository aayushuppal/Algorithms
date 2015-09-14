package dp_recursion;

import java.util.ArrayList;
import java.util.List;

public class ABProblem {
    public static List<String> result = new ArrayList<String>();

    public static void main(String[] args) {
	int k = 5;
	int l = 10;
	System.out.println(getABString("", k, l));
	for (String res : result) {
	    System.out.println(res);
	}

    }

    public static boolean getABString(String x, int k, int l) {
	if (x.length() > l || getCombinations(x) > k) {
	    return false;
	}
	if (x.length() == l && getCombinations(x) == k) {
	    result.add(x);
	    return true;
	}
	return getABString(x + "A", k, l) || getABString("B" + x, k, l)
		|| getABString("A" + x, k, l) || getABString(x + "B", k, l);
    }

    public static int getCombinations(String str) {
	int combinations = 0;
	int len = str.length();
	for (int i = 0; i < len; i++) {
	    if (str.charAt(i) == 'A') {
		for (int j = i + 1; j < len; j++) {
		    if (str.charAt(j) == 'B') {
			combinations++;
		    }
		}
	    }
	}
	return combinations;
    }
}
