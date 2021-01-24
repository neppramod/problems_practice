import java.util.*;

public class IncreasingArray {
    public static void main(String[] args) {
	    IncreasingArray sol = new IncreasingArray();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] nums = new long[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextLong();
		}

		System.out.println(sol.increasingArray(n, nums));
	}

	public long increasingArray(int n, long[] nums) {
		long moves = 0;
		long curMax = 0;

		for (int i = 0; i < n; i++) {
			if (nums[i] < curMax) {
				moves += Math.abs(nums[i] - curMax);
			} else {
				curMax = nums[i];
			}
		}

		return moves;
	}
    
}
