public class MatrixMultiplication
{
    public static int minparen(int[] p)
    {
        int n = p.length - 1;
        int[][] m = new int[n][n];
        int[][] s = new int[n][n];

        for (int i = 0; i < n; i++)
            m[i][i] = 0;

        int j;
        for (int l = 2; l < n; l++) {
            for (int i = 1; i < n - l + 1; i++) {
                j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int q = m[i][k] + m[k+1][j] + p[i-1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }

        return m[1][n-1];
    }

    public static void main(String[] args)
    {
        int[] p = {20,30,40,50,40,70};
        System.out.println(minparen(p));
        System.out.println(minparen(new int[] {10, 100, 5, 50}));
    }
}
