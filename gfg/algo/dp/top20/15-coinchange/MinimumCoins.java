import java.util.*;

public class MinimumCoins
{
    static final int INF = 10000000;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int V = sc.nextInt();
        int[] arr = new int[m];

        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(minCoins(arr, m, V));
        System.out.println(minCoins2(arr, m, V));

    }

    static int minCoins(int[] arr, int m, int V) {
        int[] dp = new int[V+1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < m; i++) {
            for (int j = arr[i]; j <= V; j++) {
                dp[j] = Math.min(dp[j], dp[j-arr[i]] + 1);
            }
        }

        return dp[V];
    }

    static int minCoins2(int[] arr, int m, int V) {
        int[] dp = new int[V+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < m; i++) {
            for (int j = arr[i]; j <= V; j++) {
                int sub_res = dp[j-arr[i]];
                if (sub_res != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j-arr[i]] + 1);
                }

            }
        }

        return dp[V];
    }
}
