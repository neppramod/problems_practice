import java.util.*;

public class Solution
{
    public static int smallestMinDifferenceBF(int[] array1, int[] array2)
    {
        int minDiff = Integer.MAX_VALUE;
        for (int a : array1) {
            for (int b : array2) {
                minDiff = Math.min(minDiff, Math.abs(a-b));
            }
        }

        return minDiff;
    }

    public static int smallestMinDifferenceWithSorting(int[] array1, int[] array2)
    {
        int minDiff = Integer.MAX_VALUE;
        int i = 0, j = 0;

        Arrays.sort(array1);
        Arrays.sort(array2);

        while (i < array1.length && j < array2.length) {
            minDiff = Math.min(minDiff, Math.abs(array1[i] - array2[j]));

            //if (i + 1 < array1.length && Math.abs(array1[i+1] - array2[j]) < minDiff) {
            if (array1[i] < array2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return minDiff;
    }

    public static void main(String[] args)
    {
        int[] array1 = {1069, 3227, 2017, 2851, 2538, 2725, 1994, 3031, 2843, 3723};
        int[] array2 = {4824, 1916, 902, 2516, 1775, 1717, 2624, 3988, 1876, 2259};
        System.out.println(smallestMinDifferenceBF(array1, array2)); // 2
        System.out.println(smallestMinDifferenceWithSorting(array1.clone(), array2.clone()
                                                               )); // 2
    }
}
