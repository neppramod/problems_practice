import java.util.*;
public class Brackets
{
    public static void createBrackets(String cur, int n, HashSet<String> list, int[] s)
    {
        if (cur.length() == 2 * n) {
            boolean startingatk = true;
            for (int i = 0; i < s.length; i++) {
                if (cur.charAt(s[i]-1) != '[') {
                    startingatk = false;
                    break;
                }
            }
            if (startingatk) {
                list.add(cur);
            }
        } else {

            for (int i = 0; i <= cur.length(); i++) {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                sb.append(cur.substring(0,i));
                sb.append("]");
                sb.append(cur.substring(i, cur.length()));
                createBrackets(sb.toString(), n, list, s);
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] s = new int[K];

            for (int j = 0; j < K; j++) {
                s[j] = sc.nextInt();
            }

            HashSet<String> brackets = new HashSet<>();
            createBrackets("", N, brackets, s);
            System.out.println(brackets.size());
            System.out.println(brackets);
        }
    }
}
