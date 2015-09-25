package interQ;

/**
 * Created by hellsapphire on 9/22/2015.
 */
public class LongestOnes {

    public static void main(String[] args){
        String inp = "111001111";
        int[] res = getOnePos(inp);
        System.out.println(res[0]+" "+res[1]);

    }

    public static int[] getOnePos(String inp){
        int[] res = new int[2];
        int count = 0;
        for(int i=0; i<inp.length(); i++){
            if (inp.charAt(i) == '1'){
                int a = i;
                while(i+1<inp.length() && inp.charAt(i+1) == '1'){
                    i =i+1;
                }
                int b = i;
                if (b-a+1 > count){
                    res[0] = a;
                    res[1] = b;
                    count = b-a+1;
                }
            }
        }
        return res;
    }
}
