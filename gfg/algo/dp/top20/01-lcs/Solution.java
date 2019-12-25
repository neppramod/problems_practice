import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char[] X = sc.next().toCharArray();
        char[] Y = sc.next().toCharArray();
        int M = X.length;
        int N = Y.length;

        int[][] dp = new int[M+1][N+1];

        for (int i = 0; i <= M; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (X[i-1] == Y[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[M][N]);

    }


}
