import java.util.*;

public class AIBOHP
{
    static int lcs(String s1, String s2)
    {
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        int M = cs1.length;
        int N = cs2.length;

        int[][] sum = new int[M+1][N+1];

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (cs1[i-1] == cs2[j-1]) {
                    sum[i][j] = sum[i-1][j-1] + 1;
                } else {
                    sum[i][j] = Math.max(sum[i-1][j], sum[i][j-1]);
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
            String s1 = sc.next();
            String s2 = new StringBuilder(s1).reverse().toString();
            int maxpal = s1.length() - lcs(s1, s2);
            System.out.println(maxpal);
        }
    }
}
