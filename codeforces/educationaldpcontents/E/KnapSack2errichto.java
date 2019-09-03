import java.util.*;

public class KnapSack2errichto
{
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

        int total_value = 0;
        for (int i = 0; i < N; i++) {
            total_value += val[i];
        }

        long[] dp = new long[total_value + 1];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;

        // dp[i] - the minimum total weight of items with total value exactly i
        for (int item = 0; item < N; item++) {
            for (int value_already = total_value-val[item]; value_already >= 0; value_already--) {
                dp[value_already + val[item]] = Math.min(dp[value_already + val[item]], dp[value_already] + wt[item]);
            }
        }

        long answer = 0;
        for (int i = 0; i <= total_value; i++) {
            if (dp[i] <= W) {
                answer = Math.max(answer, (long)i);
            }
        }

        System.out.println(answer);

    }
}
