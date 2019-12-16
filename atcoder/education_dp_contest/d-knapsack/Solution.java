import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int W = sc.nextInt();
        int[] wt = new int[N];
        long[] val = new long[N];
        long[] dp = new long[W+1];

        for (int i = 0; i < N; i++) {
            wt[i] = sc.nextInt();
            val[i] = sc.nextLong();
        }

        long result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = W; j >= wt[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-wt[i]] + val[i]);

                result = Math.max(result, dp[j]);
            }
        }

        System.out.println(result);
    }
}
