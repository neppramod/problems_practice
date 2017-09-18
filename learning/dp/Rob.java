import java.util.*;

public class Rob
{
    public static int maxrob(int[] p)
    {
        int N = p.length;
        int[] sum = new int[N + 1];
        sum[0] = 0;
        sum[1] = p[0];

        for (int i = 2; i <= N; i++) {
            sum[i] = Math.max(sum[i-2] + p[i-1], sum[i-1]);
        }

        return sum[N];
    }

    public static void main(String[] args)
    {
        int[] prices = {5, 8, 2, 9, 7, 6};
        System.out.println(maxrob(prices));
        System.out.println(maxrob(new int[] {1,2,3,4,5}));
    }
}
