package interQ;

/**
 * Created by hellsapphire on 9/23/2015.
 */
public class PanagramCheck {

    public static void main(String[] args){
        String inp = " asaf dfdkfsd qe w dkas sdsa";
        panagramCheck(inp);
    }

    public static void panagramCheck(String str){
        // a 97, A 65
        int val = 0;

        for (int i=0; i<str.length(); i++){
            char temp = str.charAt(i);
            int tempVal = temp;
            if (temp == ' '){
                continue;
            }

            if (tempVal > 96){
                tempVal -=32;
            }
            tempVal -=65;

            val |= (1 << tempVal);
        }

        for (int i=0; i<26; i++){
            if (((val >> i) & 1) == 0){
                char missing = (char) (i+65);
                System.out.println(missing);
            }
        }
    }
}
