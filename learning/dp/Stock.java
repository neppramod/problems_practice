import java.util.*;
public class Stock
{
    public static int max_profix(int[] p)
    {
        int cur_max = 0;
        int min_value = p[0];
        int N = p.length;
        for (int i = 1; i < N; i++) {
            min_value = Math.min(min_value, p[i]);
            cur_max = Math.max(cur_max, p[i] - min_value);
        }

        return cur_max;
    }

    public static void main(String[] args)
    {
        int[] p = {5, 8, 9, 7, 6};
        System.out.println(max_profix(p));
    }
}
