import java.util.*;

public class Brackets
{
    static int numberOfBrackets(int M, int[] s)
    {
        int N = 2 * M;
        int[][] sum = new int[N+1][N+1];
        boolean[] k = new boolean[N+1];

        for (int i = 0; i < s.length; i++) {
            k[s[i]] = true;
        }

        sum[0][0] = 0;
        sum[1][1] = 1;

        // since [1][1] is already filled there won't be any more j's with "["
        for (int j = 2; j <= N; j++) {
            sum[1][j] = 0;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == 0) {
                    if (k[i])
                        sum[i][j] = 0;
                    else
                        sum[i][j] = sum[i-1][1];
                } else {
                    if (k[i])
                        sum[i][j] = sum[i-1][j-1];
                    else
                        sum[i][j] = sum[i-1][j-1] + sum[i-1][j+1];
                }

            }
        }

        return sum[N][0];
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int k = sc.nextInt();
            int[] s = new int[k];
            for (int j = 0; j < k; j++) {
                s[j] = sc.nextInt();
            }

            System.out.println(numberOfBrackets(N, s));
        }
    }
}
