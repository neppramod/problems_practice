import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		String s = "cbacdcbc";
		String result = sol.removeDuplicateLetters(s);
		System.out.println(result);
    }
    
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) {
			return "";
		}

		char[] letters = new char[26];
		for (int i = 0; i < s.length(); i++) {
			letters[s.charAt(i) - 'a']++;
		}

		int pos = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(pos) > s.charAt(i)) {
				pos = i;
			}

			if (--letters[s.charAt(i) - 'a'] == 0) {
				break;
			}
		}

		return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
}
