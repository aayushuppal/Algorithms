package Msft3c;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by hellsapphire on 10/6/2015.
 */
public class Solution {
    static ArrayList<HashMap<Integer, Integer>> M1 = new ArrayList<HashMap<Integer, Integer>>();
    static ArrayList<HashMap<Integer, Integer>> M2 = new ArrayList<HashMap<Integer, Integer>>();

    public static void main(String[] args) {

        int rofM1 = 1;
        int rofM2 = 4;

        Scanner in = new Scanner(System.in);


        for (int y = 0; y < rofM1; y++) {

            String inp = in.nextLine();
            String[] arr = inp.split(" ");

            int i = 0;

            HashMap<Integer, Integer> vector1 = new HashMap<>();

            for (String s : arr) {
                try {
                    int a = Integer.parseInt(s);
                    vector1.put(i, a);
                    i++;
                } catch (NumberFormatException e) {
                    continue;
                }
            }
            M1.add(vector1);
        }




        for (int y = 0; y < rofM2; y++) {

            String inp = in.nextLine();
            String[] arr = inp.split(" ");

            int i = 0;

            HashMap<Integer, Integer> vector1 = new HashMap<>();

            for (String s : arr) {
                try {
                    int a = Integer.parseInt(s);
                    vector1.put(i, a);
                    i++;
                } catch (NumberFormatException e) {
                    continue;
                }
            }
            M2.add(vector1);
        }



        for (int i=0; i<M1.size(); i++){
            System.out.print("|  ");
            for (int j = 0; j< M2.get(0).size(); j++){
                System.out.print(retNum(i,j)+" ");
            }
            System.out.println(" |");
        }

        /*retNum(0,0);
        retNum(1,0);
        retNum(0,1);
        retNum(1,1);*/


    }

    public static int retNum(int r, int c) {
        HashMap<Integer, Integer> rowof1 = M1.get(r);

        int temp = 0;
        for (int j = 0; j < rowof1.size(); j++) {
            temp += (M1.get(r).get(j) * M2.get(j).get(c));
        }

        return  temp;
    }

}
