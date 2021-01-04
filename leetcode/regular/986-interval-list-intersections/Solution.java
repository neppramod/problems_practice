import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] A = { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
		int[][] B = { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };

		int[][] result = sol.intervalIntersection(A, B);

		for (int[] r : result) {
			System.out.println(Arrays.toString(r));
		}
	}
	
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        // we assume A and B are sorted
        if (A == null || B == null) {
            return null;
        }
        
        // we use two pointers, i and j, and try to capture
        // intersections
        // and increment i and j according to which has smaller end based on both
        
        int i = 0, j = 0;
        int m = A.length;
        int n = B.length;
        
        List<int[]> intersections = new ArrayList<>();
        
        while (i < m && j < n) {
            int[] intersection = getIntersection(A[i], B[j]);
            
            if (intersection != null) {
                intersections.add(intersection);
            }
            
            // which ever end is smaller, move that pointer
            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        
        int[][] result = new int[intersections.size()][2];
        for (int k = 0; k < intersections.size(); k++) {
            result[k] = intersections.get(k);
        }
        
        return result;
        
    }
    
    int[] getIntersection(int[] A, int[] B) {
        int start = Math.max(A[0], B[0]);
        int end = Math.min(A[1], B[1]);
        
        if (start > end) {
            return null;
        }
        
        if (start >= A[0] && start >= B[0] && end <= A[1] && end <= B[1]) {
            return new int[] {start, end};
        } else {
            return null;
        }
    }
}
