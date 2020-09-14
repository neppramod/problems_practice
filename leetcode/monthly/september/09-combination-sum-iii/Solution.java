import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int k = 3;
		int n = 9;
		List<List<Integer>> result = sol.combinationSumIII(k, n);
		System.out.println(result);
    }
    
    List<List<Integer>> combinationSumIII(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();

		List<Integer> curList = new ArrayList<>();

		helper(result, curList, k, 1, n);
		
		return result;
	}

	void helper(List<List<Integer>> result, List<Integer> curList, int k, int start, int sum) {
		if (sum < 0) {
			return;
		} else if (sum == 0 && curList.size() == k) {
			result.add(new ArrayList<>(curList));
			return;
		} else {
			for (int i = start; i <= 9; i++) {
				curList.add(i);
				helper(result, curList, k, i + 1, sum - i);
				curList.remove(curList.size() - 1);
			}
		}
	}
}
