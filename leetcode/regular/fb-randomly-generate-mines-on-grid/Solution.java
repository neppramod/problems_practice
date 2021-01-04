import java.util.*;

public class Solution {

	/*

	  You are given a m*n grid. You are asked to generate k mines on this grid randomly. Each cell should have equal probability of k / m*n of being chosen.

	*/

	static int sumofIterations = 0;
	
    public static void main(String[] args) {
	    Solution sol = new Solution();
		int m = 600, n = 600;
		int k = 100;
		int[] result = new int[k];


		int numberOfRun = 20000;

		for (int i = 0; i < numberOfRun; i++) {
			Arrays.fill(result, -1);  // fill with invalid values
			sol.generateMines(m, n, k, result);
		}

		
		System.out.println(Arrays.toString(result));
		double average = (double)sumofIterations / numberOfRun;
		
		System.out.println("Average iterations: " + average);

	}
	
	public void generateMines(int m, int n, int k, int[] result) {
		int count = 0;
		Random r = new Random();
		int limit = m * n;
		int iterations = 0;
		
		while (count < k) {
			int randomValue = r.nextInt(m * n);
			iterations++;

			int index = randomValue % k;

			if (result[index] == -1) {
				result[index] = randomValue;
				count++;
			} else {
				result[index] = randomValue;
			}
		}
	
		sumofIterations += iterations;
	}
	
}
