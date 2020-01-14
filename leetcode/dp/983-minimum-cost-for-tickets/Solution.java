import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {7, 2, 15};
        int result = minCostTickets(days, costs);
        System.out.println(result);
    }

    static int minCostTickets(int[] days, int[] costs) {
        int N = days.length;
        int[] dp = new int[days[N-1] + 1];
        int M = dp.length;

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        boolean[] daysAccounted = new boolean[M];
        for (int i = 0; i < N; i++) {
            daysAccounted[days[i]] = true;
        }


        for (int i = 1; i < M; i++) {
            if (!daysAccounted[i]) {
                dp[i] = dp[i-1];
            } else {
                int min = dp[i];
                min = Math.min(dp[i-1] + costs[0], min);
                min = Math.min(dp[Math.max(i-7, 0)] + costs[1], min);
                min = Math.min(dp[Math.max(i-30, 0)] + costs[2], min);
                dp[i] = min;
            }
        }

        return dp[M-1];
    }

}
