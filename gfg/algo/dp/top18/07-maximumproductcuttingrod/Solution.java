import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = 5;
        System.out.println(maxProduct(N));
        System.out.println(maxProductDP(N));
    }

    static int maxProduct(int N)
    {
        if (N == 0) return 0;
        if (N == 1) return 0;

        int max = 0;
        for (int i = 1; i < N; i++) {
            int cur = Math.max(i * (N-i), i * maxProduct(N-i));
            if (cur > max) max = cur;
        }

        return max;
    }

    static int maxProductDP(int N)
    {
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;


        for (int i = 1; i <= N; i++) {
            int max = 0;
            for (int j = 1; j <= i/2; j++) {
// j is required to go below i/2 as we don't want negative and half covers the range
                int cur = Math.max(j * (i-j), j * dp[i-j]);
                if (cur > max) max = cur;
            }

            dp[i] = max;
        }

        return dp[N];
    }
}
