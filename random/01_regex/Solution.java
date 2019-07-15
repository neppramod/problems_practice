import java.util.*;


public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String pattern = sc.next();
        String text = sc.next();

        Boolean[][] memo = new Boolean[text.length()+1][pattern.length()+1];
        Boolean matches = isMatch(text.toCharArray(), pattern.toCharArray(), 0, 0, memo);
        System.out.println(matches);

    }

    static boolean isMatch(char[] t, char[] p, int i, int j, Boolean[][] memo)
    {
        if (memo[i][j] != null) return memo[i][j];
        boolean ans = false;

        if (j == p.length)
            ans= (i==t.length);
        else {
            boolean curMatch = (i < t.length && (t[i] == p[j]) || (p[j] == '.'));

            //now let's check if the next symbol is *
            if (j + 1 < p.length && p[j+1] == '*')
                ans = isMatch(t, p, i, j+2, memo) || (curMatch && isMatch(t, p, i+1, j, memo));
            else
                ans= curMatch && isMatch(t, p, i+1, j+1, memo);
        }

        memo[i][j] = Boolean.valueOf(ans);
        return ans;
    }



    /*
      If p[j] == '*'
         - Matches 0 or more of previous characters

     */
}
