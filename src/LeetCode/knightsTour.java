package LeetCode;

/**
 * Created by hellsapphire on 10/22/2015.
 * Knights Tour problem
 * Backtracking
 * Qumulo
 */
public class knightsTour {
    private static final int N = 8;
    private int soln[][];

    public knightsTour() {
        soln = new int[N][N];
    }

    private boolean isSafe(int x, int y) {
        if (x >= 0 && x < N && y >= 0 && y < N && soln[x][y] == -1)
            return true;
        return false;
    }

    private void printSolution() {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                System.out.print("  " + soln[x][y]);
            }
            System.out.println();
        }
    }

    private boolean solveKTUtil(int x, int y, int nextMoveCount) {

        if (nextMoveCount == N * N)
            return true;


        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

        for (int k = 0; k < N; k++) {
            int[] nextMove = {x + xMove[k], y + yMove[k]};
            if (isSafe(nextMove[0], nextMove[1])) {
                soln[nextMove[0]][nextMove[1]] = nextMoveCount;
                if (solveKTUtil(nextMove[0], nextMove[1], nextMoveCount + 1))
                    return true;
                else
                    soln[nextMove[0]][nextMove[1]] = -1;
            }
        }
        return false;
    }

    public boolean solveKnightTour() {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                soln[x][y] = -1;
            }
        }
        soln[0][0] = 0;

        if (!solveKTUtil(0, 0, 1)) {
            System.out.println("the solution does not exist");
            return false;
        } else {
            printSolution();
        }
        return true;
    }

    public static void main(String[] arg) {
        knightsTour knightTour = new knightsTour();
        System.out.println("the solution :");
        knightTour.solveKnightTour();
    }
}