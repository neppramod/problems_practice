import java.util.*;

public class TwoStrings
{
    static class Pair
    {
        String s1;
        String s2;
        public Pair(String s1, String s2)
        {
            this.s1 = s1;
            this.s2 = s2;
        }
    }
    
    static String hasSubstring(String s1, String s2)
    {
        boolean foundchars[] = new boolean[256];
        for (int i = 0; i < s1.length(); i++) {
            foundchars[s1.charAt(i)] = true;
        }

        for (int i = 0; i < s2.length(); i++) {
            if (foundchars[s2.charAt(i)] == true)
                return "YES";
        }

        return "NO";
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); sc.nextLine();
        ArrayList<Pair> pairs = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            String A = sc.nextLine().trim();
            String B = sc.nextLine().trim();
            pairs.add(new Pair(A, B));
        }

        for (Pair p: pairs) {
            System.out.println(hasSubstring(p.s1, p.s2));
        }
    }
}
