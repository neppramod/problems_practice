import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		String s = "abcbbbbcccbdddadacb";
		int k = 2;
		System.out.println(sol.lengthOfLongestSubstringTwoDistinct(s, k));
    }
    
    /*
Given a string, find the longest substring that contains only two unique characters. For example, given "abcbbbbcccbdddadacb", the longest substring that contains 2 unique character is "bcbbbbcccb".
	*/
	public int lengthOfLongestSubstringTwoDistinct(String s, int k) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int max = 0;
		int start = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		int n = s.length();

		
		for (int j = 0; j < n; j++) {
			char c = s.charAt(j);
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}

			while (map.size() > k) {
				max = Math.max(max, j - start);
				char t = s.charAt(start);

				if (map.get(t) > 1) {
					map.put(t, map.get(t) - 1);
				} else {
					map.remove(t);
				}
				start++;
			}
		}

		max = Math.max(max, s.length() - start);

		return max;
	}
}
