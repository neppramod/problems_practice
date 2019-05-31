import java.util.*;

public class SmallestDifference
{
    static int findMinDiff(int[] a1, int[] a2)
    {
	Arrays.sort(a1);
        Arrays.sort(a2);

        int n1 = a1.length;
        int n2 = a2.length;

        int i = 0, j = 0;
        int min = Integer.MAX_VALUE;
        while (i < n1  && j < n2) {
            int diff = Math.abs(a1[i]-a2[j]);
            if (diff < min) min = diff;

            int diff1 = Integer.MAX_VALUE;
            if (i+1 < n1) {
                diff1 = Math.abs(a1[i+1]-a2[j]);
            }
            int diff2 = Integer.MAX_VALUE;
            if (j+1 < n2) {
                diff2 = Math.abs(a1[i] - a2[j+1]);
            }

            if (diff1 < diff2) {
                i++;
            } else {
                j++;
            }
        }

        return min;
    }

    public static void main(String[] args)
    {
        int[] a1 = {1,2,3,11,15};
        int[] a2 = {8,19,23,127,235};
        int min = findMinDiff(a1, a2);

        System.out.println("Min: " + min);

    }
}
