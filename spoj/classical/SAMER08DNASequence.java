import java.util.*;

public class SAMER08DNASequence
{
    static int lcswithk(char[] c1, char[] c2, int k)
    {
        int M = c1.length;
        int N = c2.length;
        int[][] sum = new int[M+1][N+1];

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {

                int c = 1;
                while (i-c >= 0 && j - c >= 0 && c1[i-c] == c2[j-c]) {
                    if (c >= k) {
                        sum[i][j] = Math.max(sum[i][j], c + sum[i-c][j-c]);
                    }
                    c++;
                }

                sum[i][j] = Math.max(sum[i][j], Math.max(sum[i-1][j], sum[i][j-1]));
            }
        }

        return sum[M][N];
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int k = sc.nextInt();
            if (k == 0) break;
            String s1 = sc.next();
            String s2 = sc.next();
            System.out.println(lcswithk(s1.toCharArray(), s2.toCharArray(), k));
        }
    }
}
