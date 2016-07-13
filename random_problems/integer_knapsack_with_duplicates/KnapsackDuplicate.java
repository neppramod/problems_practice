import java.util.*;

public class KnapsackDuplicate
{
    static int maxSum(int[] s, int[] v, int target)
    {
        int[] M = new int[target + 1];
        M[0] = 0;

        for (int j = 1; j <= target; j++) {
            int max = M[j-1];

            for (int i = 0; i < s.length; i++) {
                if (j - s[i] >= 0) {
                    max = Math.max(max, M[j-s[i]] + v[i]);
                }
            }

            M[j] = max;
        }

        System.out.println(Arrays.toString(M));

        return M[target];
    }

    public static void main(String[] args)
    {
        int[] s = {1, 2, 4, 7};
        int[] v = {1, 2, 5, 6};
        int capacity = 12;

        System.out.println(maxSum(s, v, capacity));
    }
}
