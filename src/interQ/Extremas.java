package interQ;

import java.util.Scanner;

/**
 * Created by hellsapphire on 9/23/2015.
 */
public class Extremas {

    public static void main(String[] args) {
        //String inp = "2234534423"; //"22"; //22223334444222
        while (true) {
            Scanner in = new Scanner(System.in);
            String inp = in.nextLine();

            System.out.println(getExtremaCount(inp));
        }

    }

    public static int getExtremaCount(String str) {
        if (str.length() == 0) {
            return 0;
        }
        int extCount = 1;
        char prev = str.charAt(0);
        int direction = 0;  //0 - initial, 1 - increasing, -1 - decreasing
        int tempdirection = 0;
        for (int i = 1; i < str.length(); i++) {

            if (str.charAt(i) - prev > 0) {
                tempdirection = 1;
            } else if (str.charAt(i) - prev < 0) {
                tempdirection = -1;
            }
            if (tempdirection != direction) {
                direction = tempdirection;
                extCount++;
            }
            prev = str.charAt(i);
        }

        return extCount;
    }
}

