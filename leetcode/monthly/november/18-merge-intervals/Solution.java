import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();
		//		int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		int[][] intervals = { { 1, 4 }, { 4, 5 } };
		int[][] result = sol.merge(intervals);

		for (int[] intv : result) {
			System.out.print(intv[0] + " : " + intv[1] + ", ");
		}
		System.out.println();
	}
	
    public int[][] merge(int[][] intervals) {
		if (intervals == null || intervals.length == 0) {
			return null;
		}

		int n = intervals.length;

		Arrays.sort(intervals, new Comparator<int[]>(){
				public int compare(int[] entry1, int[] entry2) {
					if (entry1[0] != entry2[0]) {
						return entry1[0] - entry2[0];
					} else {
						return entry1[1] - entry2[1];
					}
				}
		});

		int[] prev = intervals[0];
		List<int[]> outputList = new ArrayList<>();

		for (int i = 1; i < n; i++) {
			int[] cur = intervals[i];

			if (cur[0] <= prev[1]) {
				prev[1] = Math.max(prev[1], cur[1]);
			} else if (cur[0] > prev[1]) {
				outputList.add(prev);
				prev = cur;
			} else if (cur[1] < prev[1]) {
				continue;
			}
		}

		outputList.add(prev);

		int[][] result = new int[outputList.size()][2];
		for (int i = 0; i < outputList.size(); i++) {
			result[i] = outputList.get(i);
		}

		return result;
    }
}
