package interQ2;

import java.io.*;
import java.util.*;

public class LexicalBigger {

    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        try{
            PrintWriter out = new PrintWriter("zingat.txt");
            int num = in.nextInt();
            in.nextLine();
            for (int i=0; i<num; i++){
                String a = in.nextLine();
                out.println(a);
                out.println(lexicalNext(a));
            }
            out.close();
        } catch(FileNotFoundException e){

        }

        in.close();
    }

    public static String lexicalNext(String str){
        String res = "no answer";
        char[] cArr = str.toCharArray();

        for (int i=str.length()-2; i>=0; i--){
            int replacerIndex = lookupSmallestAhead(cArr, i);
            if (replacerIndex > -1){
                swapper(cArr, i, replacerIndex);
                String a = new String(cArr, 0, i+1);
                String b = new String(cArr, i+1, cArr.length-(i+1));
                char[] temp = b.toCharArray();
                Arrays.sort(temp);
                b = new String(temp);
                return a+b;
            }

        }
        return res;
    }

    public static int lookupSmallestAhead(char[] cArr, int i){
        char minChar = 'z';
        char baseChar = cArr[i];
        int res = -1;
        for (int j=i+1; j<cArr.length; j++){
            char temp = cArr[j];
            if (temp > baseChar && temp <= minChar){
                res = j;
                minChar = temp;
            }
        }
        return res;
    }

    public static void swapper(char[] A, int a, int b){
        char temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }

}