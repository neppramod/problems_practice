import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		String s = "ZY";
		int result = sol.titleToNumber(s);
		System.out.println(result);
    }
    
    public int titleToNumber(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			result = (result * 26) + (s.charAt(i) - 'A') + 1;
		}

		return result;
    }
}
