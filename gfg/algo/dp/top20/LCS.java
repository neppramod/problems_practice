public class LCS
{
    public static void main(String[] args)
    {
        System.out.println(lcs("abcdgh", "aedfhr"));
    }

    public static int lcs(String str1, String str2)
    {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int[][] L = new int[s1.length+1][s2.length+1];

        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                if (s1[i-1] == s2[j-1]) {
                    L[i][j] = L[i-1][j-1] + 1;
                } else {
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
                }
            }
        }

        return L[s1.length][s2.length];
    }
}
