package bAsics;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by hellsapphire on 10/25/2015.
 * <p/>
 * 2048 game
 */
public class TwoZeroFourEight {
    private int[][] M;
    private int N;

    public TwoZeroFourEight(int N) {
        M = new int[N][N];
        this.N = N;
        randomAllocate();
    }

    public void play() {
        printState();
        Scanner in = new Scanner(System.in);

        while (true) {
            String s = in.nextLine();
            if (s.equals("l")) {
                leftShift();
                printState();
            } else if (s.equals("r")) {
                rightShift();
                printState();
            } else if (s.equals("t")) {
                topShift();
                printState();
            } else if (s.equals("b")) {
                bottomShift();
                printState();
            } else {
                break;
            }
        }

        System.exit(0);
    }

    private void randomAllocate() {
        Random rnd = new Random();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (rnd.nextInt(2) == 0) {
                    M[i][j] = (int) Math.pow(2, rnd.nextInt(10));
                }
            }
        }
    }

    private void printState() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void leftShift() {
        for (int r = 0; r < N; r++) {
            int n = N;
            int i = 0;

            while (i < n - 1) {

                if (M[r][i] == 0) {
                    i++;
                } else {
                    int j = i + 1;

                    while (true) {
                        if (j >= n) {
                            i = j;
                            break;
                        } else if (M[r][j] == 0) {
                            j++;
                        } else if (M[r][j] != M[r][i]) {
                            i = j;
                            break;
                        } else {
                            M[r][j] = 0;
                            M[r][i] = 2 * M[r][i];
                            j++;
                        }
                    }

                }
            }

            i = 0;
            while (i < n) {

                while (i < n && M[r][i] != 0) {
                    i++;
                }
                if (i >= n || M[r][i] != 0) {
                    break;
                }

                int j = i + 1;
                while (j < n && M[r][j] == 0) {
                    j++;
                }
                if (j >= n || M[r][j] == 0) {
                    break;
                }

                int temp = M[r][i];
                M[r][i] = M[r][j];
                M[r][j] = temp;

            }
        }
    }

    private void rightShift() {
        for (int r = 0; r < N; r++) {
            int n = N;
            int i = n - 1;

            while (i > 0) {

                if (M[r][i] == 0) {
                    i--;
                } else {
                    int j = i - 1;

                    while (true) {
                        if (j < 0) {
                            i = j;
                            break;
                        } else if (M[r][j] == 0) {
                            j--;
                        } else if (M[r][j] != M[r][i]) {
                            i = j;
                            break;
                        } else {
                            M[r][j] = 0;
                            M[r][i] = 2 * M[r][i];
                            j--;
                        }
                    }

                }
            }

            i = n - 1;
            while (i >= 0) {

                while (i >= 0 && M[r][i] != 0) {
                    i--;
                }
                if (i < 0 || M[r][i] != 0) {
                    break;
                }

                int j = i - 1;
                while (j >= 0 && M[r][j] == 0) {
                    j--;
                }
                if (j < 0 || M[r][j] == 0) {
                    break;
                }

                int temp = M[r][i];
                M[r][i] = M[r][j];
                M[r][j] = temp;

            }
        }
    }

    private void topShift() {
        for (int c = 0; c < N; c++) {
            int n = N;
            int i = 0;

            while (i < n - 1) {

                if (M[i][c] == 0) {
                    i++;
                } else {
                    int j = i + 1;

                    while (true) {
                        if (j >= n) {
                            i = j;
                            break;
                        } else if (M[j][c] == 0) {
                            j++;
                        } else if (M[j][c] != M[i][c]) {
                            i = j;
                            break;
                        } else {
                            M[j][c] = 0;
                            M[i][c] = 2 * M[i][c];
                            j++;
                        }
                    }

                }
            }

            i = 0;
            while (i < n) {

                while (i < n && M[i][c] != 0) {
                    i++;
                }
                if (i >= n || M[i][c] != 0) {
                    break;
                }

                int j = i + 1;
                while (j < n && M[j][c] == 0) {
                    j++;
                }
                if (j >= n || M[j][c] == 0) {
                    break;
                }

                int temp = M[i][c];
                M[i][c] = M[j][c];
                M[j][c] = temp;

            }
        }
    }

    private void bottomShift() {
        for (int c = 0; c < N; c++) {
            int n = N;
            int i = n - 1;

            while (i > 0) {

                if (M[i][c] == 0) {
                    i--;
                } else {
                    int j = i - 1;

                    while (true) {
                        if (j < 0) {
                            i = j;
                            break;
                        } else if (M[j][c] == 0) {
                            j--;
                        } else if (M[j][c] != M[i][c]) {
                            i = j;
                            break;
                        } else {
                            M[j][c] = 0;
                            M[i][c] = 2 * M[i][c];
                            j--;
                        }
                    }

                }
            }

            i = n - 1;
            while (i >= 0) {

                while (i >= 0 && M[i][c] != 0) {
                    i--;
                }
                if (i < 0 || M[i][c] != 0) {
                    break;
                }

                int j = i - 1;
                while (j >= 0 && M[j][c] == 0) {
                    j--;
                }
                if (j < 0 || M[j][c] == 0) {
                    break;
                }

                int temp = M[i][c];
                M[i][c] = M[j][c];
                M[j][c] = temp;

            }
        }
    }

    public static void main(String[] args) {
        TwoZeroFourEight game = new TwoZeroFourEight(5);
        game.play();
    }
}
