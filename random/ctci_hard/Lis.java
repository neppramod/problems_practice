import java.util.*;

public class Lis
{
    public static void main(String[] args) {
        int[] A = new int[] {3, 10, 2, 1, 20};
        int[] memo = new int[A.length];
        System.out.println(lis(A, 0, memo));
    }

    static int lis(int[] A, int cur, int[] memo)
    {
        int N = A.length;
        if (cur >= N) return 0;  // could return new list also
        if (memo[cur] > 0) return memo[cur];

        int max = 0;

        for (int i = cur + 1; i < N; i++) {
            if (A[i] > A[cur]) {
                int now = lis(A, i, memo);
                max = Math.max(now, max);
            }
        }

        return max + 1;
    }
}
