import java.util.*;

public class ValidSquare {

	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		// if length of any side is different return false
		HashMap<Long, Integer> map = new HashMap<>();

		int[][] matrix = {p1, p2, p3, p4};

		for (int i = 0; i < 4; i++) {
			for (int j = i + 1; j < 4; j++) {
				int x = matrix[i][0] - matrix[j][0];
				int y = matrix[i][1] - matrix[j][1];
				long ls = x * x + y * y;

				if (ls == 0) {
					return false;
				}

				// all lenth must be same
				map.put(ls, 1);
				if (map.size() > 2) {
					return false;
				}
			}
		}

		return true;
    }


	public static void main(String[] args) {
		int[] p1 = { 1, 1 };
		int[] p2 = { 0, 1 };
		int[] p3 = { 1, 2 };
		int[] p4 = { 0, 0 };

		ValidSquare validSquare = new ValidSquare();

		System.out.println(validSquare.validSquare(p1, p2, p3, p4));

	}
}
