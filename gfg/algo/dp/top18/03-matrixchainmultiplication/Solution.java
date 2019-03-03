import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] p = {1,2,3,4};
        System.out.println(mco(p,1,p.length-1));
        System.out.println(mcodp(p));
        // 1x2 2x3 3x4 4x3
        // 48
    }


    static int mco(int[] p, int i, int j)
    {
        if (i == j) return 0;

        int res = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int cur = mco(p,i,k) + mco(p,k+1,j) + p[i-1] * p[k] * p[j];
            if (cur < res) res = cur;
        }

        return res;
    }

    static int mcodp(int[] p)
    {
        int N = p.length;
        int dp[][] = new int[N][N];

        for (int i = 0; i < N; i++) {
            dp[i][i] = 0;
        }

        // gap must be 2
        for (int gap = 2; gap < N; gap++) {
            for (int i = 1; i < N-gap+1; i++) {
                int j = i+gap-1;

                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + p[i-1]*p[k]*p[j]);
                }
            }
        }

        return dp[1][N-1];
    }
}
