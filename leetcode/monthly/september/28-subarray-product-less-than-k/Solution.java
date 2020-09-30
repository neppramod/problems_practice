import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();

		int[] nums = {1, 1, 1};
		int k = 1;

		int result = sol.numSubarrayProductLessThanK(nums, k);
		System.out.println(result);
         
    }
    
    /*
a = [1, 2, 3, 4], k = 10

s = e = res = 0
p = 1

for e = 0; e < n; e++:
   p = p * a[e]

   while s < e and p >= k:
       p = p / a[s];
	   s = s + 1;

   if p < k:
       len = e - s  + 1
	   res = res + len

return res;


[1, 2]
e = 0, p = 1
1 < 10, len = 0 - 0 + 1 = 1, res = 1

e = 1, p = 2, 0 < 1 and 2 >= k (X)
if (2 < 10): len = 1 - 0 + 1, res = 1 + 2 = 3

e = 2, 2 < n
p = 6, 0 < 2 and 6 >= 10 (X)
p < 10: len = 2 - 0 + 1, res = 3 + 3 = 6

e = 3, 3 < n
p = 24, 0 < 3 and 24 >= 10: p = p / a[0] => p = 24, s = 1
1 < 3 and 24 >= 10, p = 12, s = 2
2 < 3 and 12 >= 10: p = 4, s = 3

4 < 10: len = 3 - 3 + 1 = 1, res = 6 + 1 = 7

	 */


	public int numSubarrayProductLessThanK(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k == 0) {
			return 0;
		}

		int start = 0;  // window start
		int length = 0;  // current length of valid subarray
		int result = 0;   // final result
		int p = 1;   // product
		int n = nums.length;  

		for (int i = 0; i < n; i++) {
			p = p * nums[i];

			while (start < i && p >= k) {
				p /= nums[start];
				start++;
			}

			if (p < k) {
				length = i - start + 1;
				result += length;
			}
		}

		return result;
    }
}
