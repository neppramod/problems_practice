import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[] arr = {1, 4, 5, 7, 6, 3, 2, 9};
		int result = sol.maxProfit(arr);
		System.out.println(result);
    }

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}

		int n = prices.length;
		int[] left = new int[n];
		int[] right = new int[n];

		// left
		left[0] = 0;
		
		int min = prices[0];
		for (int i = 1; i < n; i++) {
			min = Math.min(min, prices[i]);
			left[i] = Math.max(left[i - 1], prices[i] - min);
		}

		// right
		right[n - 1] = 0;
		int max = prices[n - 1];
		for (int i = prices.length - 2; i >= 0; i--) {
			max = Math.max(prices[i], max);
			right[i] = Math.max(right[i + 1], max - prices[i]);
		}

		int profit = 0;

		for (int i = 0; i < n; i++) {
			profit = Math.max(profit, left[i] + right[i]);
		}

		return profit;
	}
    
}
