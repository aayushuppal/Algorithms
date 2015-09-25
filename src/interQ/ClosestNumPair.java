package interQ;
import java.util.*;

/**
 * Created by hellsapphire on 9/23/2015.
 */

public class ClosestNumPair {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = new int[scanner.nextInt()];

        for (int i=0; i < input.length; i++) {
            input[i] = scanner.nextInt();
        }

        List<Integer> output = getClosetNumbers(input);

        for (int i : output) {
            System.out.print(i+" ");
        }

        scanner.close();
    }

    private static List<Integer> getClosetNumbers(int[] input) {
        List<Integer> result = new ArrayList<Integer>();
        //Put your code here and add the closet numbers in the result list.

        int minimumDifference = Integer.MAX_VALUE;
        /* sorting the input ensures possible closest pairs are adjacent
        thus preventing the overhead of an n^2 pair search */
        Arrays.sort(input);

        for (int i=0; i<input.length-1; i++){
            int diff = Math.abs(input[i+1]-input[i]);
            if (diff < minimumDifference ){
                result.clear();
                result.add(input[i]);
                result.add(input[i+1]);
                minimumDifference = diff;
            } else if (diff == minimumDifference){
                result.add(input[i]);
                result.add(input[i+1]);
            }
        }


        return result;
    }
}