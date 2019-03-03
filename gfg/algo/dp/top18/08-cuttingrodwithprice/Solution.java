import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRod(arr, arr.length));
        System.out.println(cutRodDP(arr, arr.length));
    }

    static int cutRod(int[] prices, int N)
    {
        if (N == 0) return 0;

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, cutRod(prices, N-i-1) + prices[i]);
        }

        return max;
    }

    static int cutRodDP(int[] prices, int N)
    {
        int[] dp = new int[N+1];
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                max = Math.max(max, dp[i-j-1] + prices[j]);
            }
            dp[i] = max;
        }

        return dp[N];
    }
}
