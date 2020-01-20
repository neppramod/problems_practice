import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.println(findWays(4, 2, 1));
        System.out.println(findWays(2, 2, 3));
        System.out.println(findWays(6, 3, 8));
        System.out.println(findWays(4, 2, 5));
        System.out.println(findWays(4, 3, 5));

        System.out.println(findWays(6, 2, 10));

    }

    public static long findWays(int m, int n, int x) {

        long dp[][] = new long[n + 1][x + 1];
        // Table entries for no dices
        // If you do not have any data, then the value must be 0, so the result is 1
        dp[0][0] = 1;

        // Iterate over dices
        for(int i=1; i<=n; i++) {
            // Iterate over sum
            for(int j=i; j<=x; j++) {
                // The result is obtained in two ways, pin the current dice and spending 1 of the value,
                // so we have dp[i-1][j-1] remaining combinations, to find the remaining combinations we
                // would have to pin the values ??above 1 then we use dp[i][j-1] to sum all combinations
                // that pin the remaining j-1's. But there is a way, when "j-f-1> = 0" we would be adding
                // extra combinations, so we remove the combinations that only pin the extrapolated dice face and
                // subtract the extrapolated combinations.
                dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                if(j-m > 0)
                    dp[i][j] -= dp[i-1][j-m-1];
            }
        }
        return dp[n][x];
    }
}
