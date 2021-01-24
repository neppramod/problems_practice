import java.util.*;

public class NumberSpiral {
    public static void main(String[] args) {
	    NumberSpiral sol = new NumberSpiral();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		while (t-- > 0) {
			long row = sc.nextLong();
			long col = sc.nextLong();

			sb.append(sol.numberSpiral(row, col) + "\n");
		}

		System.out.println(sb.toString());
	}

	/*
	  a. when col is bigger and odd, col * col - row + 1
	  b. when col is bigger and even. (col = col-1), col * col + row
	  c. when row is bigger or equal and row is even, row * row - col + 1 
	  d. when row is bigger or equal and row is odd. (row = row-1), row * row + col
	 */
	long numberSpiral(long row, long col) {
		if (row >= col) {
			if (row % 2 == 0) {
				return row * row - col + 1;
			} else {
				row = row - 1;
				return row * row + col;
			}
		} else {
			if (col % 2 == 0) {
				col = col - 1;
				return col * col + row;
			} else {
				return col * col - row + 1;
			}
		}
	}
	
}
