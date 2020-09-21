import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[][] trips = { { 2, 1, 5 }, { 3, 3, 7 } };
		int capacity = 4;
		boolean result = sol.carPooling(trips, capacity);
		System.out.println(result);
    }
    
    public boolean carPooling(int[][] trips, int capacity) {
		if (trips == null || trips.length == 0 || trips[0].length == 0 || capacity == 0) {
			return false;
		}

		Arrays.sort(trips, new Comparator<int[]>(){
			public int compare(int[] a, int[] b) {
				if (a[1] != b[1]) {
					return a[1] - b[1];
				} else {
					return a[2] - b[2];
				}
			}
		});


		int[] dp = new int[1001];
		for (int[] trip : trips) {
			for (int i = trip[1]; i < trip[2]; i++) {
				dp[i] += trip[0];
			}
		}

		for (int i = 0; i <= 1000; i++) {
			if (dp[i] > capacity) {
				return false;
			}
		}

		return true;
    }
}
