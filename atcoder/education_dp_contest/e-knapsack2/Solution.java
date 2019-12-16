import java.util.*;

public class Solution
{

    static long INF = 10000000000000L;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long W = sc.nextLong();
        long[] wt = new long[N];
        int[] val = new int[N];

        for (int i = 0; i < N; i++) {
            wt[i] = sc.nextLong();
            val[i] = sc.nextInt();
        }

        int maxv = 0;
        for (int i = 0; i < N; i++) {
            maxv += val[i];
        }
        long[] dp = new long[maxv+1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        long result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = maxv; j >= val[i]; j--) {
                dp[j] = Math.min(dp[j], dp[j-val[i]] + wt[i]);

                if (dp[j] <= W) {
                    result = Math.max(result, j);
                }
            }
        }

        System.out.println(result);
    }
}
