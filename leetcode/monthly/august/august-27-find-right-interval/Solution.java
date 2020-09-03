import java.util.*;

public class Solution
{
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] arr = { { 1, 4 }, { 2, 3 }, { 3, 4 } };
		int[] result = sol.findRightInterval(arr);
		System.out.println(Arrays.toString(result));
	}

	public int[] findRightInterval(int[][] intervals) {
		if (intervals == null || intervals.length == 0) {
			return new int[] {};
		}

		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		int n = intervals.length;

		for (int i = 0; i < n; i++) {
			treeMap.put(intervals[i][0], i);
		}

		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			Integer c = treeMap.ceilingKey(intervals[i][1]);

			if (c != null) {
				result[i] = treeMap.get(c);
			} else {
				result[i] = -1;
			}

		}

		return result;

	}


}
