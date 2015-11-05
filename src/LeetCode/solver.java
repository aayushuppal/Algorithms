package LeetCode;

import java.util.*;
/**
 * Created by hellsapphire on 10/23/2015.
 */
public class solver {

    public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        /*Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] arr = s.split(" ");
        int m = Integer.parseInt(arr[0]);
        int n = Integer.parseInt(arr[1]);
        in.close();*/
        System.out.println(getPermutation(3,2));
    }

    public static String getPermutation(int n, int k) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        k = (int)((long)(k-1)%factorial(n) + 1);
        StringBuilder ret = new StringBuilder();
        LinkedList<Integer> available = new LinkedList<Integer>();
        for (int i=0; i<n; i++) {available.add(i);}
        dfs(n, k+1, available, ret);
        return new String(ret);
    }

    public static long factorial(long x) {
        if (x==0) return 1;
        if (x==1) return 1;
        return x*factorial(x-1);
    }

    public static void dfs(long n, long k, LinkedList<Integer> available,
                    StringBuilder ret) {
        if (available.size()==0) {return;}
        long elementsPerBucket = factorial(available.size() - 1);
        long bucket = (k-1)/elementsPerBucket + 1;
        long cur = available.remove((int) bucket - 1);
        ret.append((char) (cur + '0'));
        dfs(n, k - (bucket - 1) * elementsPerBucket, available, ret);
    }
}
