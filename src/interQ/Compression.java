package interQ;
import java.util.*;
/**
 * Created by hellsapphire on 9/23/2015.
 */


public class Compression {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println(compress(scanner.next()));
        }

    }

    private static String compress(String input) {
        String result = null;
        if (input.length() == 0){
            return  result;
        }
        StringBuffer buffer = new StringBuffer();
        int tempCount = 1;
        char toCheck = input.charAt(0);
        for (int i=1; i<input.length(); i++){
            if (input.charAt(i) == toCheck){
                tempCount++;
            } else {
                if (tempCount > 1){
                    buffer.append(toCheck);
                    buffer.append(tempCount);
                } else {
                    buffer.append(toCheck);
                }
                toCheck = input.charAt(i);
                tempCount = 1;
            }
        }

        if (tempCount > 1){
            buffer.append(toCheck);
            buffer.append(tempCount);
        } else {
            buffer.append(toCheck);
        }
        result = buffer.toString();
        return result;
    }

}