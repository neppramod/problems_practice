import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text1 = "abac", text2 = "cab";
        String lcs = lcs(text1.toCharArray(), text2.toCharArray());
        String scs = csc(text1, text2, lcs);
        System.out.println(scs);
    }

    static String csc(String text1, String text2, String lcs) {
        String t1 = addDiff(text1, lcs);
        String t2 = addDiff()
    }

    static String addDiff(String text1, String lcs) {
        StringBuilder one = new StringBuilder();

        int j = 0;
        for (int i = 0; i < text1.length(); i++) {
            if (j >= lcs.length()) {
                break;
            }

            if (text.charAr(i) == lcs.charAt(j)) {
                j++;
                continue;
            } else {
                one.append(text1.charAt(i));
            }
        }

        return one.toString();
    }

    static String lcs(char[] s, char[] t) {
        int M = s.length;
        int N = t.length;

        int[][] dp = new int[M+1][N+1];
        char[][] c = new char[M+1][N+1];

        for (int i = 0; i <= M; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s[i-1] == t[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    c[i][j] = '\\';
                } else if (dp[i-1][j] > dp[i][j-1]){
                    dp[i][j] = dp[i-1][j];
                    c[i][j] = '|';
                } else {
                    dp[i][j] = dp[i][j-1];
                    c[i][j] = '-';
                }
            }
        }

        Deque<Character> queue = new LinkedList<>();
        int i = M;
        int j = N;

        while (i >= 0 && j >= 0) {
            if (c[i][j] == '\\') {
                queue.addLast(s[i]);
                i--;
                j--;
            } else if (c[i][j] == '|') {
                i--;
            } else {
                j--;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.pop());
        }

        return sb.toString();

    }
}
