package matrix.multiplication;

public class SparseMatrixMultiplication {
    public int[][] multiplyNaive(int[][] A, int[][] B) {
        int[][] C = new int[A.length][B[0].length];   // i x k MUL k x j = i x j

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C[0].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }

    // If A[i][k] is 0, don't multiply
    // Since matrix is sparse, time complexity is O(n^2) instead of O(n^3)
    public int[][] multiplyOptimized(int[][] A, int[][] B) {
        int[][] C = new int[A.length][B[0].length];

        for (int i = 0; i < C.length; i++) {
            for (int k = 0; k < A[0].length; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < C[0].length; j++) {
                        C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }

        return C;
    }
}
