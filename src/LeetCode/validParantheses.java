package LeetCode;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by hellsapphire on 10/22/2015.
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p/>
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class validParantheses {

    public static void main(String[] args) {
        System.out.println(isValid("(){}[({})]"));
    }

    public static boolean isValid(String str) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');

        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            Character x = str.charAt(i);
            if (map.keySet().contains(x)){
                stk.push(x);
            } else if (!stk.isEmpty() && map.values().contains(x) && map.get(stk.peek()) == x){
                stk.pop();
            } else {
                return false;
            }
        }

        return stk.isEmpty();
    }

}
