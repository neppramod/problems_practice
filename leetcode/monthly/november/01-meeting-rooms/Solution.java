import java.util.*;

public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
	int[][] intervals = { { 7, 10 }, { 2, 4 } };
	System.out.println(sol.canAttendMeetings(intervals));

    }

    public boolean canAttendMeetings(int[][] intervals) {

	// Sort by start time
	Arrays.sort(intervals, (a, b) -> {
		return a[0] - b[0];
	});

	int n = intervals.length;
	
	for (int i = 0; i < n-1; i++) {
	    if (intervals[i][1] > intervals[i + 1][0]) {
			return false;
	    }
	}

	return true;
    }
}
