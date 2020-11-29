import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();   
	}

    public String licenseKeyFormatting(String S, int K) {
		int N = S.length();

		for (int i = N-1; i >= 0; i--) {			char c = extracted(S, i);

			if (c == '-') {
				continue;
			}
			
		}
    }

	private char extracted(String S, int i) {
		char c = Character.toUpper(S.charAt(i));
		return c;
	}
}
