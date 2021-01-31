import java.util.*;

public class GameOfLife {
    public static void main(String[] args) {
	    GameOfLife sol = new GameOfLife();

		int[][] board = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
		sol.gameOfLife(board);
		for (int i = 0; i < board.length; i++) {
			System.out.println(Arrays.toString(board[i]));
		}

	}


	
void gameOfLife(int[][] board) {
		// get count by &1. So only first bit contributes to count
		// if (count < 2 || count > 3) we & by 1, so that 0 is 0, 1 is 1
		// if count == 2 or 3, we left shift current cell and or with itself, so 0 is 0, 1 is 3
		// if count == 3, we or with 2 so that 0 becomes 2 and 3 becomes 3

		// for other calculation 2 & 1 == 0, therefore any cell promoted from 0 to 2 will not contribute
		// to current count

		int m = board.length;
		int n = board[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int count = 0;

				
				for(int k = i-1; k <= i + 1; k++) {
					for (int l = j - 1; l <= j + 1; l++) {
						if (k >= 0 && k < m && l >= 0 && l < n && !(k == i && l == j) && (board[k][l] & 1) == 1) {
							count++;
						}
					}
				}
				

				System.out.println("Count: " + count);

				if (count < 2 || count > 3) {
					board[i][j] &= 1;
				} else if (count == 2 || count == 3) {
					board[i][j] |= board[i][j] << 1;
				}

				if (count == 3) {
					board[i][j] |= 2;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = board[i][j] >> 1;
			}
		}
    }
}
