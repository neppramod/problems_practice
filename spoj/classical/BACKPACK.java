import java.util.*;

public class BACKPACK
{
    static int maxValue(int N, int[] w, int[] c, int[] u)
    {
        int M = w.length-1;
        int[] v = new int[M+1];
        for (int i = 0; i <= M; i++) {
            v[i] = w[i] * c[i];
        }

        int[][] sum = new int[M+1][N+1];
        boolean[] used = new boolean[M+1];

        for (int i = 1; i <= M; i++) {
            if (u[i] > 0 && !used[u[i]]) {
                w[i] = w[i] + w[u[i]];
            }

            for (int j = 1; j <= N; j++) {
                if (j - w[i] >= 0) {
                    sum[i][j] = Math.max(sum[i-1][j], sum[i-1][j-w[i]] + v[i]);
                    if (u[i] > 0 && sum[i][j] != sum[i-1][j])
                        used[u[i]] = true;
                } else {
                    sum[i][j] = sum[i-1][j];
                }
            }
        }

        return sum[M][N];
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int vmax = sc.nextInt();
            int nvols = sc.nextInt();
            int[] w = new int[nvols+1];
            int[] c = new int[nvols+1];
            int[] u = new int[nvols+1];
            for (int j = 1; j <= nvols; j++) {
                w[j] = sc.nextInt();
                c[j] = sc.nextInt();
                u[j] = sc.nextInt();
            }

            System.out.println(maxValue(vmax, w, c, u));
        }
    }
}
