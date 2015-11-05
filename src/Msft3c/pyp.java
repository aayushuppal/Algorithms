package Msft3c;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by hellsapphire on 10/6/2015.
 */
public class pyp {

    public static void main(String[] args) {
        HashMap<Integer,prob> probMap = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int tt = in.nextInt();
        String s = in.next();

        while (in.hasNext()) {

            String[] arr = s.split(",");
            prob p = new prob(arr[0], arr[1], arr[2]);
            probMap.put(p.id, p);
            s = in.next();
        }

        System.out.println("asas");


    }

    static class prob {
        int id;
        int score;
        int time;

        public prob(String a, String b, String c) {
            this.id = Integer.parseInt(a);
            this.score = Integer.parseInt(b);
            this.time = Integer.parseInt(c);
        }
    }
}
