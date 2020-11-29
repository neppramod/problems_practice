import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.longestSubstring("aaabb", 3));
		System.out.println(sol.longestSubstring("ababbc", 2));
	}


	public int longestSubstring(String s, int k) {
		Map<Character, Integer> map = new HashMap<>();

		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		Set<Character> splitSet = new HashSet<>();
		for (char c : map.keySet()) {
			if (map.get(c) < k) {
				splitSet.add(c);
			}
		}

		if (splitSet.size() == 0) {
			return s.length();
		}

		int i = 0, j = 0;
		int max = 0;
		
		while (j < s.length()) {
			char c = s.charAt(j);

			if (splitSet.contains(c)) {
				if (i != j) {
				max = Math.max(max, longestSubstring(s.substring(i, j), k));					
				}

				i = j + 1;
			}
			j++;
		}

		if (i != j) {
				max = Math.max(max, longestSubstring(s.substring(i, j), k));
		}

		return max;
	}
}
