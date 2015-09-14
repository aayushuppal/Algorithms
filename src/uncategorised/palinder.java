package uncategorised;

import java.util.Scanner;
import java.util.Stack;

public class palinder {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	String input = "";
	boolean xt = true;
	while (xt) {
	    input = in.nextLine();
	    if (input.equals("exit")) {
		xt = false;
	    } else {
		System.out.println(isPalindrome(input));
	    }
	}
	in.close();
	System.exit(-1);
    }

    public static boolean isPalindrome(String in) {
	Stack<Character> charStack = new Stack<Character>();
	int i = 0;
	int len = in.length();
	for (i = 0; i < len / 2; i++) {
	    charStack.push(in.charAt(i));
	}
	i = len % 2 == 0 ? i : i + 1;

	while (i < len) {
	    if (!charStack.pop().equals(in.charAt(i))) {
		return false;
	    }
	    i++;
	}

	return true;
    }
}

class rty {

    public int ert() {

    }
}
