package LeetCode;

import java.util.*;

/**
 * Created by hellsapphire on 10/23/2015.
 */
public class checkerperm {

    public static void main(String args[]) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] arr = s.split(" ");
        int m = Integer.parseInt(arr[0]);
        int n = Integer.parseInt(arr[1]);
        in.close();
        System.out.println(getPermutation(n, m));
    }

    public static String getPermutation(int n, int k) {

        ArrayList<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numberList.add(i);
        }


        long mod = factorial(n);

        String res = "";

        for (int i = 0; i < n; i++) {
            mod = mod / (n - i);
            int curIndex = k / (int) mod;
            k = k % (int) mod;

            res += numberList.get(curIndex);
            numberList.remove(curIndex);
        }

        String a = res.toString();
        StringBuilder sD = new StringBuilder();
        for (int p = 0; p < a.length(); p++) {
            sD.append(a.charAt(p) + " ");
        }
        a = sD.toString();
        return a.substring(0, a.length() - 1);
    }

    private static long factorial(long n) {
        long res = 1;
        for (long i = 1; i <= n; i++) {
            res = res * i;
        }
        return res;
    }

}
