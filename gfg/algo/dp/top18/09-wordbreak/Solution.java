import java.util.*;

public class Solution
{


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<String> dictionary = Arrays.asList("apple","tiger","banana","cat");

        //String cur = "cattigerapplebanana";
        String cur = "bat";
        System.out.println(isFound(cur, dictionary));
        System.out.println(isFoundDP(cur, dictionary));

    }

    static boolean isFound(String str, List<String> dictionary)
    {
        int size = str.length();
        if (size == 0) {
            return true;
        }

        for (int i = 1; i <= size; i++) {
            if (dictionary.contains(str.substring(0, i)) && isFound(str.substring(i, size), dictionary)) {
                return true;
            }
        }

        return false;
    }


    static boolean isFoundDP(String str, List<String> dictionary)
    {
        int N = str.length();
        boolean dp[] = new boolean[N+1];
        dp[0] = true;

        for (int i = 1; i <= N; i++) {
            String first = str.substring(0,i);
            if (dictionary.contains(first)) dp[i] = true;
            for (int j = i+1; j <= N; j++) {
                String second = str.substring(i, j);
                if (dictionary.contains(second) && dp[i] == true) dp[j] = true;
            }
        }

        return dp[N];
    }
}
