import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[] nums = {3, 2, 6, 4, 12, 8, 20};
		System.out.println(sol.lis(nums));
    }
    
    int lis(int[] nums) {
		if (nums.length == 0 || nums.length == 1) {
			return nums.length;
		}

		List<Integer> dpList = new ArrayList<>();
		int n = nums.length;

		for (int i = 0; i < n; i++) {
			if (dpList.size() == 0 || nums[i] > dpList.get(dpList.size()-1)) {
				dpList.add(nums[i]);
			} else {
				int l = 0, r = dpList.size()-1;
				while (l < r) {
					int mid = l + (r - l) / 2;
					if (dpList.get(mid) < nums[i]) {
						l = mid + 1;
					} else {
						r = mid;
					}
				}

				dpList.set(l, nums[i]);
			}
		}

		return dpList.size();
	}
}
