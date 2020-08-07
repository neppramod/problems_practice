import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
		String s = "loveleetcode";
		Solution sol = new Solution();
		System.out.println(sol.firstUniqChar(s));
    }
    
    public int firstUniqChar(String s) {
        
        if (s.length() == 0) {
            return -1;
        }
        
        int[] alphabets = new int[26];
        for (int i = 0; i < s.length(); i++) {
			alphabets[s.charAt(i) - 'a']++;       
        }

		for (int i = 0; i < s.length(); i++) {
			if (alphabets[s.charAt(i)-'a'] == 1) {
				return i;
			}
		}

		return -1;
    }
}
