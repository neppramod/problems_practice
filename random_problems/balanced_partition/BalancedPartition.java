import java.util.*;

public class BalancedPartition
{
    // Convert A to B
    static int minimumEdits(char[] A, char[] B)
    {
        // A goes horizonal, B vertical
        int[][] T = new int[B.length+1][A.length+1];
        
        T[0][0] = 0;
        // fill first row
        for (int i = 1; i <= A.length; i++) {
            T[0][i] = T[0][i-1] + 1;
        }
        
        // fill first col
        for (int i = 1; i <= B.length; i++) {
            T[i][0] = T[i-1][0] + 1;
        }
        
        for (int i = 1; i <= B.length; i++) {
            for (int j = 1; j <= A.length; j++) {
                
                // adjust index j-1
                if (A[j-1] == B[i-1]) {
                    T[i][j] = T[i-1][j-1];
                } else {
                    T[i][j] = Math.min(T[i-1][j], Math.min(T[i-1][j-1], T[i][j-1])) + 1;
                }
            }
        }
        
        System.out.println(Arrays.deepToString(T));
        
        return T[B.length][A.length];
    }
    
    public static void main(String[] args)
    {
        char[] A = "abcdef".toCharArray();
        char[] B = "azced".toCharArray();
        System.out.println(minimumEdits(A, B));
    }
}
