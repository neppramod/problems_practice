import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Solution sol = new Solution();

        int arr[] = {1,8,6,2,5,4,8,3,7};

        /*
          j = 1, i = 8
          7 * (8 - 1) = 7 * 7 = 49
         */

        int result = sol.maxArea(arr);

        System.out.println(result);
    }

    public int maxArea(int[] height) {
        int maxVal = 0;
        int N = height.length;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                int maxHeight = Math.min(height[j], height[i]);
                int val = maxHeight * (i-j);
                maxVal = Integer.max(val, maxVal);
            }
        }

        return maxVal;
    }
}
