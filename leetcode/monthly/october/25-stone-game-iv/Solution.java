import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int n = 4;
		boolean result = sol.winnerSquareGame(n);
		System.out.println(result);
    }
    
	public boolean winnerSquareGame(int n) {
        int[] dp = new int[n+1];
		return win(n, dp) > 0;
    }

	int win(int n, int[] dp) {
		if (n == 0) {
			return -1;
		}
		
		if (dp[n] != 0) {
			return dp[n];
		}

		for (int i = (int)Math.sqrt(n); i >= 1; i--) {
			if (win(n - i * i, dp) < 0) {
				return dp[n] = 1;
			}	
		}
		return dp[n] = -1;
	}
}
