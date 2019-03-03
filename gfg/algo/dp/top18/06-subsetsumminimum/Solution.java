/*
  SubSet Sum minimum

  Divide a set into two subsets, such that abosolute difference between the sums of two subsets is minimum

  E.g. A = {4,2,3,6,3} = 0

*/

public class Solution
{
    public static void main(String[] args)
    {
        int[] A = {4,2,3,6,3};
        System.out.println(getMinDiff(A));
    }

    static int getMinDiff(int[] A)
    {
        int totalSum = 0;
        int N = A.length;
        for (int i = 0; i < N; i++) {
            totalSum += A[i];
        }

// At each state, we find current sum and use that to subtract from total
        return getMinRec(A, N, 0, totalSum);
    }

    static int getMinRec(int[] arr, int N, int currentSum, int totalSum)
    {
        if (N == 0) {
            return Math.abs(totalSum - currentSum - currentSum);
        }

        return Math.min(getMinRec(arr,N-1,currentSum,totalSum), getMinRec(arr,N-1,currentSum+arr[N-1], totalSum));
                        }
    }
