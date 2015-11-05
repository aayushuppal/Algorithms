package zenefi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by hellsapphire on 10/4/2015.
 */
public class GuardRooms {

    public static void main(String[] args) {
        int[][] RM = {{1, 2, 1}, {1, 0, 1}, {1, 2, 1}};
        int[] IJ = {0, 0};
        bfsToGuard(IJ, RM);
    }


    public static int bfsToGuard(int[] IJ, int[][] RM) {
        HashSet<String> visited = new HashSet<>();

        if (RM[IJ[0]][IJ[1]] == 2) {
            return 0;
        }



        List<Integer[]> adj = getAdj(IJ, RM);
        return 0;
    }

    public static List<Integer[]> getAdj(int[] IJ, int[][] RM) {
        int i = IJ[0];
        int j = IJ[1];
        List<Integer[]> res = new ArrayList<>();

        for (int c = -1; c <= 1; c++) {
            if (c != 0 && j + c >= 0 && j + c <= RM[0].length - 1 && RM[i][j + c] > 0) {
                Integer[] temp = {i, j + c};
                res.add(temp);
            }
        }

        for (int c = -1; c <= 1; c++) {
            if (c != 0 && i + c >= 0 && i + c <= RM.length - 1 && RM[i + c][j] > 0) {
                Integer[] temp = {i + c, j};
                res.add(temp);
            }
        }

        return res;
    }
}
