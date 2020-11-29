import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[] asteroids = { 8, -8 };
		int[] result = sol.asteroidCollision(asteroids);
		System.out.println(Arrays.toString(result));
    }
    
    public int[] asteroidCollision(int[] asteroids) {
		if (asteroids == null || asteroids.length == 0) {
			return asteroids;
		}

		List<Integer> list = new ArrayList<>();
		list.add(asteroids[0]);
		

		for (int i = 1; i < asteroids.length; i++) {
			if (asteroids[i] > 0) {
				list.add(asteroids[i]);
			} else {
				// for negative asteroid
				// make sure left are positive to collide
				// a. if abs cur value is greater than last +ve value of list
				// remove that
				// b. If abs cur value is smaller or equal to last +ve value, remove current element

				while (list.size() > 0) {
					if (Math.abs(asteroids[i]) >= list.get(list.size()-1)) {
						list.remove(list.size() - 1);
					}
				}

				if (list.size() > 0 && list.get(list.size()-1) >= asteroids[i]) {
					continue;
				}
				list.add(asteroids[i]);
			}
		}

		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}

		return result;
    }
}
