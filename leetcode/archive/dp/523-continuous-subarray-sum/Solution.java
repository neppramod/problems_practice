import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        int[] arr = {23, 3, 5, 6, 7};
        int k = 6;
        System.out.println(sol.checkSubarraySum(arr, k));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }

        int[] prefix = new int[n+1];
        prefix[0] = 0;
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i-1] + nums[i-1];
        }



        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i-2; j++) {
                int diff = prefix[i] - prefix[j];
                if (diff == 0 && k == 0) {
                    return true;
                } else if (k != 0 && diff % Math.abs(k) == 0) {
                    return true;
                }

            }
        }

        return false;
    }

}
