import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[][] A = { { 1, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 } };
		int[][] B = { { 0, 0, 0 }, { 0, 1, 1 }, { 0, 0, 1 } };
		int res = sol.largestOverlap(A, B);
		System.out.println(res);
    }
    
    public int largestOverlap(int[][] A, int[][] B) {
        int maxCount = 0;
		int n = A.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				maxCount = Math.max(maxCount, getOverlappingCount(A, B, i, j));
				maxCount = Math.max(maxCount, getOverlappingCount(B, A, i, j));
			}
		}

		return maxCount;
    }

	int getOverlappingCount(int[][] A, int[][] B, int startAI, int startAJ) {
		int count = 0;
		int n = A.length;

		int startBI = 0;
		int startBJ = 0;

		for (int i = startAI; i < n; i++) {
			startBJ = 0;
			for (int j = startAJ; j < n; j++) {
				if (A[i][j] == 1 && A[i][j] == B[startBI][startBJ]) {
					count++;
				}
				startBJ++;
			}
			startBI++;
		}

		return count;
	}
}
