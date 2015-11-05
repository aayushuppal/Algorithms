package bAsics;

/**
 * Created by hellsapphire on 10/21/2015.
 * String combinations
 */
public class StringComb {

    public static void main(String[] args) {
        String s = "abcd";
        int[] M = new int[s.length()];
        combs(M,0,s.length()-1,s);
    }

    private static void combs(int[] M, int k, int n, String s){
        if (k==n){
            M[k] = 0;
            printer(M,s);
            M[k] = 1;
            printer(M,s);
            return;
        }
        M[k] = 0;
        combs(M,k+1,n,s);
        M[k] = 1;
        combs(M,k+1,n,s);
    }

    private static void printer(int[] M, String s){
        StringBuilder sB = new StringBuilder();
        for(int i=0; i<M.length; i++){
            if (M[i]==1){
                sB.append(s.charAt(i));
            }
        }
        System.out.println(sB.toString());
    }
}
