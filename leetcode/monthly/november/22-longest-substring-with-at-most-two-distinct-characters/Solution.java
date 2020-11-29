import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();
		String s =  "abZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZYX";
		int resl = sol.lengthOfLongestSubstringTwoDistinct(s);
		System.out.println(resl);
	}
	
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int maxLength = 0;
        
		int[] alphabets = new int[256];
		int left = 0;
		int n = s.length();
		for (int i = 0; i < n; i++) {
			alphabets[s.charAt(i) - 'A']++;
			if (numberOfUniqueCharacters(alphabets) <= 2) {
				int length = i - left + 1;
				maxLength = Math.max(length, maxLength);
			} else {
				while (numberOfUniqueCharacters(alphabets) > 2) {
					alphabets[s.charAt(left) - 'A']--;
					left++;
				}
			}
		}

		return maxLength;
    }

	int numberOfUniqueCharacters(int[] alphabets) {
		int count = 0;
		for (int i = 0; i < alphabets.length; i++) {
			if (alphabets[i] > 0) {
				count++;
			}
		}

		return count;
	}


	/*
	  Add elements while length of unique charactes is less than or equal to 2
	  If elements exceed length 2, keep removing element from left, till length is less than 2
	 */
}
