import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();
		int[] arr = {-1, 4, 9, 7, 7, 2, 7, 3, 0, 9, 6, 5, 7, 8, 9};
		int result = sol.findRandomIndexOfMax(arr);
		System.out.println(result);
	}
	
    public int findRandomIndexOfMax(int arr[]) {
		// we will use map of int, list to save elemnt and their indices
		// if there are more than one max, it only picks the first one as max, not the combined of both

		if (arr == null || arr.length == 0) {
			return -1;
		}

		Map<Integer, List<Integer>> map = new HashMap<>();
		int n = arr.length;

		int maxFreq = Integer.MIN_VALUE;
		int maxElement = -1;
		
		for (int i = 0; i < n; i++) {
			int key = arr[i];
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<Integer>());
			}

			map.get(key).add(i);

			if (map.get(key).size() > maxFreq) {
				maxFreq = map.get(key).size();
				maxElement = key;
			}
		}

		if (maxElement == -1) {
			return -1;
		}
		
		Random r = new Random();
		int rIndex = r.nextInt(maxFreq);

		return map.get(maxElement).get(rIndex);
	}
}
