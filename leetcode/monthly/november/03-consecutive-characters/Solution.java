import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();
		String s = "tourist";
		System.out.println(sol.maxPower(s));

	}

    public int maxPower(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int cur = 1;
		int max = 1;
		int n = s.length();
		for (int i = 1; i < n; i++) {
			if (s.charAt(i) == s.charAt(i-1)) {
				cur++;
			} else {
				max = Math.max(max, cur);
				cur = 1;
			}
		}

		return max;
	}
}
