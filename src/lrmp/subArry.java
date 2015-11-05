package lrmp;

/**
 * Created by hellsapphire on 10/9/2015.
 */
public class subArry {

    public static void main(String[] args) {
        int[] inp = {1, 2, 1, 3, 2, 3};
        System.out.println(maxIncSubseq(inp));
    }

    public static int maxIncSubseq(int[] A) {
        int maxLIS = 1;
        int[] LIS = new int[A.length];
        for (int i=0; i<A.length; i++){
            LIS[i] = 1;
        }

        for (int i=1; i<A.length; i++){

            for(int j=0; j<i; j++){
                if (A[i] >= A[j] && LIS[i] < LIS[j]+1){
                    LIS[i] = LIS[j]+1;
                    maxLIS = Math.max(maxLIS,LIS[i]);
                }
            }
        }

        return maxLIS;



    }
}
