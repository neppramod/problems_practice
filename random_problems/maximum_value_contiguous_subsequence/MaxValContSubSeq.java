/**
 * Input Array: A[1..n] of numbers
 * We have to find Max(Sum(A[i..j])), i..j is a window
 * M(j) = Max sum over all possible windows ending at j
 * M(j) can be defined with following formulat
 * 
 * M(j) = Max { M(j-1) + A[j], A[j]}
 * 
 * What does above formula mean.
 * In a formal definition way:
 * To find the optimal window at position j, either extend the optimal window 
 * ending at j-1 or start new if the previous optimal value is not optimal 
 * anymore
 * 
 * In a simple terms above formula means, if sum of previous values + value of 
 * current element is not even greater than current element, why choose 
 * the sum over current greter element.
 * 
 * When does this scenario arise.
 * This scenario arises, if the sum was negative, because anything that is 
 * greater will make A[j] + that old sum bigger than A[j] itself.
 * 
 * Example:
 * A[n] = {7, -8, 4, -3, 4, 6, -2}
 * We are going to build M[n] using A[n]
 * For M[0] we can just use A[0],
 * we can track max also using a variable just like in code below, but not 
 * needed for this example
 *
 * M[0] = 7
 * M[1] = Max (M[0] + A[1], A[1])
 * Just like descibed above, I am going to use previous sum of M[0] only 
 * if it makes my new sum bigger. That happens only when M[0] is either 
 * 0 or greater
 * Therefore, M[1] = -1, because 7-8 is bigger than -8, right ?
 * 
 * M[2] = Max (M[1] + A[2], A[2])
 * M[2] = Max (-1 + 4, 4) = 4, because 4 is obviously bigger than 3, right?
 * Similarly,
 * M[3] = 1  : Max(4-3, -3)
 * M[4] = 5  : Max(1+4, 4)
 * M[5] = 11 (Max) : Max(5+6, 6)
 * M[6] = 9 : Max(11-2, -2)
 * Therefore, the max sequence is from index 2 to index 5 with sum of 11
 * 
 * Time complexity: O(n), Space complexity: O(n)
 */

public class MaxValContSubSeq
{
    public static int maxLength(int[] A)
    {
        if (A == null || A.length == 0)
            return 0;
        
        int max = 0;
        
        // Build bottom-up memory to reduce calculation
        int[] M = new int[A.length];   // Space of O(n)
        M[0] = A[0];

        for (int j = 1; j < A.length; j++) {   // Time complexity of O(n)
            M[j] = Math.max(M[j-1] + A[j], A[j]);
            
            if (M[j] > max)
                max = M[j];
        }

        return max;
    }

    public static void main(String[] args)
    {
        int[] A = {7, -8, 4, -3, 4, 6, -2};
        System.out.println(maxLength(A));
    }
}
