import java.util.*;

public class LongestIncreasingSequence
{

    static int longestsequence(int[] A)
    {
        if (A == null || A.length == 0)
            return 0;
        int[] L = new int[A.length];
        L[0] = 1;

        int max = 1;

        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i-1]) {
                L[i] = L[i-1] + 1;
                max = Math.max(max, L[i]);
            } else {
                L[i] = 1;
            }
        }

        return max;         
    }

    public static void main(String[] args)
    {
        int[] A = {5, 8, 2, 7, 9, 10, 14, 3, 6, 4};        
        int x = longestsequence(A);
        System.out.println(x);
    }
}
