/**
   Longest Increasing Subsequence
   Input: Sequence A1 ... An
   Goal: Find a longest strictly increasing subsequence (not necessarily contiguous)

   L(j) = Longest strictly increasing subsequence ending at position j
   L(j) = for: i < j, L(i) = max count of numbers where A[i] < A[j]
   L(j) = Max ( when A[i] < A[j] { L(i) }) + 1

   O(n2), there is another equation that can be solved in O(nlogn)

   A: 3, 5, -2, -7, 7, 8, 9, 12, -5, 15, 6
   L: 1, 2,  1,  1, 3, 4, 5, 6,   2, 7,  3
 */

import java.util.*;

public class LongIncSubseq
{
    static int longestIncreasingSubsequence(int[] A)
    {
        int[] L = new int[A.length];
        L[0] = 1;

        for (int j = 1; j < A.length; j++) {
            int max = 0;

            for (int i = 0; i < j; i++) {
                if (A[i] < A[j]) {
                    max = Math.max(max, L[i]);
                }
            }

            L[j] = max + 1;
        }
        System.out.println(Arrays.toString(L));

        int max = L[0];
        for (int i = 1; i < L.length; i++) {
            max = Math.max(max, L[i]);
        }

        return max;
    }

    public static void main(String[] args)
    {
        int[] A = {3, 5, -2, -7, 7, 8, 9, 12, -5, 15, 6};
        System.out.println(longestIncreasingSubsequence(A));
    }
}
