public class Martian
{
    public static int maxMineral(int[][] y, int[][] b)
        {
            int N = y.length;
            int M = y[0].length;
            int[][] sum = new int[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int tmp1 = y[i][j];
                    int tmp2 = b[i][j];

                    if (i > 0) tmp1 += sum[i-1][j];
                    if (j > 0) tmp2 += sum[i][j-1];
                    sum[i][j] = Math.max(tmp1, tmp2);
                }
            }

            return sum[N-1][M-1];
        }

    public static void main(String[] args)
        {
            int[][] y = {
                {0, 0, 10, 9},
                {1, 3, 10, 0},
                {4, 2, 1, 3},
                {1, 1, 20, 0}
            };

            int[][] b = {
                {10, 0, 0, 0},
                {1, 1, 1, 30},
                {0, 0, 5, 5},
                {5, 10, 10, 10}
            };

            for (int i = 0; i < y.length; i++) {
                for (int j = 0; j < y[0].length; j++) {
                    if (j > 0)
                        y[i][j] += y[i][j-1];
                    if (i > 0)
                        b[i][j] += b[i-1][j];
                }
            }

            System.out.println(maxMineral(y, b));
        }
}
