import java.util.*;

public class WineProblem
{
    int[] P;
    int N;
    int[][] cache;
    
    public WineProblem(int[] P)
    {
        this.P = P;
        N = P.length;
        cache = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(cache[i], -1);
        }
    }
    
    public int profit(int low, int high)
    {
        if (high < low)
            return 0;

        if (cache[low][high] != -1) {
            return cache[low][high];
        }

        int year = N - (high - low + 1) + 1;
        
        return cache[low][high] = Math.max(profit(low + 1, high) + P[low] * year,
                                           profit(low, high - 1) + P[high] * year);
    }

    public static void main(String[] args)
    {
        int[] P = {2, 3, 5, 1, 4};
        WineProblem wp = new WineProblem(P);
        System.out.println(wp.profit(0, P.length - 1));
    }
}
