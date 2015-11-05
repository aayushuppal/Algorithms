package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by hellsapphire on 10/22/2015.
 * LeetCode – Permutation Sequence kth
 * <p/>
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * <p/>
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * <p/>
 * Given n and k, return the kth permutation sequence.
 */
public class StringPerms {

    public static void main(String[] args) {
        System.out.println(getPermutationDP(19, 3));
    }

    public static String getPermutation(int n, int k) {
        StringBuilder sB = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sB.append(i);
        }
        String str = sB.toString();
        String pre = "";
        Set<String> hSet = new HashSet<>();
        genPerms(pre, str, 0, str.length() - 1, hSet);
        String[] sArr = hSet.toArray(new String[hSet.size()]);
        Arrays.sort(sArr);
        return sArr[k];


    }


    /**
     * function to generate permutations only
     */
    public static void genPerms(String pre, String str, int k, int len, Set<String> hSet) {
        if (k == len) {
            hSet.add(pre + str);
        }

        for (int i = 0; i < str.length(); i++) {
            String x = pre + str.charAt(i);
            String y = str.substring(0, i) + str.substring(i + 1);
            genPerms(x, y, k + 1, len, hSet);
        }
    }

    public static String getPermutationDP(int n, int k) {

        ArrayList<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numberList.add(i);
        }


        int mod = factorial(n);

        String res = "";

        for (int i = 0; i < n; i++) {
            mod = mod / (n - i);
            int curIndex = k / mod;
            k = k % mod;

            res += numberList.get(curIndex);
            numberList.remove(curIndex);
        }

        String a =  res.toString();
        StringBuilder sD = new StringBuilder();
        for (int p=0; p<a.length();p++){
            sD.append(a.charAt(p)+" ");
        }
        a =  sD.toString();
        return a.substring(0,a.length()-1);
    }

    private static int factorial(int n){
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res = res * i;
        }
        return res;
    }
}


