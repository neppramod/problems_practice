// Subsequence of consecutive elements evenly divisible by k
/**
   Algorithm:
   L(j) = Number of subsequence evenly divisible by k

   Solution described in
   http://www.mii.lt/olympiads_in_informatics/pdf/INFOL062.pdf 
 */
 
import java.util.*;
 
public class KSubsequences
{
    static int numberofSubsequence(int[] A, int k)
    {
        if (A == null || A.length == 0 || k <= 0)
            return 0;
        
        int N = A.length;
        int[] sum = new int[N];   // build consecutive sum
        int[] rem = new int[N];   // get sum % k at i

        sum[0] = A[0];
        rem[0] = A[0] % k;
        
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i-1] + A[i];
            rem[i] = sum[i] % k;
        }

        // build count of rem that are common
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int cur = rem[i];
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) + 1);
            } else {
                map.put(cur, 1);
            }
        }

        int maxsum = 0;
        for (int key : map.keySet()) {
            int k1 = map.get(key);
            maxsum += (k1 * (k1-1)) / 2;
        }

        return maxsum;
    }

    public static void main(String[] args)
    {
        int[] A = {1, 1, 9, 7, 12, 4, 12, 5, 8, 2, 7, 2, 10, 2, 3};
        System.out.println(numberofSubsequence(A, 13));
    }
}
