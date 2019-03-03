import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<String> dictionary = Arrays.asList("apple","tiger","banana","cat");

        String cur = "cattigerapplebanana";
        System.out.println(isFound(cur, dictionary));
        System.out.println(isFoundDP(cur, dictionary));

    }

    static boolean isFound(String s, List<String> dictionary)
    {

        if (dictionary.contains(s)) return true;

        for (int i = 1; i < s.length(); i++) {
            String firstPart = s.substring(0, i);
            String secondPart = s.substring(i,s.length());

            if (isFound(firstPart, dictionary) && isFound(secondPart, dictionary)) return true;

        }

        return false;
    }

    static boolean isFoundDP(String s, List<String> dictionary)
    {
        int N = s.length();
        boolean dp[] = new boolean[N+1];
        dp[0] = false;

        if (dictionary.contains(s)) return true;

        for (int j = 1; j <= N; j++) {
            for (int i = 1; i < N; i++) {

                String firstPart = s.substring(0, i);


                if (dictionary.contains(firstPart))
                    dp[i] = true;

                if (j > i) {
                    String secondPart = s.substring(i,j);
                    if (dictionary.contains(secondPart) && dp[i] == true)
                        dp[j] = true;
                }
            }
        }

        return dp[N];
    }
}
