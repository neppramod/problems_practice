import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();
		String exp = "3 + 2 * 2";
		int result = sol.calculate(exp);
		System.out.println(result);
	}
	
	public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        char previousSign = '+';

        int val = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                val = val * 10 + (c - '0');
            }

            if (isOperator(c) || i == s.length() - 1) {
                if (previousSign == '+') {
                    stack.push(val);
                } else if (previousSign == '-') {
                    stack.push(-val);
                } else if (previousSign == '*') {
                    stack.push(stack.pop() * val);
                } else if (previousSign == '/') {
                    stack.push(stack.pop() / val);
                }

                val = 0;
                previousSign = c;
            }

        }

        int result = 0;
        while (!stack.isEmpty()) {  // since we have already handled * and /, we need to handle only + and - values
            result += stack.pop();
        }

        return result;
    }

    boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}
