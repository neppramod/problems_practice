import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] dp = new int[n+1];
        //boolean[][] visited = new boolean[n+1][n+1];
        int numberOfWays = numberOfWays(m, n, dp);
        System.out.println(numberOfWays);
    }

    static int numberOfWays(int m, int n, int[] dp) {
        dp[0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = m; j <= n; j++) {
                if (j >= i) {
                    dp[j] = dp[j-i] + dp[j];
                }
            }
        }

        return dp[n];
    }
}
