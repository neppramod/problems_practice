import java.util.*;

public class CoinChange
{
    static long getWays(long n, long[] c){
        int M = c.length;
        int N = (int)n;
        long[][] sum = new long[M+1][N+1];

        // Set first column as 1, because a sum of 0 can be formed using
        // Any coin in 1 ways
        for (int i = 0; i <= M; i++) {
            sum[i][0] = 1;
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                sum[i][j] = sum[i-1][j];

                if (j-c[i-1] >= 0) {
                    sum[i][j] = sum[i][j] + sum[i][(j - (int)c[i-1])];
                }
            }

        }

        return sum[M][N];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] c = new long[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextLong();
        }

        long ways = getWays(n, c);
        System.out.println(ways);
    }
}
