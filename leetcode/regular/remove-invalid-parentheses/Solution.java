import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();
		String s= "()())()";
		List<String> result = sol.removeInvalidParentheses(s);
		System.out.println(result);
	}

	public List<String> removeInvalidParentheses(String s) {
		List<String> result = new ArrayList<>();
		
		if (s == null) {
			return result;
		}

		dfs(s, "", 0, 0, result);
		return result;
	}

	int max = 0;

	void dfs(String left, String right, int leftCount, int leftMax, List<String> result) {
		if (left.length() == 0) {
			if (leftCount == 0 && !right.isEmpty()) {
				if (leftMax > max) {
					max = leftMax;
				}

				if (leftMax == max && !result.contains(right)) {
					result.add(right);
				}
			}
		} else if (left.charAt(0) == '(') {
			// keep and drop
			dfs(left.substring(1), right + "(", leftCount + 1, leftMax + 1, result);
			dfs(left.substring(1), right, leftCount, leftMax, result);
		} else if (left.charAt(0) == ')') {

			// keep and drop
			if (leftCount > 0) {
				dfs(left.substring(1), right + ")", leftCount - 1, leftMax, result);
			}
			dfs(left.substring(1), right, leftCount, leftMax, result);
		}
	}
}


		

			

		

		

				

		


	
		
	
