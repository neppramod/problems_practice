import java.util.*;

public class ChessBoardAndQueen {
	static final int N = 8;
	static int count = 0;
	
    public static void main(String[] args) {
	    ChessBoardAndQueen sol = new ChessBoardAndQueen();
		Scanner sc = new Scanner(System.in);
		String[] lines = new String[N];

		for (int i = 0; i < N; i++) {
			lines[i] = sc.next();
		}

		sol.placeQueens(lines);
		System.out.println(count);
	}

	public void placeQueens(String[] lines) {
		boolean[][] blocked = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (lines[i].charAt(j) == '*') {
					blocked[i][j] = true;
				}
			}
		}

		boolean[] column = new boolean[N];
		boolean[] diag1 = new boolean[2 * N];  // forward diagonal combination of row + col
		boolean[] diag2 = new boolean[2 * N];  // backward diagonal combination of row + (N-1-col)
		placeQueens(0, blocked, column, diag1, diag2);
	}

	private void placeQueens(int y, boolean[][] blocked, boolean[] column, boolean[] diag1, boolean[] diag2) {
		if (y == N) {
			count++;			
		} else {
			for (int x = 0; x < N; x++) {
				if (blocked[x][y] || column[x] || diag1[x + y] || diag2[x + (N - 1 - y)]) {
					continue;
				} else {
					column[x] = diag1[x + y] = diag2[x + (N - 1 - y)] = true;
					placeQueens(y + 1, blocked, column, diag1, diag2);
					column[x] = diag1[x + y] = diag2[x + (N - 1 - y)] = false;
				}
			}
		}
	}
		
}
