import java.util.*;

public class KnapSack1
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int W = sc.nextInt();
        int[] wt = new int[N];
        long[] val = new long[N];

        for (int i = 0; i < N; i++) {
            wt[i] = sc.nextInt();
            val[i] = sc.nextLong();
        }

        System.out.println(knapsack(wt, val, W, N));
    }

    private static long knapsack(int[] wt, long[] val, int W, int N)
    {
        long[][] dp = new long[N+1][W+1];

        for (int n = 0; n <= N; n++) {
            for (int w = 0; w <= W; w++) {
                // no weight or capacity, 0
                if (n == 0 || w == 0) {
                    dp[n][w] = 0;
                } else if (wt[n-1] > w) {
                    dp[n][w] = dp[n-1][w];
                } else {
                    dp[n][w] = Math.max(dp[n-1][w], val[n-1] + dp[n-1][w-wt[n-1]]);
                }
            }
        }

        return dp[N][W];
    }
}
