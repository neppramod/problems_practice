import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[][] intervals = {{1, 2}, {1, 4}, {3, 4}};
		int result = sol.removeCoveredIntervals(intervals);
		System.out.println(result);
    }
    
    public int removeCoveredIntervals(int[][] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}

		Arrays.sort(intervals, new Comparator<int[]>(){
			public int compare(int[] a, int[] b) {
				if (a[0] != b[0]) {
					return a[0] - b[0];
				} else {
					return a[1] - b[1];
				}
			}
		});

		List<int[]> intervalList = new ArrayList<>();
		intervalList.add(intervals[0]);
		
		int count = 0;
		for (int i = 1; i < intervals.length; i++) {
			int[] curintv = intervals[i];
			int[] lastintv = intervalList.get(intervalList.size()-1);

			if (covered(lastintv, curintv)) {
				intervalList.remove(intervalList.size()-1);
				intervalList.add(curintv);
			} else if (!covered(curintv, lastintv)) {
				intervalList.add(curintv);
			}
		}

		/*
		for (int[] intv : intervalList) {
			System.out.println(Arrays.toString(intv));
		}
		*/

		return intervalList.size();
    }

	// check if a is covered in b
	boolean covered(int[] a, int[] b) {
		return b[0] <= a[0] && a[1] <= b[1];
	}
}
