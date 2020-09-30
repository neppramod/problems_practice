import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[] arr = { 1, 2};
		List<Integer> result = sol.majorityElement(arr);
		System.out.println(result);
    }
    
    public List<Integer> majorityElement(int[] nums) {
		List<Integer> result = new ArrayList<>();

		if (nums == null || nums.length == 0) {
			return result;
		}

		int c1 = 0, c2 = 0;
		Integer n1 = null, n2 = null;

		for (int n : nums) {
			if (n1 != null && n == n1.intValue()) {
				c1++;
			} else if (n2 != null && n == n2.intValue()) {
				c2++;
			} else if (c1 == 0) {
				n1 = n;
				c1 = 1;
			} else if (c2 == 0) {
				n2 = n;
				c2 = 1;
			} else {
				c1--;
				c2--;
			}
		}

		//System.out.println("C1: " + c1 + ", C2: " + c2);
		c1 = c2 = 0;

		for (int n : nums) {
			if (n1 != null && n == n1.intValue()) {
				c1++;
			}

			if (n2 != null && n == n2.intValue()) {
				c2++;
			}
		}

		double moreThanThree = ((double) nums.length / 3.0);
		// System.out.println("MOre Than Three: " + moreThanThree);

		if (c1 > moreThanThree) {
			result.add(n1.intValue());
		}

		if (c2 > moreThanThree) {
			result.add(n2.intValue());
		}

		return result;
    }
}
