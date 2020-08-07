import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] coins = {1, 2, 5};
        int amount = 11;

        int result = minCoins(coins, amount);
        System.out.println(result);
    }

    static int minCoins(int[] coins, int V) {
        int[] dp = new int[V+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int N = coins.length;
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = coins[i]; j <= V; j++) {
                if (dp[j-coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1);
                }

            }
        }

        return (dp[V] == Integer.MAX_VALUE) ? -1 : dp[V];

    }
}
