package matrix.gameoflife;

import java.util.*;

public class GameOfLife {

	public void gameOfLife(int[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}

		// if neighbor count < 2 and > 3 current dies (0)
		// if neighbor count == 2 or 3, lives to next generation
		// if count == 3, and if dead cell, lives
		// we promote current bit to next higher bit, so that when chaning back it is desired bit

		int[][] moves = { { -1, -1 }, { -1, 1 }, { 1, 1 }, { 1, -1 }, { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

		int m = board.length;
		int n = board[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n ; j++) {
				int count = 0;
				for (int k = 0; k < 8; k++) {
					int dx = i + moves[k][0];
					int dy = j + moves[k][1];

					if (dx >= 0 && dx < m && dy >= 0 && dy < n && (board[dx][dy] & 1) == 1) {
						count++;
					}
				}

				if (count < 2 || count > 3) {
					board[i][j] = board[i][j] & 1;
				} else if (count == 2 || count == 3) {
					board[i][j] = board[i][j] | (board[i][j] << 1);
				}

				if (count == 3) {  // make it live
					board[i][j] = board[i][j] | 2;
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

/*

  | 1 | 0 | 1 | 1 | 1 |
  | 0 | 0 | 1 | 0 | 0 |
  | 0 | 1 | 1 | 1 | 1 |
  | 0 | 0 | 0 | 0 | 1 |

 
[0, 1, 1, 1, 0]
[0, 0, 0, 0, 0]
[0, 1, 1, 0, 1]
[0, 0, 1, 0, 1]
 */
