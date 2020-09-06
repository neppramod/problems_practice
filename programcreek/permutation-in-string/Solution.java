/*
 s1 = "ab"
 s2 = "eidbaooo"

[a: 1, b: 1]

map first,
empty map used for second

for each character in s2
   -- if cur char is not equal to one in s1, i = j + 1, empty tmp map, contineu
   -- else
		get current count of character, if it is 0, or less than cur char in s2
		- increment in tmp map
		- if j - i + 1 == s1.length() return true
		if current count is greater tha length
		   while (i < j):
				 if (cur s2 charactes at i and j are equal incrment i++, break)
				 else decrement character at i from tmp map, increment i

*/



import java.util.*;

public class Solution
{
	public static void main(String[] args) {
		Solution sol = new Solution();
		String s1 = "ab";
		String s2 = "eidbaooo";
		boolean result = sol.checkInclusion(s1, s2);
		System.out.println(result);
	}

	public boolean checkInclusion(String s1, String s2) {
		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s1.length(); i++) {
			if (map.containsKey(s1.charAt(i))) {
				map.put(s1.charAt(i), map.get(s1.charAt(i)) + 1);
			} else {
				map.put(s1.charAt(i), 1);
			}
		}

		int i = 0;
		HashMap<Character, Integer> tmpMap = new HashMap<>();

		for (int j = 0; j < s2.length(); j++) {
			char c = s2.charAt(j);

			if (!map.containsKey(c)) {
				i = j + 1;
				tmpMap.clear();
				continue;
			} else {

				int count = tmpMap.getOrDefault(c, 0);
				if (count == 0 || count < map.get(c)) {
					tmpMap.put(c, count + 1);

					if (j - i + 1 == s1.length()) {
						return true;
					}

				} else {
					while (i < j) {
						if (s2.charAt(i) == s2.charAt(j)) {
							i++;
							break;
						}

						tmpMap.put(c, tmpMap.get(c) - 1);
						i++;
					}
				}
			}

		}

		return false;
	}
}
