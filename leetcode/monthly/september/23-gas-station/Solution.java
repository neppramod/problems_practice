import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
         
    }
    
    public int canCompleteCircuit(int[] gas, int[] cost) {
		int sumRemaining = 0;  // track current remaining
		int total = 0;   // track total remaining
		int start = 0;   // start index, we can reset

		for (int i = 0; i < gas.length; i++) {
			int remaining = gas[i] - cost[i];

			if (sumRemaining >= 0) {   // if we had some left from previous station
				sumRemaining += remaining; 
			} else {   // if not reset to current station
				sumRemaining = remaining;
				start = i;
			}

			total += remaining;   // track all cost
		}

		if (total >= 0) {
			return start;
		} else {
			return -1;
		}
    }
}
