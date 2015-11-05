package bAsics;

import java.util.Scanner;

/**
 * Created by hellsapphire on 10/12/2015.
 * marketo is it possible
 */
public class isItPossible {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a,b,c,d;

        a = in.nextInt();
        in.nextLine();
        b = in.nextInt();
        in.nextLine();
        c = in.nextInt();
        in.nextLine();
        d = in.nextInt();

        in.close();

        System.out.println(isitpossible(a,b,c,d));
    }

    public static String isitpossible(int a, int b, int c, int d){
        if (binaryTrav(a, b, c, d)){
            return "YES";
        } else {
            return "NO";
        }
    }

    public static boolean binaryTrav(int x, int y, int c, int d){
        if (x==c && y==d){
            return true;
        }

        if (x>c || y>d){
            return false;
        }

        return binaryTrav(x + y, y, c, d) || binaryTrav(x, x + y, c, d);
    }



}
