import java.util.Arrays;

public class Solution {
	public static void main(final String[] args) {
		final Solution sol = new Solution();
		final int k = 2;
		final int[] prices = { 3, 2, 6, 5, 0, 3 };
		final int result = sol.maxProfit(k, prices);
		System.out.println(result);
	}

	public int maxProfit(final int k, final int[] prices) {
		if (prices == null || k <= 0 || prices.length < 2) {
			return 0;
		}

		final int len = prices.length;

		if (k >= prices.length) {
			int maxProfit = 0;
			for (int i = 1; i < len; i++) {
				if (prices[i] > prices[i - 1]) {
					maxProfit += prices[i] - prices[i - 1];
				}
			}

			return maxProfit;
		}

		
		final int[] buy = new int[k + 1];
		final int[] sell = new int[k + 1];

		Arrays.fill(buy, Integer.MIN_VALUE);
		for (final int price : prices) {
			for (int i = 1; i <= k; i++) {
				buy[i] = Math.max(buy[i], sell[i - 1] - price);
				sell[i] = Math.max(sell[i], buy[i] + price);
			}
		}

		return sell[k];
	}
}
