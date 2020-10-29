import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[] seats = { 0, 1, 0, 0, 0, 0 };
		int result = sol.maxDistToClosest(seats);
		System.out.println(result);
    }


	public int maxDistToClosest(int[] seats) {
        // Put occupied seats in a TreeSet
		// For each index find upper and lower
		// find difference between upper and lower / 2, maximize it
		TreeSet<Integer> treeSet = new TreeSet<>();
		int n = seats.length;
		for (int i = 0; i < n; i++) {
			if (seats[i] == 1) {
				treeSet.add(i);
			}
			
		}


		int maxDistance = 1;

		for (int i = 0; i < n; i++) {

			// if current seat is occumpied, look somewhere else
			if (seats[i] == 1) {
				continue;
			}
			
			Integer lower = treeSet.lower(i);
			Integer higher = treeSet.higher(i);



			if (lower == null) {
				lower = 0;
			}

			if (higher == null) {
				higher = n - 1;
			}

		   
			int curDistance = (higher - lower) / 2;
			maxDistance = Math.max(maxDistance, curDistance);
			
		}

		if (seats[0] == 0) {
			Integer upper = treeSet.higher(0);
			int diff = upper - 0;
			maxDistance = Math.max(maxDistance, diff);
		}

		if (seats[n-1] == 0) {
			Integer lower = treeSet.lower(n - 1);
			int diff = n - 1 - lower;
			maxDistance = Math.max(maxDistance, diff);
		}

		

		return maxDistance;
    }
    
}
