package hack_go_daddy;

/**
 * Created by hellsapphire on 10/3/2015.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DPairs {

    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int D = in.nextInt();
        in.close();
        calMinCountNeeded(N, D);
    }

    public static void calMinCountNeeded(int N, int D) {
        int X = N % 2 == 0 ? (N / 2)+D : (N / 2)+D+1;
        System.out.println(X);
    }


}

