import java.util.*;

public class Solution
{
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] days = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31 };
		int[] costs = { 2, 7, 15 };

		int result = sol.mincostTickets(days, costs);
		System.out.println(result);
	}

	public int mincostTickets(int[] days, int[] costs) {
		if (days == null || costs == null) {
			return 0;
		}



		Arrays.sort(days);
		int n = days[days.length - 1];

		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);

		dp[0] = 0;

		HashSet<Integer> daysSet = new HashSet<>();
		for (int d : days) {
			daysSet.add(d);
		}

		for (int i = 1; i <= n; i++) {
			if (daysSet.contains(i)) {

				// 1-day pass
				dp[i] = Math.min(dp[i], dp[i - 1] + costs[0]);

				// 7-day pass
				if (i <= 7) {
					dp[i] = Math.min(dp[i], costs[1]);
				} else {
					dp[i] = Math.min(dp[i], dp[i - 7] + costs[1]);
				}

				// 30 day pass
				if (i < 30) {
					dp[i] = Math.min(dp[i], costs[2]);
				} else {
					dp[i] = Math.min(dp[i], dp[i - 30] + costs[2]);
				}
			} else {
				dp[i] = Math.min(dp[i], dp[i - 1]);
			}
		}

		return dp[n];
	}
}
