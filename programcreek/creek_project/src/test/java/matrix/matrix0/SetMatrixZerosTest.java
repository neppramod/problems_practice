package matrix.matrix0;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SetMatrixZerosTest {

	@Test
	public void testFirst() {
		int[][] matrix = { { 1, 1, 1 },
						   { 1, 0, 1 },
						   { 1, 1, 1 } };
		
		SetMatrixZeros setMatrixZeros = new SetMatrixZeros();
		setMatrixZeros.setZeroes(matrix);

		assertThat(matrix, is(new int[][] { { 1, 0, 1 },
											{ 0, 0, 0 },
											{ 1, 0, 1 } }));
	
	}
}

