public class Knapsack
{

    public static int maxValue(int[] v, int[] w, int N)
    {
        int W = w.length;
        int[][] sum = new int[N+1][W+1];
        sum[0][0] = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                if (i >= w[j-1] && sum[i-w[j-1]][j-1] + v[j-1] > sum[i-1][j-1])
                    sum[i][j] = sum[i-w[j-1]][j-1] + v[j-1];
                else
                    sum[i][j] = sum[i-1][j-1];
            }
        }

        return sum[N][W];
    }

    public static void main(String[] args)
    {
        int[] w = {2, 4, 7};
        int[] v = {8, 14, 20};
        System.out.println(maxValue(v, w, 8));
    }
}
