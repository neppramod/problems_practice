package  myprob;

import java.util.*;

public class KnapSack
{
	void knapSack(int[][] array, int[] wt, int[] values)
	{
		// fill first column with 0
		for (int i = 0; i < wt.length; i++) {
			array[i][0] = 0;
		}
		
		// fill first row with value of least weight
		for (int i = 1; i < array.length; i++) {
			array[0][i] = values[0];
		}
		
		// for other apply the formula
		for (int i = 1; i < wt.length; i++) {
			for (int j = 1; j < array.length; j++) {
				if (j >= wt[i]) {
					array[i][j] = (int) Math.max(values[i] + array[i-1][j-wt[i]],
					 array[i-1][j]);
				} else {
					array[i][j] = array[i-1][j];
				}
			}
		}
	}
	
	void getWeights(int[][] array, List<Integer> weights, int[] wt)
	{
		int i = array.length - 1;
		int j = array[0].length -1;
		
		// if value at a column matches to that of previous row it is not counted
		while (array[i][j] != 0) {
			if (array[i][j] != array[i-1][j]) {
				weights.add(array[i][j]);
				j-= wt[i]; // if a weight is included we can go that many weights to left
			}
			i--;
		}
	}
	
	
}
