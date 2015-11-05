package bAsics;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by hellsapphire on 10/14/2015.
 */
public class maxset {

    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<>();
        a.add(0);
        a.add(0);
        a.add(-1);
        a.add(0);

        maxset(a);

    }

    public static ArrayList<Integer> maxset(ArrayList<Integer> a) {
        

        ArrayList<Integer> res = new ArrayList<>();

        ArrayList<Integer> temp = new ArrayList<>();
        for (int x:a){
            if (x >= 0) {
                temp.add(x);
            } else {
                if (istempMax(res,temp)){
                    res = new ArrayList<Integer>(temp);
                }
                if (res.isEmpty()){
                    res = new ArrayList<Integer>(temp);
                }
                temp.clear();
            }
        }

        if (istempMax(res,temp)){
            res = new ArrayList<Integer>(temp);
        }

        return res;
    }

    private static boolean istempMax(ArrayList<Integer> res, ArrayList<Integer> temp){
        long a = 0;
        for (int x: res){
            a +=x;
        }

        long b = 0;
        for (int x: temp){
            b +=x;
        }

        return b>a;
    }
}
