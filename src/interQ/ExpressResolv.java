package interQ;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by hellsapphire on 9/26/2015.
 */
public class ExpressResolv {

    public static void main(String[] args) {
        String input = "['/', 6, ['+', 1, ['*', 1, 1]]]";
        char[] inpArr = input.toCharArray();
        System.out.println(evaluate(inpArr));
    }

    public static int evaluate(char[] inp) {
        Stack<Character> opStack = new Stack<Character>();
        Stack<Integer> valStack = new Stack<Integer>();
        for (int i = 0; i < inp.length; i++) {

            if (Character.isDigit(inp[i])) {
                StringBuffer stBuff = new StringBuffer();
                stBuff.append(inp[i]);
                while (Character.isDigit(inp[i + 1])) {
                    i++;
                    stBuff.append(inp[i]);
                }
                valStack.push(Integer.parseInt(stBuff.toString()));
            } else if (isOperand(inp[i])) {
                opStack.push(inp[i]);
            }

        }

        while (!opStack.isEmpty()) {
            if (isMathOperator(opStack.peek())) {
                try {
                    Float val = solveExp(opStack.peek(), valStack.pop(), valStack.pop());
                    valStack.push(Math.round(val));
                } catch (NullPointerException e) {
                    return -1;
                } catch (EmptyStackException x) {
                    return -1;
                }
            }
            opStack.pop();
        }

        return valStack.pop();
    }

    private static boolean isOperand(char c) {
        switch (c) {
            case '*':
                return true;
            case '+':
                return true;
            case '-':
                return true;
            case '/':
                return true;
            case '[':
                return true;
            case ']':
                return true;
            default:
                return false;
        }
    }

    private static boolean isMathOperator(char c) {
        switch (c) {
            case '*':
                return true;
            case '+':
                return true;
            case '-':
                return true;
            case '/':
                return true;
            default:
                return false;
        }
    }

    private static Float solveExp(char op, int a, int b) {
        switch (op) {
            case '+':
                return (float) b + a;
            case '-':
                return (float) b - a;
            case '*':
                return (float) b * a;
            case '/':
                return (float) b / a;
            default:
                return null;
        }

    }
}
