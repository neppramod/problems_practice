import java.util.*;

public class ONP
{
    static String onpTransform(char[] c1)
    {
        Stack<String> stack = new Stack<>();
        int N = c1.length;

        for (int i = 0; i < N; i++) {
            if (c1[i] != ')') {
                stack.push(c1[i] + "");
            } else {
                String s1 = "";
                String operator = "";
                String s = "";
                while (!s1.equals('(')) {
                    s1 = stack.pop();
                    System.out.println(s1);
                    if (isoperator(s1)) {
                        operator = s1;
                    } else {
                        s += s1;
                    }
                }
                System.out.println(s + operator);
                stack.push(s+operator);
            }
        }

        return stack.pop();
    }

    static boolean isoperator(String s1)
    {
        boolean operator = false;
        switch (s1) {
            case "+":
            case "-":
            case "*":
            case "/":
            case "^":
                operator = true;
            break;
        }
        return operator;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            String s1 = sc.next();
            System.out.println(onpTransform(s1.toCharArray()));
        }
    }


}
