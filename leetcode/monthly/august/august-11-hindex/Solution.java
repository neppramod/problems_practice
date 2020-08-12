import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[] citations = { 3, 0, 6, 1, 5 };
		int result = sol.hIndex(citations);
		System.out.println(result);
    }
    
    public int hIndex(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int n = nums.length;
		int count = 1;
		int answer = 0;

		Arrays.sort(nums);

		for (int i = n-1; i >= 0; i--) {
			if (nums[i] >= count) {
				answer++;
			} else {
				break;
			}
			count++;
		}

		return answer;
	}
}
