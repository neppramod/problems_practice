import java.util.*;

public class DistinctNumbers {
    public static void main(String[] args) {
	    DistinctNumbers sol = new DistinctNumbers();
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] nums = new int[n];

		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}

		int result = sol.distinctValues(nums);
		System.out.println(result);
	}
	
    public int distinctValues(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}

		return map.size();
	}
}
