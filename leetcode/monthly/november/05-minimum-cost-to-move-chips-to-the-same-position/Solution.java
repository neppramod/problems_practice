import java.util.*;

/**
 * Solution:
 *  Minimum cost to Move Chips to the Same Position
 */
public class Solution {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] positions = { 1, 1000000000 };
		System.out.println(sol.minCostToMoveChips(positions));

	}

	public int minCostToMoveChips(int[] position) {
		if (position == null || position.length == 0) {
			return 0;
		}

		int n = position.length;
		int[] dp = new int[n];

		// count number of odd parity and even parity
		// return the number of smaller parity, because we need to move smaller to bigger
		int even = 0;
		int odd = 0;

		for (int i = 0; i < n; i++) {
			if (position[i] % 2 == 0) {
				even++;
			} else if (position[i] % 2 == 1) {
				odd++;
			}
		}

		if (even == 0 || odd == 0) {
			return 0;
		} else if (even > odd) {
			return odd;
		} else {
			return even;
		}
    }
}
