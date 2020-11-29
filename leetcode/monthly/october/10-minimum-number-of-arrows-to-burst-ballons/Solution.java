import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();

		int[][] points = {{-2147483646,-2147483645}, {2147483646,2147483647}};
		int res = sol.findMinArrowShots(points);
		System.out.println(res);
    }
    
    public int findMinArrowShots(int[][] points) {
		// Similar to merge intervals
		if (points == null || points.length == 0 || points[0].length == 0) {
			return 0;
		}

		Arrays.sort(points, new Comparator<int[]>(){
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[1], b[1]);
			}	
		});


//		Arrays.sort(points, (point1, point2) -> Integer.compare(point1[1], point2[1]));

		for (int i = 0; i < points.length; i++) {
			System.out.println(Arrays.toString(points[i]));
		}
		
		int arrows = 1;
		int cur = points[0][1];

		for (int i = 1; i < points.length; i++) {
			if (points[i][0] <= cur) {
				continue;
			}
			arrows++;
			cur = points[i][1];
		}

		return arrows;
    }
}
