import java.util.*;

public class SmallestDifferenceRec
{

    private static int findMinDiff(int[] a1, int[] a2)
    {
        Arrays.sort(a1);
        Arrays.sort(a2);
        return findMinDiffUtil(a1, a2, 0, 0);
    }

    private static int findMinDiffUtil(int[] a1, int[] a2, int i, int j)
    {
        int m = a1.length;
        int n = a2.length;

        if (i == m || j == n) return Integer.MAX_VALUE;
        int diff = Math.abs(a1[i] - a2[j]);
        int diff1 = findMinDiffUtil(a1, a2, i+1, j);
        int diff2 = findMinDiffUtil(a1, a2, i, j+1);
        diff = Math.min(diff, diff1);
        diff = Math.min(diff, diff2);
        return diff;
    }

    public static void main(String[] args)
    {
        int[] a1 = {1,2,3,11,15};
        int[] a2 = {8,19,23,127,235};
        int min = findMinDiff(a1, a2);

        System.out.println("Min: " + min);
    }
}
