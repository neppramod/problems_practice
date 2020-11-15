import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();
		int[][] intervals = { { 0, 2 }, { 3, 4 }, { 5, 7 } };
		List<List<Integer>> result = sol.removeInterval(intervals, new int[] {1, 6});
		for (List<Integer> r : result) {
			System.out.println(r);
		}
	}
	
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {

		List<List<Integer>> list = new ArrayList<>();
		
		if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
			return list;
		}   


		for (int[] interval : intervals) {
			if (interval[1] <= toBeRemoved[0] || interval[0] >= toBeRemoved[1]) {
				list.add(Arrays.asList(interval[0], interval[1]));
			} else if (interval[0] < toBeRemoved[0] && interval[1] > toBeRemoved[1]) {
				ArrayList<Integer> list1 = new ArrayList<>();
				list1.add(interval[0]);
				list1.add(toBeRemoved[0]);
				list.add(list1);

				list1 = new ArrayList<>();
				list1.add(toBeRemoved[1]);
				list1.add(interval[1]);
				list.add(list1);
				
			} else if (interval[0] < toBeRemoved[0] && interval[1] <= toBeRemoved[1]) {
				list.add(Arrays.asList(interval[0], toBeRemoved[0]));
			} else if (interval[0] >= toBeRemoved[0] && interval[1] > toBeRemoved[1]) {
				list.add(Arrays.asList(toBeRemoved[1], interval[1]));
			}
		}

		return list;
    }
}
