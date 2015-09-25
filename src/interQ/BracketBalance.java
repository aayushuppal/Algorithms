package interQ;

import java.util.Stack;

/**
 * Created by hellsapphire on 9/23/2015.
 */
public class BracketBalance {

    public static void main(String[] args) {
        String inp = "(){}()()((({})))";
        System.out.println(isBracketBalanced(inp));
    }

    public static boolean isBracketBalanced(String str) {
        Stack<Character> brackStack = new Stack<Character>();

        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (temp != ')' && temp != '}') {
                brackStack.push(temp);
            } else if (temp == ')') {
                if (!brackStack.isEmpty() && !brackStack.pop().equals('(')) {
                    return false;
                }
            } else if (temp == '}') {
                if (!brackStack.isEmpty() && !brackStack.pop().equals('{')) {
                    return false;
                }
            }
        }

        if (brackStack.isEmpty()) {
            return true;
        }
        return false;
    }
}
