import java.util.*;


/*

  s => (()()(((()

 */

public class Solution
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = "()))((";

        int result = minAddToMakeValid(s);
        System.out.println(result);
    }

    public static int minAddToMakeValid(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }

        int count = 0;
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '(') {
                count++;
                stack.push('(');
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                    count--;
                } else {
                    count++;
                }
            }
        }

        return count;
    }
}
