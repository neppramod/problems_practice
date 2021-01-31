import java.util.*;

public class Solution {
    public static void main(String[] args) {
	    Solution sol = new Solution();
		int[][] prerequisites = {{1, 0}, {0, 1}};
		boolean result = sol.canFinish(2, prerequisites);
		System.out.println(result);
	}
	
    public boolean canFinish(int numCourses, int[][] prerequisites) {

		if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
			return true;
		}

		// we will use dfs + topological sorting
		// similar problem is alien dictionary
		// let's add all dependent courses' frequencies
		// once their frequencies become 0, after their
		// prerequisites are processed
		// we can use them

		int[] prefreq = new int[numCourses];
		for (int[] pre : prerequisites) {
			prefreq[pre[0]]++;
		}

		Queue<Integer> queue = new LinkedList<>();
		
		// add all prefreq with 0 frequencies to queue
		// we know we can take these courses first,
		// as they don't depend on others
		for (int i = 0; i < numCourses; i++) {
			if (prefreq[i] == 0) {
				queue.add(i);
			}
		}

		// we add free courses size to our final anser
		int canTake = queue.size();

		// let's handle all the courses in topological order
		// using bfs
		// if a prefreq course becomes 0, after it's prerequisite been
		// handled, we can use that course as well
		while (!queue.isEmpty()) {
			int cur = queue.poll();

			// if current was one of the prerequisites
			// we can say that we are able to take it before
			// taking pre[0]
			for (int[] pre : prerequisites) {
				if (cur == pre[1]) {
					prefreq[pre[0]]--;

					if (prefreq[pre[0]] == 0) {
						canTake++;

						// since pre[0] is now free
						// it can be prerequisite to others
						queue.add(pre[0]);
					}
				}
			}
		}

		return canTake == numCourses;
		
	}
}
