import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		String s = "catsanddog";
		Set<String> wordDict = new HashSet<>();
		wordDict.addAll(Arrays.asList("cat", "cats", "and", "sand", "dog"));
		List<String> result = sol.wordBreak(s, wordDict);
		System.out.println(result);
    }

	List<String> wordBreak(String s, Set<String> wordDict) {
		int n = s.length();
		List<String>[] dp = new ArrayList[n+1];
		dp[0] = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			if (dp[i] == null) {
				continue;
			}

			for (String word : wordDict) {
				int len = word.length();
				int end = i + len;

				if (end > s.length()) {
					continue;
				}

				if (s.substring(i, end).equals(word)) {
					if(dp[end] == null) {
						dp[end] = new ArrayList<>();
					}
					dp[end].add(word);
				}
			}
		}

		List<String> result = new ArrayList<>();
		if (dp[n] == null) {
			return result;
		}

		List<String> tmp = new ArrayList<>();
		dfs(dp, result, tmp, s.length());
		return result;
	}

	void dfs(List<String>[] dp, List<String> result, List<String> tmp, int end) {
		if (end <= 0) {
			String path = tmp.get(tmp.size()-1);
			
			for (int i = tmp.size()-2; i >= 0; i--) {
				path += " " + tmp.get(i);
			}

			result.add(path);
		} else {
			for (String w : dp[end]) {
				tmp.add(w);
				dfs(dp, result, tmp, end - w.length());
				tmp.remove(tmp.size()-1);
			}
		}
	}
}
