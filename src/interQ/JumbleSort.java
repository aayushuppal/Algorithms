package interQ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hellsapphire on 9/23/2015.
 */
public class JumbleSort {

    public static void main(String[] args){
        String inp = "asd 23 45 -78 rty 89 sfdf wew ads aay";
        System.out.println(inp);
        String[] inpArr  = inp.split(" ");
        List<String> StringList = new ArrayList<String>();
        List<Integer> IntegerList = new ArrayList<Integer>();

        for (String s:inpArr){
            if (isValidInteger(s)){
                IntegerList.add(Integer.parseInt(s));
            } else {
                StringList.add(s);
            }
        }
        Collections.sort(StringList);
        Collections.sort(IntegerList);
        int strListPtr = 0;
        int integListPtr = 0;

        for (int i=0; i<inpArr.length; i++){
            if (isValidInteger(inpArr[i])){
                inpArr[i] = Integer.toString(IntegerList.get(integListPtr));
                integListPtr++;
            } else {
                inpArr[i] = StringList.get(strListPtr);
                strListPtr++;
            }
        }

        StringBuffer buffer = new StringBuffer();
        for (int i=0; i<inpArr.length-1; i++){
            buffer.append(inpArr[i]);
            buffer.append(" ");
        }
        buffer.append(inpArr[inpArr.length-1]);
        System.out.println(buffer.toString());

    }

    public static boolean isValidInteger(String inp){
        try{
            Integer.parseInt(inp);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

}
