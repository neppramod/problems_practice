import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();
		String s = "3[a]2[bc]";
		String result = sol.decodeString(s);
		System.out.println(result);
	}
	
    public String decodeString(String s) {
		Stack<String> stack = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '[') {
				stack.push(String.valueOf(c));
			} else if (Character.isDigit(c)) {
				int val = 0;
				while (i < s.length() && Character.isDigit(c)) {
					val = (val * 10) + (c - '0');
					i++;
				}
				stack.push(String.valueOf(val));
				i--;
			} else if (Character.isLowerCase(c)) {
				StringBuilder sb = new StringBuilder();
				while (i < s.length() && Character.isLowerCase(c)) {
					sb.append(c);
					i++;
				}
				stack.push(String.valueOf(sb.toString()));
				i--;
			} else if (c == ']') {
				String textToRepeat = stack.pop();
				String leftBrace = stack.pop();
				Integer repeatTimes = Integer.valueOf(stack.pop());
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < repeatTimes; j++) {
					sb.append(textToRepeat);
				}
				stack.push(sb.toString());
			}
		}

		return stack.pop();
	}

	
}
