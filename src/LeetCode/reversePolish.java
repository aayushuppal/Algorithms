package LeetCode;

import java.util.Stack;

/**
 * Created by hellsapphire on 10/22/2015.
 * Evaluate Reverse Polish Notation
 * <p/>
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p/>
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * <p/>
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class reversePolish {

    public static void main(String[] args) {
        String[] tokens = {"0", "3", "/"}; //{"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            try {
                int a = Integer.parseInt(tokens[i]);
                stk.push(a);
            } catch (NumberFormatException e) {
                stk.push(calExp(tokens[i], stk.pop(), stk.pop()));
            }
        }
        return stk.pop();
    }

    private static int calExp(String op, int b, int a) {
        switch (op) {
            case "*":
                return a * b;
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "/":
                return a / b;
            default:
                return -1;
        }

    }

}
