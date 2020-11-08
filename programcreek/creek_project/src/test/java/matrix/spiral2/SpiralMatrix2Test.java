package matrix.spiral2;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class SpiralMatrix2Test {
    
	@Test
	public void testGenerateMatrix() {
		SpiralMatrix2 spiralMatrix2 = new SpiralMatrix2();
		int n = 4;
		int[][] matrix = {{1, 2, 3, 4},
						  {12, 13, 14, 5},
						  {11, 16,15, 6},
						  {10, 9, 8, 7}};
		assertThat(spiralMatrix2.generateMatrix(n), is(matrix));
	}
}
