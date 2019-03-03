import java.util.*;

public class ONP
{
    static String transform(String input)
    {
        char[] carr = input.toCharArray();
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < carr.length; i++) {
            if (carr[i] != ')') {
                stack.push(carr[i] + "");
            } else {
                if (stack.size() == 1)
                    return stack.pop();
                else {
                    String right = stack.pop();
                    String operator = stack.pop();
                    String left = stack.pop();
                    String leftbracket = stack.pop();   // remove left bracket
                    stack.push(left + right + operator);
                }
            }
        }

        return stack.pop();
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            System.out.println(transform(sc.next()));
        }
    }
}
