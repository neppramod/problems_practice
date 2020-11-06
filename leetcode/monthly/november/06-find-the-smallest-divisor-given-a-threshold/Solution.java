import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] arr = {2, 3, 5, 7, 11};
		int threshold = 11;

		int res = sol.smallestDivisor(arr, threshold);
		System.out.println(res);

	}

	/*
	public int smallestDivisor(int[] nums, int threshold) {
		int max_number = 1000000;
		
		for (int i = 1; i <= max_number; i++) {
			int res = getResult(nums, threshold, i);
			if (res <= threshold) {
				return i;
			}
		}

		return -1;
    }

	public int getResult(int[] nums, int threshold, int divisor) {
		double sum = 0.0;

		for (int n : nums) {
			sum += Math.ceil((double) n / (double)divisor); 
		}

		return (int) sum;
	}

	*/

	public int smallestDivisor(int[] nums, int threshold) {
		int max_number = 1000000;
        
        int low = 1, high = max_number;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            int res = getResult(nums, threshold, mid);
            
            if (res <= threshold) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
		
		return high;
    }

	public int getResult(int[] nums, int threshold, int divisor) {
		double sum = 0.0;

		for (int n : nums) {
			sum += Math.ceil((double) n / (double)divisor); 
		}

		return (int) sum;
	}
}
