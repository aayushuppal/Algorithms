package bAsics;

/**
 * Created by hellsapphire on 10/11/2015.
 */
//bloomberg question
public class aToI {

    public static void main(String[] args){
        String s = "-a1234";
        System.out.println(myAtoi(s));
    }

    public static int myAtoi(String str){
        if (str == null || str.length() < 1){
            return 0;
        }
        str = str.trim();

        char sign = '+';
        int i=0;

        if (str.charAt(i) == '-'){
            sign = '-';
            i++;
        } else if (str.charAt(i) == '+') {
            sign = '+';
            i++;
        }
        double res = 0;
        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            res = res * 10 + (str.charAt(i) - '0');
            i++;
        }

        if (sign == '-') {
            res = -res;
        }

        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) res;

    }
}
