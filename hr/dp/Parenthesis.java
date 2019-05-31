import java.util.*;

public class Parenthesis
{
    public static void main(String[] args) {

        HashSet<String> list = new HashSet<String>();
        paren("()", list, 9);

        for (String s : list) {
            System.out.println(s);
        }
    }

    private static void paren(String prefix, HashSet<String> list, int n)
    {
        if (n <= 0 || prefix.length() < 2) return;
        if (prefix.length() == 2 * n) {
            if (!list.contains(prefix))
                list.add(prefix);
            return;
        } else {
            for (int i = 0; i < prefix.length(); i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(prefix.substring(0, i));
                sb.append("()");
                sb.append(prefix.substring(i));
                paren(sb.toString(), list, n);
            }
        }
    }
}
