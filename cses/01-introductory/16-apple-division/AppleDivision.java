import java.util.*;

public class AppleDivision {
    public static void main(String[] args) {
	    AppleDivision sol = new AppleDivision();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] nums = new long[n];
		long totalSum = 0;
		
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextLong();
			totalSum += nums[i];
		}

		long result = sol.minimumDifference(nums, 0, 0, totalSum);
		System.out.println(result);
	}


	// recursive sum
	// subset sum problem
	// when at the end return abs difference between totalSum - curSum (1st set) and
	// curSum (2nd set)
	// Else recursively return min of either including current element in curSum or not
	
	long minimumDifference(long[] nums, int index, long curSum, long totalSum) {
		if (index == nums.length) {
			return Math.abs(totalSum - 2 * curSum);
		} else {
			return Math.min(minimumDifference(nums, index + 1, curSum + nums[index], totalSum), minimumDifference(nums, index + 1, curSum, totalSum));
		}
	}
}
