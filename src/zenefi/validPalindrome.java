package zenefi;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hellsapphire on 10/5/2015.
 */
public class validPalindrome {

    public static void main(String[] args) {
        String in = "A man, a plan, a canal: Panama";
        //String in = "race a dar";
        Set<Integer> preSet = new HashSet<Integer>();
        Set<Integer> suffSet = new HashSet<Integer>();
        preSet.equals(suffSet)

        int i = 0;
        int j = in.length() - 1;

        boolean result = true;

        while (i <= j) {
            while ( !Character.isLetterOrDigit(in.charAt(i)) ){
                i++;
            }

            Character tempI = Character.toLowerCase(in.charAt(i));



            while (!Character.isLetterOrDigit(in.charAt(j))){
                j--;
            }
            Character tempJ = Character.toLowerCase(in.charAt(j));

            if (!tempI.equals(tempJ)){
                result = false;
                break;
            }
            i++;
            j--;
        }

        System.out.println(result);
    }

}
