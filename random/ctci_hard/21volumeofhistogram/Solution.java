import java.util.*;

/*
  Volume of Histogram
*/
public class Solution
{
    private static int computeHG(int[] hst)

    {

        int[] maxLeft = new int[hst.length];

        int maxLeftItem = hst[0];

        for (int i = 0; i < hst.length; i++) {

            maxLeftItem = Math.max(maxLeftItem, hst[i]);

            maxLeft[i] = maxLeftItem;

        }



        int maxRight = hst[hst.length-1];

        int sum = 0;

        for (int i = hst.length - 1; i >= 0; i--) {

            maxRight = Math.max(hst[i], maxRight);

            int secondTallest = Math.min(maxRight, maxLeft[i]);

            if (secondTallest > hst[i])

                sum += (secondTallest - hst[i]);

        }



        return sum;

    }



    private static int computeHGRec(int[] hst)

    {

        int start = 0;

        int end = hst.length - 1;



        int max = findIndexOfMax(hst, start, end);

        int leftVolume = subgraphVolume(hst, start, max, true);

        int rightVolume = subgraphVolume(hst, max, end, false);



        return leftVolume + rightVolume;

    }



    private static int findIndexOfMax(int[] hst, int start, int end)

    {

        int maxIndex = start;

        for (int i = start + 1; i <= end; i++) {

            if (hst[i] > hst[maxIndex]) maxIndex = i;

        }



        return maxIndex;

    }



    private static int subgraphVolume(int[] hst, int start, int end, boolean isLeft)

    {

        if (start >= end) return 0;

        int sum = 0;

        if (isLeft) {

            int max = findIndexOfMax(hst, start, end-1);

            sum += borderedVolume(hst, max, end);

            sum += subgraphVolume(hst, start, max, isLeft);

        } else {

            int max = findIndexOfMax(hst, start+1, end);

            sum += borderedVolume(hst, start, max);

            sum += subgraphVolume(hst, max, end, isLeft);

        }



        return sum;

    }



    private static int borderedVolume(int[] hst, int start, int end)

    {

        if (start >= end) return 0;

        int min = Math.min(hst[start], hst[end]);

        int sum = 0;

        for (int i = start + 1; i < end; i++) {

            sum += (min - hst[i]);

        }



        return sum;

    }



    public static void main(String[] args)

    {

        int[] hst = {0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 8, 0, 2, 0, 5, 2, 0, 3, 0, 0};

        System.out.println(computeHG(hst));

        System.out.println(computeHGRec(hst));

    }
}
