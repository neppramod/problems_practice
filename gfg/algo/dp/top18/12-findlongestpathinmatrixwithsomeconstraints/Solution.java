import java.util.*;

public class Solution
{
    static int x[] = {0, -1, 0, 0, 1};
    static int y[] = {0,0,-1, 1, 0};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int mat[][] = { {1, 2, 9}, {5, 3, 8},
                        {4, 6, 7} };

        int N = mat.length;
        int dp[][] = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }


        int max = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // max = Math.max(max, maxPath(mat, i, j));
                max = Math.max(max, maxPathDP(mat, i, j, dp));
            }
        }
        System.out.println(max);


    }

    static int maxPath(int[][] mat, int i, int j)
    {

        if (!isValid(mat, i, j)) return 0;

        for (int k = 0; k < 5; k++) {
            int nx = i + x[k], ny = j + y[k];
            if (isValid(mat,nx,ny) && mat[nx][ny] == mat[i][j] + 1) return 1 + maxPath(mat, nx, ny);
        }

        return 1; // if no more can be found after finding current
    }

    static int maxPathDP(int[][] mat, int i, int j, int[][] dp)
    {

        if (!isValid(mat, i, j)) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        for (int k = 0; k < 5; k++) {
            int nx = i + x[k], ny = j + y[k];
            if (isValid(mat, nx, ny) && mat[nx][ny] == mat[i][j] + 1) { return dp[i][j] = 1 + maxPathDP(mat, nx, ny, dp); }
        }

        return dp[i][j] = 1;
    }

    static boolean isValid(int[][] mat, int i, int j)
    {
        int N = mat.length;

        if (i < 0 || j < 0 || i >= N || j >= N) return false;
        else return true;
    }
}
