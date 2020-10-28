import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[] nums = { 0 };
		List<String> result = sol.summaryRanges(nums);
		System.out.println(result);
    }

	public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<>();

		if (nums == null || nums.length == 0) {
			return result;
		}

		int prev = nums[0];
		int start = prev;
		int end = prev;
		
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == prev + 1) {
				prev = nums[i];
				continue;
			} else {
				result.add(getRange(start, prev));
				start = nums[i];				
			}
			prev = nums[i];
		}

		result.add(getRange(start, prev));
		
		return result;
    }

	String getRange(int start, int end) {
		if (start == end) {
			return start + "";
		} else {
			return start + "->" + end;
		}
	}
    
}
