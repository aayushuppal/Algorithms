package interQ;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hellsapphire on 9/24/2015.
 */
public class ValidPreOrder {

    public static void main(String[] args) {
        int[] inp = {1,3,4,2};
        System.out.println(isValidPreOrder(inp));
    }

    public static boolean isValidPreOrder(int[] inp) {
        int minVal = Integer.MIN_VALUE;
        Stack<Integer> stOrder = new Stack<Integer>();
        stOrder.push(inp[0]);
        int i = 1;
        while (i < inp.length) {
            if (inp[i] < minVal) {
                return false;
            }

            if (inp[i] < stOrder.peek()) {
                stOrder.push(inp[i]);
            }else {
                while(!stOrder.isEmpty() && stOrder.peek() < inp[i]){
                    minVal = stOrder.pop();
                }
                stOrder.push(inp[i]);
            }

            i++;
        }

        return true;
    }


}
