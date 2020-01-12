import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = {555,901,482,1771};
        System.out.println(findNumbers(arr));

    }

    public static int findNumbers(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int digits = (int) Math.log10(nums[i]) + 1;
            if (digits % 2 == 0) {
                count++;
            }
        }

        return count;
    }
}
