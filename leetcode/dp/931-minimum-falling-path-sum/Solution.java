import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int result = minFallingPathSum(matrix);
        System.out.println(result);
    }

    static public int minFallingPathSum(int[][] A) {
        int M = A.length;
        int N = A[0].length;
        int[][] dp = new int[M][N];

        // fill first row with matrix values
        for (int i = 0; i < N; i++) {
            dp[0][i] = A[0][i];
        }

        for (int i = 1; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int a1 = (j > 0) ? dp[i-1][j-1] : Integer.MAX_VALUE;
                int b1 = (j < N-1) ? dp[i-1][j+1] : Integer.MAX_VALUE;



                int minPrev = Math.min(a1, b1);
                dp[i][j] = Math.min(minPrev, dp[i-1][j]) + A[i][j];
                // System.out.printf("(%d, %d) : %d %d: %d\n", i, j, a1, b1, dp[i][j]);
            }
        }

        // for (int i = 0; i < M; i++) {
        //  System.out.println(Arrays.toString(dp[i]));
        // }

        int result = Integer.MAX_VALUE;
        for (int j = 0; j < N; j++) {
            result = Math.min(result, dp[M-1][j]);
        }

        return result;
    }
}
