/*
  Non-overlapping Intervals

Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping


1. Sort intervals by first value

[[1, 2], [2, 3], [3, 4], [1, 3]]
[[1, 2],[1, 3][2, 3], [3, 4]]

1. Since second one is overlapping with first, remove it, count it

 */

import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[][] arr = {{1, 2}, {2, 3}};
		int result = sol.eraseOverlapIntervals(arr);
		System.out.println(result);
    }

	public int eraseOverlapIntervals(int[][] intervals) {
        		if (intervals == null || intervals.length == 0) {
			return 0;
		}

        // Sort by ending time
		Arrays.sort(intervals, (a, b) -> {
			if (a[1] != b[1]) {
				return a[1] - b[1];
			} else {
				return a[0] - b[0];
			}
		});

		// Find all non-overlapping intervals
		int count = 0;
		int currentEnd = Integer.MIN_VALUE;
		for (int[] interval : intervals) {
			if (interval[0] >= currentEnd) {
				count++;
				currentEnd = interval[1]; 
			}
		}


		return intervals.length - count;
    }

}
