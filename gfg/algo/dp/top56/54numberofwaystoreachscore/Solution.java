import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] S = {3, 5, 10};

        //System.out.println(getWays(S, S.length, N));
        System.out.println(getWaysDP(S, S.length, N));
    }

    static int getWays(int[] S, int M, int N)
    {
        if (M == 0) return 0;
        if (N < 0) return 0;
        if (N == 0) return 1;

        // Get sum using all coins (from previous sum) + sum using one less coin
        return getWays(S, M, N-S[M-1]) + getWays(S, M-1, N);
    }

    static int getWaysDP(int[] S, int M, int N)
    {
        int[] table = new int[N+1];
        Arrays.fill(table, 0);
        table[0] = 1;
        for (int i = 0; i < M; i++) {
            for (int j = S[i]; j <= N; j++) {
                table[j] += table[j-S[i]];
            }
        }

        return table[N];
    }

}
