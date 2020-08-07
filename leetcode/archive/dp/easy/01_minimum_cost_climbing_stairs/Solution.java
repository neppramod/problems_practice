import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] cost = new int[N];

        for (int i = 0; i < N; i++) {
            cost[i] = sc.nextInt();
        }

        System.out.println(minCost(cost, N));

    }

    static int minCost(int[] cost, int N) {
        int[] dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = cost[0];
        dp[1] = cost[1];
        int K = 2;

        for (int i = 2; i <= N; i++) {
            for (int k = 1; k <= K; k++) {
                if (i >= k && dp[i-k] < Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i-k] + cost[i-k]);
                }
            }
        }

        return Math.min(dp[N-1], dp[N]);
    }
}
