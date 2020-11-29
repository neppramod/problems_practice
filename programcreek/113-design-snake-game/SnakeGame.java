import java.util.*;
 
public class SnakeGame {
	public static void main(final String[] args) {

	}

	int[][] food;
	int width, height;
	int x, y;
	int index, len;
	LinkedList<int[]> list;

	public SnakeGame(final int[][] food, final int width, final int height) {
		this.width = width;
		this.height = height;
		this.food = food;
		this.x = 0;
		this.y = 0;
		this.index = 0;
		this.len = 0;
		list = new LinkedList<>();

		list.add(new int[]{0, 0}); // starting
	}

	int move(String direction) {
		if (!isValid(x, y)) {
			return false;
		}

		switch(direction) {
		case "U":
			x--;
			break;
		case "L":
			y--;
			break;
		case "R":
			y++;
			break;
		case "D":
			x++;
			break;
		}
		
	}

	int process(int x, int y) {
		if (index == food.length) {
			list.poll();
		} else if (x == food[index][0] && y == food[index][1]) {
			len++;
			index++;
		} else {
			queue.poll();
		}

		for (int[] p : queue) {
			if (p[0] == x && p[1] == y) {
				return -1;
			}
		}

		queue.add(new int[] { x, y });

		return len;
	}

	boolean isValid(int x, int y) {
		if (x < 0 || y < 0 || x >= this.width || y >= this.height) {
			return -1;
		}

		return true;
	}
}
