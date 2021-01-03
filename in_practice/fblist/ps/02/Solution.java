import java.util.*;

/*

Smallest window that contains all charactes of string itself
		w.geeksforgeeks.org/smallest-window-contains-characters-string/

Input: aabcbcdbca
Output: dbca
			

1. Count the number of distinct characters (can use frequency or set)
2. Next go through each character, and once the total number of distinct characters is substring is equal to distinct characters in whole string, start recording min length (and associated String), you can move start ahead and remove frequencies of characters, if they are more than 1
*/

public class Solution {

	public static void main(String[] args) {
		String s = "aabcbcdbca";
		Solution sol = new Solution();
		String result = sol.smallestWindow(s);
		System.out.println(result);
	}

	public String smallestWindow(String s) {
		if (s == null) {
			return null;
		}

		int overall_distinct_chars = getDistinctCharsCount(s);

		int[] chars_freq = new int[26];
		int distinct_chars = 0;
		int minLength = Integer.MAX_VALUE;
		String smallestSubString = null;
		int start = 0;
		
		for (int i = 0; i < s.length(); i++) {
			chars_freq[s.charAt(i) - 'a']++;

			if (chars_freq[s.charAt(i) - 'a'] == 1) {
				distinct_chars++;
			}

			if (distinct_chars == overall_distinct_chars) {
				// let's prune all the starting frequencies greater than 1

				while (chars_freq[s.charAt(start) - 'a'] > 1) {
					chars_freq[s.charAt(start) - 'a']--;
					start++;
				}

				int length = i - start + 1;
				if (minLength > length) {
					minLength = length;
					smallestSubString = s.substring(start, start + minLength);
				}
			}
		}

		return smallestSubString;
	}

	// assume s is lowercase alphabets
	int getDistinctCharsCount(String s) {
		int[] frequency = new int[26];
		for (int i = 0; i < s.length(); i++) {
			frequency[s.charAt(i) - 'a']++;
		}

		int count = 0;
		for (int i = 0; i < 26; i++) {
			if (frequency[i] != 0) {
				count++;
			}
		}

		return count;
	}
}
