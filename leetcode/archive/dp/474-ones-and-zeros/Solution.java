import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] arr = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;

        int result = solve(arr, m, n);

        System.out.println(result);

    }

    static int solve(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];

        // dp state = maxmim number of strings that can be formed with
        // i 0s and j 1s
        // dp[i][j] = max(dp[i-zeros][j-ones] + 1)
        // zeros = zeros(strs[k]), ones = ones(strs[k])

        for (String s : strs) {
            int ones = ones(s);
            int zeros = s.length()-ones;

            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-zeros][j-ones] + 1);
                }
            }
        }

        return dp[m][n];
    }

    static int ones(String s) {
        int count = 0;
        if (s != null) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    count++;
                }
            }
        }

        return count;
    }

    static void pA1(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    static void pA2(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
