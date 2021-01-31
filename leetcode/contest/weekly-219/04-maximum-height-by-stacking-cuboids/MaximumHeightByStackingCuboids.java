import java.util.*;

public class MaximumHeightByStackingCuboids {
    public static void main(String[] args) {
	    MaximumHeightByStackingCuboids sol = new MaximumHeightByStackingCuboids();
		
	}

	static class Rectangle implements Comparable<Rectangle>
	{
		int width, length, height;

		public Rectangle(int w, int l, int h) {
			width = w;
			length = l;
			height = h;
		}

		public int compareTo(Rectangle o) {
			if (o == null) {
				return -1;
			} else {
				if (width <= o.width && length <= o.length) {
					return -1;
				} else if (width >= o.widht && length >= o.length) {
					return 1;
				} else {
					return 0;
				}
			}
		}
	}
	
    public int maxHeight(int[][] cuboids) {
		if (cuboids == null || cuboilds.length == 0 || cuboilds[0].length == 0) {
			return 0;
		}

		int n = cuboids.length;
		int m = n * 3;

		int j = 0;
		
		Rectangle[] rectangles = new Rectangle[m];

		for (int i = 0; i < n; i++) {
			Rectangle r1 = new Rectangle(cuboids[i][0], Math.max(cuboids[i][1], cuboids[i][2]), Math.min(cuboids[i][1], cuboids[i][2]));
			Rectangle r2 = new Rectangle(cuboids[i][2], Math.max(cuboids[i][1], cuboids[i][0])), Math.min()
			Rectangle r3 = new Rectangle(cuboids[i][1], cuboids[i][2], cuboids[i][1]);
			rectangles[j++] = r1;
			rectangles[j++] = r2;
			rectangles[j++] = r3;
		}

		Arrays.sort(rectangles);

		int maxLength = 0;
		int[] dp = new int[m];

		for (int i = 0; i < m; i++) {
			Rectangle cur = rectangles[i];
			int val = 0;
			
			for (int j = 0; j < i; j++) {
				Rectangle prev = rectangles[j];

				if (cur.height > prev.height) {
					dp[i] = Math.max(val, dp[j]);
				}
			}

			dp[i] = val + cur.height;
		}

		int max = -1;

		for (int i = 0; i < m; i++) {
			max = Math.max(max, dp[i]);
		}

		return max;
		
	}
}
