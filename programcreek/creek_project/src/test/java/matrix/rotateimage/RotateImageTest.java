package matrix.rotateimage;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;


public class RotateImageTest {

	@Test
	public void testRotate4() {
		int[][] matrix = {{1, 2, 3, 4},
			              {5, 6, 7, 8},
						  { 9, 10, 11, 12 },
						  { 13, 14, 15, 16 },
		};

		int[][] rotatedMatrix = {{13, 9, 5, 1},
								 {14, 10, 6, 2},
								 {15, 11, 7, 3},
								 { 16, 12, 8, 4 } };

		RotateImage rotateImage = new RotateImage();
		rotateImage.rotate(matrix);
		
		assertThat(matrix, is(rotatedMatrix));
	}

	@Test
	public void testRotate3() throws Exception {
		int[][] matrix = {{1, 2, 3},
						  {4, 5, 6},
						  {7, 8, 9}};

		int[][] rotatedMatrix = {{7, 4, 1},
		                         {8, 5, 2},
								 {9, 6, 3}};

		RotateImage rotateImage = new RotateImage();
		rotateImage.rotate(matrix);
		
		assertThat(matrix, is(rotatedMatrix));
		
	}

}
