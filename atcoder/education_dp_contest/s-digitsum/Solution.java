import java.util.*;

public class Solution
{
    private static final long MOD = 1000000007L;
    private static final int MAXN = 10010;
    private static final int MAXD = 110;

    public static long solve(int pos, int flag, int resto, int D, List<Integer> digit, int N, long[][][] dp) {
        if (pos == N) {
            return resto == 0 ? 1 : 0;
        }

        if (dp[pos][flag][resto] != -1) {
            return dp[pos][flag][resto];
        }

        long total = 0;
        int limit = flag == 1? digit.get(pos) : 9;

        for (int i = 0; i <= limit; i++) {

            int nextFlag = ((flag == 1) && (i == limit)) ? 1 : 0;

            total += solve(pos + 1, nextFlag, (resto + i) % D, D, digit, N, dp);
        }

        return dp[pos][flag][resto] = total % MOD;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int D = sc.nextInt();

        int N = s.length();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add((int)(s.charAt(i) - '0'));
        }

        long[][][] dp = new long[MAXN][2][MAXD];
        for (int i = 0; i < MAXN; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        long answer = solve(0, 1, 0, D, list, N, dp) - 1;
        if (answer < 0) answer += MOD;

        System.out.println(answer);

    }

}
