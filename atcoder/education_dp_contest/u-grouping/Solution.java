import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[][] arr = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextLong();
            }
        }

        long[] prefix = new long[1 << N];

        for (int mask = 0; mask < (1 << N); mask++) {
            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) > 0) {
                    for (int j = i+1; j < N; j++) {
                        if ((mask & (1 << j)) > 0) {
                            prefix[mask] += arr[i][j];
                        }
                    }
                }
            }
        }

        long[] dp = new long[1 << N];
        Arrays.fill(dp, Long.MIN_VALUE);
        dp[0] = 0;

        for (int mask = 0; mask < (1 << N); mask++) {
            List<Integer> notTaken = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) == 0) {
                    notTaken.add(i);
                }
            }

            dfs(0, notTaken, dp[mask], mask, 0, dp, prefix);
        }

        System.out.println(dp[(1 << N) - 1]);

    }

    static void dfs(int i, List<Integer> notTaken, long scoreSoFar, int mask, int group, long[] dp, long[] prefix)
    {
        if (i == notTaken.size()) {
            dp[mask] = Math.max(dp[mask], scoreSoFar + prefix[group]);
            return;
        }

        dfs(i + 1, notTaken, scoreSoFar, mask, group, dp, prefix);
        dfs(i + 1, notTaken, scoreSoFar, mask ^ (1 << notTaken.get(i)), group ^ (1 << notTaken.get(i)), dp, prefix);
    }
}
