import java.util.*;

public class Solution
{

    static final long MOD = 1000000007L;

    static long solve(int[] can, int N, int K) {
        long[] dp = new long[K+1]; // no. of ways to share k candies so far dp[k]
        long[] pref = new long[K+1]; // prefix sum

        dp[0] = 1;  // 1 way to share 0 candies
        pref[0] = dp[0];

        for (int i = 0; i < N; i++) {
            int c = can[i];
            //pref[0] = dp[0];  // prefix sum of all dp till K candies

            for (int k = 1; k <= K; k++) {
                pref[k] = (pref[k-1] + dp[k]) % MOD;
            }

            // Re-assign dp using prefix sum calculated so far and no. of candies c that ith student can receive
            //dp[0] = pref[0];
            for (int k = 1; k <= K; k++) {
                dp[k] = pref[k];

                if (k - c > 0) {
                    dp[k] -= pref[k-c-1];
                }
            }

        }

        return dp[K] < 0 ? dp[K] + MOD : dp[K];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println(solve(a, N, K));

    }
}
