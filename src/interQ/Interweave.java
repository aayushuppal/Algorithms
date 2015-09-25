package interQ;

/**
 * Created by hellsapphire on 9/22/2015.
 */
public class Interweave {

    public static void main(String[] args){
        int a = 45679;
        int b = 2435;

        System.out.println(genInterweavednumber(a,b));
    }

    public static int genInterweavednumber(int a, int b){
        String A = Integer.toString(a);
        String B = Integer.toString(b);
        int len = A.length() < B.length() ? A.length() : B.length();
        StringBuffer res = new StringBuffer();
        for (int i=0; i<len; i++){
            res.append(A.charAt(i));
            res.append(B.charAt(i));
        }
        if (A.length() < B.length()){
            res.append(B.substring(len, B.length()));
        } else if (B.length() < A.length()){
            res.append(A.substring(len, A.length()));
        }
        return Integer.parseInt(res.toString());
    }
}
