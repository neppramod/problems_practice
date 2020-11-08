package matrix.spiral;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SpiralMatrixTest {

	@Test 
	public void testSpiralOrder() {
		SpiralMatrix spiralMatrix = new SpiralMatrix();
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		ArrayList<Integer> result = spiralMatrix.spiralOrder(matrix);
		System.out.println(result);
	}
}
