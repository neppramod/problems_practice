import java.util.*;

public class MinCoins
{
    public static int min(int[] v, int N)
        {
            int V = v.length;
            int[] sum = new int[N+1];
            sum[0] = 0;

            for (int i = 1; i <= N; i++) {
                int min_value = Integer.MAX_VALUE;
                for (int j = 0; j < V; j++) {
                    if (i - v[j] >= 0) {
                        min_value = Math.min(min_value, sum[i - v[j]] + 1);
                        // if v[j] is in ascending order, following would also work
                        //sum[i] = sum[i-v[j]] + 1;
                    }
                }
                sum[i] = min_value;
            }

            return sum[N];
        }

    public static void main(String[] args)
        {
            int[] v = {5, 1, 3};
            System.out.println(min(v, 11));
        }
}
