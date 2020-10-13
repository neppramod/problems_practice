import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		char[][] board = {
			{'5', '3', '.', '.', '.', '.', '.', '.', '.'},
			{'6', '.', '8', '.', '.', '.', '.', '.', '.'},
			{'.', '9', '1', '.', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
			{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
		};
		sol.solveSudoku(board);         
    }
    
	void solveSudoku(char[][] board) {
		boolean result = helper(board);
		System.out.println(result);
	}

	boolean helper(char[][] board) {
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					continue;
				}

				for (char k = '1'; k <= '9'; k++) {

					if (isValid(board, i, j, k)) {
						board[i][j] = k;
						if (helper(board)) {
							return true;
						}
						board[i][j] = '.';

					}
				}

				return false;
			}
		}

		return true;
	}

	boolean isValid(char[][] board, int row, int col, char c) {
		
		for (int k = 0; k < 9; k++) {
			if (board[row][k] != '.' && board[row][k] == c) {
				return false;
			}

			if (board[k][col] != '.' && board[k][col] == c) {
				return false;
			}

			if (board[3 * (row/3) + k / 3][3 * (col/3)  + k % 3] != '.' && board[3 * (row/3) + k / 3][3 * (col/3) + k % 3] == c) {
				return false;
			}
		}

		return true;
	}
}
