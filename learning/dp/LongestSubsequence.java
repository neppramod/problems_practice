public class LongestSubsequence
{
    public static int longest(char[] x, char[] y)
    {
        int N = x.length;
        int M = y.length;

        int[][] sum = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (x[i-1] == y [j-1]) {
                    sum[i][j] = sum[i-1][j-1] + 1;
                } else {
                    sum[i][j] = Math.max(sum[i-1][j], sum[i][j-1]);
                }
            }
        }

        return sum[N][M];
    }

    public static void main(String[] args)
    {
        char[] x = "ABACBDAB".toCharArray();
        char[] y = "BDCABA".toCharArray();
        System.out.println(longest(x, y));
    }
}
