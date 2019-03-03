import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int coins[] = {9, 6, 5, 1};
        int m = coins.length;
        int V = 11;
        System.out.println (minCoins(coins, m, V));
        System.out.println (minCoinsDP(coins, m, V));
    }

    static int minCoins(int[] coins, int m, int V)
    {
        if (V <= 0) return 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            int cur = minCoins(coins, m, V-coins[i]);
            if (cur+1 < min) min = cur+1;
        }

        return min;
    }

    static int minCoinsDP(int[] coins, int m, int V)
    {
        int dp[] = new int[V+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= V; i++) {

            for (int j = 0; j < m; j++) {
                if (i >= coins[j]) {
                    int cur = dp[i-coins[j]];
                    dp[i] = Math.min(cur + 1, dp[i]);
                }
            }

        }

        return dp[V];
    }
}
