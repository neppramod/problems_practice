import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
         
    }
    
    public double champagneTower(int poured, int query_row, int query_glass) {

		double[][] tower = new double[101][101];
		tower[0][0] = poured; // pour everything to first glass at top
		
		for (int row = 0; row <= query_row; row++) {
			for (int col = 0; col <= row; col++) {

				// what is left after powering in 1 glass at row, col
				// half of each goes to each glass below
				int remaining = (tower[row][col] - 1) / 2;

				if (remaining > 0) {
					tower[row + 1][col] += remaining;
					tower[row + 1][col + 1] += remaining;
				}
			}
		}

		// if more than 1 remaining, others fall to ground
		return Math.min(1, tower[query_row][query_glass]);
    }
}
