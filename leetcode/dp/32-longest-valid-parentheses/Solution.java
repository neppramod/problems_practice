import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //String input = "))))(((((((()))))))))()))(()))))))((()))()()()";
        //String input = "((()))))))))()))(()))))))((()))()()()";
        //String input = "((()))";
        String input = "()(()";
        int result = longestValidParentheses(input);
        System.out.println(result);
    }

    static int longestValidParentheses(String input) {
        if (input == null) {
            return 0;
        }

        Stack<Character> stack = new Stack<>();
        int count = 0;
        int max = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '(') {
                stack.push('(');
                System.out.println("Push: ");
            } else if (ch == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    count += 2;
                    if (max < count) {
                        max = count;
                    }
                    System.out.println("Pop: ");
                } else {

                    while (!stack.isEmpty()) {
                        stack.pop();
                    }
                    count = 0;
                }
            }
        }

        if (!stack.isEmpty() && count > max) {
            max = count;
        }

        return max;
    }
}
