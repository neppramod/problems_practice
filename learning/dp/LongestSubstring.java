public class LongestSubstring
{
    public static int longest(char[] X, char[] Y)
    {
        int M = X.length;
        int N = Y.length;
        int[][] sum = new int[M+1][N+1];

        sum[0][0] = 0;
        int max = 0;

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (X[i-1] == Y[j-1]) {
                    sum[i][j] = sum[i-1][j-1] + 1;
                    max = Math.max(max, sum[i][j]);
                } else {
                    sum[i][j] = 0;
                }
            }
        }

        return max;
    }

    public static void main(String[] args)
    {
        char[] X = "DEADMEAT".toCharArray();
        char[] Y = "EATMEAT".toCharArray();
        System.out.println(longest(X, Y));
    }
}
