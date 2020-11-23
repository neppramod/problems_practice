package matrix.tictactoe;

import java.util.*;

public class TicTacToe {
	int n;
	int[] rows;
	int[] cols;
	int dc1;  // diagonal forward
	int dc2;  // diagonal backward
	
    public TicTacToe(int n) {
		this.n = n;
		rows = new int[n];
		cols = new int[n];
	}

	// player 1 or 2
	// we choose 1 for player1 and -1 for player 2
	// if sum of rows, cols, dc1, dc2 == 3, we have a winner
	public int move(int row, int col, int player) {
		int val = player == 1 ? 1 : -1;

		rows[row] += val;
		cols[col] += val;

		if (row == col) {
			dc1 += val;
		}

		if (col == n - row - 1) {
			dc2 += val;
		}

		if (Math.abs(rows[row]) == n ||
			Math.abs(cols[col]) == n ||
			Math.abs(dc1) == n ||
			Math.abs(dc2) == n) {
			return player;
		}

		return 0;
	}
    
}
