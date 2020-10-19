import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		char[][] board = {
			c("XXXX"),
			c("X00X"),
			c("XX0X"),
			c("X0XX")
		};

		sol.solve(board);
		for (int i = 0; i < board.length; i++) {
			System.out.println(board[i]);
		}
    }

	static char[] c(String s) {
		return s.toCharArray();
	}

	public void solve(char[][] board) {
		if (board == null || board.length == 0) {
			return;
		}

		int m = board.length;
		int n = board[0].length;

		for (int i = 0; i < m; i++) {
			if (board[i][0] == '0') {
				merge(board, i, 0);
			}

			if (board[i][n-1] == '0') {
				merge(board, i, n - 1);
			}
		}

		for (int j = 0; j < n; j++) {
			if (board[0][j] == '0') {
				merge(board, 0, j);
			}

			if (board[n-1][j] == '0') {
				merge(board, n - 1, j);
			}
		}


		// merge 0's on top & bottom border
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == '0') {
					board[i][j] = 'X';
				} else if (board[i][j] == '#') {
					board[i][j] = '0';
				}
			}
		}
	}

	private void merge(char[][] board, int i, int j) {
		board[i][j] = '#';
		int m = board.length;
		int n = board[0].length;

		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];

			if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == '0') {
				merge(board, x, y);
			}
		}
	}
    
}
