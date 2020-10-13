import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		char[][] board = {
			a("53..7...."),
			a("6..195..."),
			a(".98....6."),
			a("8...6...3"),
			a("4..8.3..1"),
			a("7...2...6"),
			a(".6....28."),
			a("...419..5"),
			a("....8..79")
		};


		boolean result = sol.isValidSudoku(board);
		System.out.println(result);
    }

	static char[] a(String s) {
		return s.toCharArray();
	}
    
	boolean isValidSudoku(char[][] board) {
		if (board == null || board.length != 9 || board[0].length != 9) {
			return false;
		}

		// check rows
		for (int i = 0; i < 9; i++) {
			boolean[] m = new boolean[9];
			
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (m[board[i][j] - '1']) {
						return false;
					}
					m[board[i][j] - '1'] = true;
				}
			}
		}

		// check cols
		for (int j = 0; j < 9; j++) {
			boolean[] m = new boolean[9];
			
			for (int i = 0; i < 9; i++) {
				if (board[i][j] != '.') {
					if (m[board[i][j] - '1']) {
						return false;
					}
					m[board[i][j] - '1'] = true;
				}
			}
		}

		// check each block, starting from 0 on top left, 1 starts at top row, 4th column,
		// ends at 6th column and so on
		for (int block = 0; block < 9; block++) {

			for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
				boolean[] m = new boolean[9];

				for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {

					if (board[i][j] != '.') {
						if (m[board[i][j] - '1']) {
							return false;
						}
						m[board[i][j] - '1'] = true;
					}
				}
			}
		}

		return true;
	}

}
