import java.util.*;

public class Permutation {
    public static void main(String[] args) {
	    Permutation sol = new Permutation();
		int[] nums = { 1, 1, 2 };
		List<List<Integer>> result = sol.permuteUnique(nums);
		for (List<Integer> r : result) {
			System.out.println(r);
		}
	}
	
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
		
		permutationsUnique(nums, result, 0);

		return result;
    }

	void permutationsUnique(int[] nums, List<List<Integer>> result, int start) {
		if (start == nums.length-1) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int n : nums) {
				list.add(n);
			}
			result.add(list);
			return;
		} else {
			HashSet<Integer> set = new HashSet<>();
			
			for (int i = start; i < nums.length; i++) {
				if (set.contains(nums[i])) {
					continue;
				}
				
				set.add(nums[i]);
				swap(nums, i, start);
				permutationsUnique(nums, result, start + 1);
				swap(nums, i, start);
			}
		}
	}

	void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}

