import java.util.*;

public class Mixtures
{
    public static int minSmoke(int[] p)
    {
        int n = p.length;
        int[][] m = new int[n][n];
        int[][] c = new int[n][n];

        for (int i = 0; i < n; i++) {
            c[i][i] = p[i];
            m[i][i] = 0;
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int q = m[i][k] + m[k+1][j] + c[i][k] * c[k+1][j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        c[i][j] = (c[i][k] + c[k+1][j]) % 100;
                    }
                }
            }
        }

        return m[0][n-1];
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
       
       	while (sc.hasNext()) {
            int N = sc.nextInt();
            int[] p = new int[N];
            for (int i = 0; i < N; i++) {
                p[i] = sc.nextInt();
            }

            System.out.println(minSmoke(p));
        }
    }
}
