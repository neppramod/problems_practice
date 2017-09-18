import java.util.*;

public class PairChains
{
    public static int lengthPairChains(int[][] pairs)
    {
        // sort O(nlgn)
        Arrays.sort(pairs, Comparator.comparingInt(arr -> arr[0]));
        int N = pairs.length;
        int[] sum = new int[N];
        sum[0] = 1;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0])
                    sum[i] = Math.max(sum[i-1], sum[j] + 1);
            }
        }

        return sum[N-1];
    }

    public static void main(String[] args)
    {
        int[][] pairs = new int[4][2];
        pairs[0] = new int[] {5, 6};
        pairs[1] = new int[]{2, 3};
        pairs[2] = new int[]{8, 9};
        pairs[3] = new int[]{4, 7};

        System.out.println(lengthPairChains(pairs));
    }
}
