import java.util.*;
import java.math.*;

public class Solution
{
	static Random random = new Random();
	int totalSum = 0;
	TreeMap<Integer, Rectangle> map = new TreeMap<>();

	public static void main(String[] args) {
		int[][] rects = { { -2, -2, -1, -1 }, {1, 0, 3, 0} };
		Solution sol = new Solution(rects);
		System.out.println(Arrays.toString(sol.pick()));
		System.out.println(Arrays.toString(sol.pick()));
		System.out.println(Arrays.toString(sol.pick()));
	}


	public Solution(int[][] rects) {


		for (int i = 0; i < rects.length; i++) {

			Rectangle rect = new Rectangle(rects[i][0], rects[i][1], rects[i][2], rects[i][3]);


			totalSum += rect.area;
			map.put(totalSum, rect);
		}
	}

	public int[] pick() {
		int r = random.nextInt(totalSum) + 1;

		return map.get(map.ceilingKey(r)).pick();
	}

	static class Rectangle {
		int x1, y1, x2, y2;
		int area;

		public Rectangle(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
			area = (x2 - x1 + 1) * (y2 - y1 + 1);
		}

		public int[] pick() {
			int x = x1 + random.nextInt(x2 - x1 + 1);
			int y = y1 + random.nextInt(y2 - y1 + 1);

			return new int[] { x, y };
		}
	}
}
