import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		char[][] board = {
			{'A','B','C','E'},
			{'S','F','C','S'},
			{'A','D','E','E'}
		};
		System.out.println(sol.exist(board, "ABCB"));

    }
    
    
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        boolean[][] dp = new boolean[m][n];

		int p = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (exist(board, i, j, word, p)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    boolean exist(char[][] board, int i, int j, String word, int p) {
        if (board[i][j] != word.charAt(p)) {
            return false;
        } else if (p >= word.length() - 1) {
			return true;
		} else {
			char cur = board[i][j];
			board[i][j] = '#';

            
            for (int k = 0; k < 4; k++) {
                int x = i + moves[k][0];
                int y = j + moves[k][1];
                
                if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && word.charAt(p+1) == board[x][y]) {
					if (exist(board, x, y, word, p+1)) {
						return true;
					}
                }
            }
            
            
			board[i][j] = cur;
            return false;
        }
    }
}

