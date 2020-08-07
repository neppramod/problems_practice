import java.util.*;
 
public class WordBreak
{
    public static void main(String[] args) {
        Solution sol = new Solution();
         
    }
    
    public boolean wordBreak(String s, Set<String> dict) {
		return wordBreakHelper(s, dict, 0);
	}

	boolean wordBreakHelper(String s, Set<String> dict, int start) {
		if (start == s.length()) {
			return true;
		}

		for (String a : dict) {
			int len = a.length();
			int end = start + end;

			if (end > s.length()) {
				continue;
			}

			if (s.substring(start, end).equals(a)) {
				if(wordBreakHelper(s, dict, end)) {
					return true;
				}
			}
		}

		return false;
	}

	boolean wordBreakDP(String s, Set<String> dict) {
		int n = s.length();
		int[] dp = new int[n+1];
		Arrays.fill(dp, -1);
		dp[0] = 1;

		for (int i = 0; i < n; i++) {
			if (dp[i] != -1) {
				for (int j = i + 1; j <= n; j++) {
					if (dict.contains(s.substring(i, j))) {
						dp[j] = i;
					}
				}				
			}
		}

		return dp[n+1] != -1;
	}
}
