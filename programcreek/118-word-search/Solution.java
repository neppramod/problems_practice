import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		char[][] board = {{'A', 'B', 'C', 'E'},
					{'S', 'F', 'C', 'S'},
					{'A', 'D', 'E', 'E'}};
		String word = "ABCCEB";
		boolean result = sol.exist(board, word);
		System.out.println(result);
    }

	boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return false;
		} else if (word.length() == 0) {
			return true;
		} else {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if (dfs(board, word, i, j, 0)) {
						return true;
					}
				}
			}

			return false;
		}
	}

	boolean dfs(char[][] board, String word, int i, int j, int k) {
		int m = board.length;
		int n = board[0].length;

		if (i < 0 || i >= m || j < 0 || j >= n) {
			return false;
		}

		boolean result = false;
		if (word.charAt(k) == board[i][j]) {
			char tmp = board[i][j];
			board[i][j] = '#';
			if (k == word.length()-1) {
				return true;
			} else {
				result |= dfs(board, word, i +1, j, k+1) | dfs(board, word, i - 1, j, k+1) | dfs(board, word, i, j-1, k+1) | dfs(board, word, i, j+1, k+1);
					}

			board[i][j] = tmp;
			return result;
		}

		return false;   
	}
    
}
