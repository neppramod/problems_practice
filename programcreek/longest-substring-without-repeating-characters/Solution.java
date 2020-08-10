import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        var sol = new Solution();
		String s = "abcabcbb";
		System.out.println(sol.longestSubString(s));
    }
    
	int longestSubString(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		var map = new HashMap<Character, Integer>();
		int n = s.length();
		int i = 0;
		int maxLen = 0;
		
		for (int j = 0; j < n; j++) {
			char ch = s.charAt(j);

			if (!map.containsKey(ch)) {
				map.put(ch, j + 1);
			} else {
				i = Math.max(i, map.get(ch));
				map.put(ch, j + 1);
			}

			maxLen = Math.max(maxLen, j - i + 1);
			
		}

		return maxLen;
	}
}
