package matrix.multiplication;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class SparseMatrixMultiplicationTest {
    
    @Test
    public void testNaive() {
        SparseMatrixMultiplication sparseMatrixMultiplication = new SparseMatrixMultiplication();
        int[][] A = {{1, 0, 0}, {-1, 0, 3}};
        int[][] B = {{7, 0, 0}, {0, 0, 0}, {0, 0, 1}};

        int[][] C = {{7, 0, 0}, {-7, 0, 3}};

        assertThat(sparseMatrixMultiplication.multiplyNaive(A, B), is(C));
    }

}
