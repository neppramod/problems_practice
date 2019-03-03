import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W=50;
        int n = val.length;
        System.out.println(knapSackDP(W, wt, val, n));
        System.out.println(knapSack(W, wt, val, n));
    }

    static int knapSackDP(int W, int[] wt, int[] val, int n)
    {
        int[][] dp = new int[n+1][W+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }

                else if (j >= wt[i-1]) { // current weight until previous item, or current item
                    dp[i][j] = Math.max(dp[i-1][j], val[i-1] + dp[i-1][j-wt[i-1]]);
                }

                else // don't include current
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[n][W];
    }

    static int knapSack(int W, int[] wt, int[] val, int n)
    {
        if (n == 0 || W == 0) return 0;

        if (wt[n-1] > W) return knapSack(W, wt, val, n-1);
        else{
            return Math.max(val[n-1] + knapSack(W-wt[n-1], wt, val, n-1), knapSack(W, wt, val, n-1));
        }
    }
}
