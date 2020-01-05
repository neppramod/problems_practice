import java.util.*;


// Use 1-D version
// dp[j] = Max(dp[j], dp[j-Wi] + Vi), i = 0 to n-1, Wi <= j

/*
  6 15
  6 5
  5 6
  6 4
  6 6
  3 5
  7 2

  0-1: 17
  unbounded: 25
 */

public class Solution
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

        System.out.println("0-1: " +knapsack01(wt, val, W));
        System.out.println("unbounded: " +knapsackunbounded(wt, val, W));
        System.out.println("0-1 (2D): " +knapsack012d(wt, val, W));

    }

    static long knapsack01(int[] wt, long[] val, int W) {
        int N = wt.length;

        long[] dp = new long[W+1];


        for (int i = 0; i < N; i++) {
            //for (int j = wt[i]; j <= W; j++) {    // unbounded
            for (int j = W; j>= wt[i]; j--){        // bounded (or use 2-D version)
                dp[j] = Math.max(dp[j], dp[j-wt[i]] + val[i]);
            }
        }

        return dp[W];
    }

    static long knapsackunbounded(int[] wt, long[] val, int W) {
        int N = wt.length;

        long[] dp = new long[W+1];


        for (int i = 0; i < N; i++) {
            for (int j = wt[i]; j <= W; j++) {    // unbounded
            //for (int j = W; j>= wt[i]; j--){        // bounded (or use 2-D version)
                dp[j] = Math.max(dp[j], dp[j-wt[i]] + val[i]);
            }
        }

        return dp[W];
    }

    // M(i,j) = Max(M(i-1, j), M(i-1, j-Wi) + Vi)
    // ith item not used, and ith item used
    static long knapsack012d(int[] wt, long[] val, int W) {
        int N = wt.length;

        long[][] dp = new long[N+1][W+1];

        for (int i = 0; i  <= N; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (j >= wt[i-1]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-wt[i-1]] + val[i-1]);  // ith item used
                } else {
                    dp[i][j] = dp[i-1][j];  // ith item not used to create sum j
                }
            }
        }

        return dp[N][W];
    }

}
