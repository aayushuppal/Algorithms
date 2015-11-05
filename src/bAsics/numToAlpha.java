package bAsics;

/**
 * Created by hellsapphire on 10/15/2015.
 * number to alphabet string
 * bloomberg
 */
public class numToAlpha {

    public static void main(String[] args) {
        //+65 for alphabet
        int num = 703;
        String res = "";
        while (num > 0) {
            num--;
            int rem = num % 26;
            char x = (char) (rem + 65);
            res = x + res;
            num = (num) / 26;
        }
        System.out.println(res);
    }
}
