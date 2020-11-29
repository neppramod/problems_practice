import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[] tokens = { 100, 200, 300, 400 };
		int P = 200;
		int res = sol.bagOfTokenScore(tokens, P);
		System.out.println(res);
    }
    
    public int bagOfTokenScore(int[] tokens, int P) {
		Arrays.sort(tokens);

		int l = 0, r = tokens.length - 1;
		int maxScore = 0;
		int score = 0;
		
		while (l <= r && P >= tokens[l]) {
			while (l < tokens.length && P >= tokens[l]) {
				P -= tokens[l++];
				score++;
			}

			maxScore = Math.max(maxScore, score);
			if (score > 0 && l < r) {
				P += tokens[r--];
				score--;
			}
		}

		return maxScore;
	}
}
