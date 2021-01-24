import java.util.*;

public class MissingNumber {
    public static void main(String[] args) {
	    MissingNumber sol = new MissingNumber();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n-1];
		for (int i = 0; i < n-1; i++) {
			nums[i] = sc.nextInt();
		}

		System.out.println(sol.missingNumber(n, nums));
	}
	
    public int missingNumber(int n, int[] nums) {

		int i = 1;
		int result = 0;
		for (int num : nums) {
			result ^= i;
			result ^= num;
			i++;
		}

		result ^= n;

		return result;
	}
}
