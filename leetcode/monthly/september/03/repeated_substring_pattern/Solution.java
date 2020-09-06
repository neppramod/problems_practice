/* Repeated substring pattern. Can substring make the whole string with repeatition.

1. Count the number of each characters. Find the smallest possible substring that needs to form.

E.g abab => a:2, b:2. => ab is smallest, see if you can form the string with ab or ba repeatition.

2. aba => a:2, b:1 => ab is smallest, see if you can form with ab or ba

3. abcabcabcabc => a:4, b:4, c:4 => abc. See if you can form abab, because it starts with ab. 


aaabaaab => a:6, b:2 => aaab, Here keep on decreasing characters until the pattern with all charactes is found. Once a substring is found, repeat it.

 */


import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		String s = "abac";
		boolean result = sol.repeatedSubstringPatttern(s);
		System.out.println(result);
    }
    
    public boolean repeatedSubstringPatttern(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}

		HashSet<Character> newKeySet = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		
		for (char c : s.toCharArray()) {
			newKeySet.add(c);
			sb.append(c);

			if (newKeySet.size() == map.keySet().size()) {
				break;
			}
		}

		String subStr = sb.toString();
		if (subStr.length() == s.length()) {
			return false;
		}
		
		int k = subStr.length();
		int i = 0;
		for (; i < s.length(); i+=k) {
			if (i + k > s.length()) {
				i = i + k;
				break;
			}
			
			if (!s.substring(i, i + k).equals(subStr)) {
				return false;
			}
		}

		return i == s.length(); 
		
	}
}
