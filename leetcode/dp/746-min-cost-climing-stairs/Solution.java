import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        //int[] cost = {10, 15, 20};
        int result = minCost(cost);
        System.out.println(result);
    }

    static int minCost(int[] cost) {
        int N = cost.length;
        int[] dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= 2; j++) {
                if (i >= j && dp[i-j] != Integer.MAX_VALUE) {
                    int cst = (i == N) ? 0 : cost[i];
                    dp[i] = Math.min(dp[i], dp[i-j] + cst);
                }
            }
        }

        return Math.min(dp[N-1], dp[N-2]);

    }
}
