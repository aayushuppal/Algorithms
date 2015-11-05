package LeetCode;

/**
 * Created by hellsapphire on 10/23/2015.
 */
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] temp = s.split(" ");
        int M = Integer.parseInt(temp[0]);
        int N = Integer.parseInt(temp[1]);

        s = in.nextLine();
        temp = s.split(" ");
        int sM = Integer.parseInt(temp[0]);
        int sN = Integer.parseInt(temp[1]);

        s = in.nextLine();
        temp = s.split(" ");
        int eM = Integer.parseInt(temp[0]);
        int eN = Integer.parseInt(temp[1]);

        int r = Integer.parseInt(in.nextLine());
        List<Integer[]> blocked = new ArrayList<Integer[]>();
        for (int i=0; i<r; i++){
            String t = in.nextLine();
            String[] p = t.split(" ");
            int a = Integer.parseInt(p[0]);
            int b = Integer.parseInt(p[1]);
            Integer[] tArr = {a,b};
            blocked.add(tArr);
        }
        in.close();

        knightGoal kG = new knightGoal(M,N,sM,sN,eM,eN,blocked);
        System.out.println(kG.getKnightToGoal());

    }
}

class knightGoal {
    private static int M;
    private static int N;

    private static int sM;
    private static int sN;

    private static int eM;
    private static int eN;

    private int[][] C;

    knightGoal(int a, int b, int c, int d, int e, int f, List<Integer[]> blocked) {
        M = a;
        N = b;
        sM = c;
        sN = d;
        eM = e;
        eN = f;

        C = new int[M][N];
        for (int m=0; m<M; m++){
            for (int n=0; n<N; n++){
                C[m][n] = -1;
            }
        }

        for (Integer[] x : blocked) {
            C[x[0]][x[1]] = 0;
        }
    }

    public int getKnightToGoal() {
        C[sM][sN] = 0;

        if (solveKnightUtil(sM,sN,1)){
            return C[eM][eN];
        }
        return Integer.MAX_VALUE;
    }

    private boolean solveKnightUtil(int currX,int currY,int nextMvCount) {
        if (currX == eM && currY == eN){
            return true;
        }

        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

        for (int k = 0; k < 8; k++) {
            int[] nextMove = {currX + xMove[k], currY + yMove[k]};

            if (isSafe(nextMove[0], nextMove[1])) {
                C[nextMove[0]][nextMove[1]] = nextMvCount;
                if (solveKnightUtil(nextMove[0], nextMove[1], nextMvCount + 1))
                    return true;
                else
                    C[nextMove[0]][nextMove[1]] = -1;
            }
        }
        return false;
    }

    private boolean isSafe(int x, int y) {
        if (x >= 0 && x < M && y >= 0 && y < N && C[x][y] == -1)
            return true;
        return false;
    }


}