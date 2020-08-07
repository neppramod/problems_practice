import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
         
    }
    
    public int leastInterval(char[] tasks, int n) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < tasks.length; i++) {
			if (!map.containsKey(tasks[i])) {
				map.put(tasks[i], 0);
			} 

			map.put(tasks[i], map.get(tasks[i]) + 1);
			
		}

		// Find and count number of max
		int max = 0, countOfMax = 0;
		for (Character k : map.keySet()) {
			if (map.get(k) > max) {
				max = map.get(k);
				countOfMax = 1;
			} else if (map.get(k) == max) {
				countOfMax++;
			}
		}

		// ans = (max - 1) * (n + 1) + 1 + (countOfMax - 1)
		// ans = n * max + max - n - 1 + 1 + (countOfMax - 1)
		// ans = n * max + max - n + (countOfMax - 1)
		int ans = n * max + max - n + (countOfMax - 1);
		return Math.max(ans, tasks.length);
	}
}
