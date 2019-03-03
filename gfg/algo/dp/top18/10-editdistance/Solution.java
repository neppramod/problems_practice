import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s1 = "sunday",s2 = "saturday";
        System.out.println(editDistance(s1.toCharArray(), s1.length(), s2.toCharArray(), s2.length()));
        System.out.println(editDistaneDP(s1.toCharArray(), s1.length(), s2.toCharArray(), s2.length()));
    }

    static int editDistance(char[] s1, int l1, char[] s2, int l2)
    {
        if (l1 == 0) return l2;
        if (l2 == 0) return l1;

        if (s1[l1-1] == s2[l2-1]) return editDistance(s1,l1-1, s2,l2-1);

        int min = Math.min(editDistance(s1,l1-1,s2,l2), editDistance(s1,l1,s2,l2-1));
        min = Math.min(min, editDistance(s1,l1-1, s2, l2-1));

        return min+1;
    }

    static int editDistaneDP(char[] s1, int l1, char[] s2, int l2)
    {
        int[][] dp = new int[l1+1][l2+1];

        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                if (i == 0) dp[i][j] =j;
                else if (j == 0) dp[i][j] = i;
                else if(s1[i-1] == s2[j-1]) dp[i][j] = dp[i-1][j-1];
                else {
                    int cur = Math.min(dp[i][j-1], dp[i-1][j]);
                    cur = Math.min(cur, dp[i-1][j-1]);
                    dp[i][j] = 1 + cur;
                }
            }
        }

        return dp[l1][l2];
    }
}
