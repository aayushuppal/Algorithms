package hack_go_daddy;

import java.util.*;

/**
 * Created by hellsapphire on 10/4/2015.
 */
public class HexagoUF {
    static int N;
    static Map<String, String> rNodeToRootMap = new HashMap<>();
    static Map<String, String> pNodeToRootMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();

        int steps = in.nextInt();

        for (int i = 0; i < steps; i++) {
            in.nextLine();
            int a = in.nextInt();
            int b = in.nextInt();
            String temp = "" + a + "-" + b;
            List<String> res = validNeighbors(a, b, N);

            if (i % 2 == 0) {
                for (String key : res) {
                    if (rNodeToRootMap.containsKey(key)) {
                        rNodeToRootMap.put(key, temp);
                    }
                }
                rNodeToRootMap.put(temp, temp);
            } else {
                for (String key : res) {
                    if (pNodeToRootMap.containsKey(key)) {
                        pNodeToRootMap.put(key, temp);
                    }
                }
                pNodeToRootMap.put(temp, temp);
            }

        }

    }


    public static List<String> validNeighbors(int R, int C, int N) {
        int i = R;
        int j = C;
        List<String> res = new ArrayList<String>();
        for (int a = -1; a <= 1; a++) {
            for (int b = -1; b <= 1; b++) {
                if (a != b) {
                    int A = i + a;
                    int B = j + b;
                    if (A > 0 && A <= N && B > 0 && B <= N) {
                        res.add("" + A + "-" + B);
                    }
                }
            }
        }
        return res;

    }


}
