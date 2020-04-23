import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        int[] A = {1, 2, 1};
        int res = removeDuplicates(A);
        System.out.println(Arrays.toString(A));
        System.out.println(res);

    }

    /*
      A = [1, 2, 1]
      ans: length = 2,
      A = [1,2,2]

      2 pointers, copy element from second to first
duplicates allowed max 2
     */

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int i = 0;
        int j = 0;
        while (j < n) {
            while (j + 2 < n && nums[j+2] == nums[j]) {
                j++;
            }

            nums[i] = nums[j];
            j++;
            i++;

        }

        return i;
    }

}
