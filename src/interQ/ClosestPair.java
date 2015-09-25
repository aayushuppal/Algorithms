package interQ;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by hellsapphire on 9/23/2015.
 */
public class ClosestPair {

    public static void main(String[] args){
        int[] inp = {3,4,2,1,5,7,3};
        Arrays.sort(inp);
        for(int x: inp){
            System.out.print(x + " ");
        }
        System.out.println();
        int[] res = closestDigits(inp);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    public static int[] closestDigits(int[] digits){
        int[] indices = new int[2];
        int diff = Integer.MAX_VALUE;
        for (int i=0; i<digits.length-1; i++){
            if (Math.abs(digits[i+1]-digits[i]) < diff){
                indices[0] = i;
                indices[1] = i+1;
                diff = Math.abs(digits[i+1]-digits[i]);
            }
        }
        return indices;
    }
}
