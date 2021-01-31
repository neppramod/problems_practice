import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();
		int target = 2;
		int res = sol.reachNumber(3);
		System.out.println(res);
	}

	
    public int reachNumber(int target) {
		target = Math.abs(target);
		int steps = 0;
		int sum = 0;

		while (sum < target) {
			steps++;
			sum += steps;
		}

		while ((sum - target) % 2 != 0) {
			steps++;
			sum += step;
		}

		return step;
    }

	/*
	  target = 5, steps = 0, sum = 0
	  steps = 1, sum = 1
	  steps = 2, sum = 3
	  steps = 3, sum = 6
	  
	  6 - 5 % 2 != 0:
	      steps = 4, sum = 10
	  10 - 5 % 2 != 0:
	      steps = 5, sum = 15
	  15 - 5 % 2 == 0: return 5
	
	
	  target = 3
	  steps = 1, sum = 1
	  steps = 2, sum = 3
	  
	  3 - 3 % 2 == 0, return 2
	
	  target = 2
	  steps = 1, sum = 1
	  steps = 2, sum = 3
	  3-2 % 2 != 0:
	     steps = 3, sum = 6
	  6 - 2 % 2 == 0: return 3
	 */
}
