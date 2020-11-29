 import java.util.*;
 
 public class Solution
 {
    public static void main(String[] args) {
		Solution sol = new Solution();
        int[][] positions = {{0,0}, {0, 1}, {1, 2}, {2, 1}};
		int m = 3, n = 3;
		List<Integer> result = sol.numIslands2(m, n, positions);
		System.out.println(result);
    }
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] rootArray = new int[m * n];
		Arrays.fill(rootArray, -1);

		List<Integer> result = new ArrayList<>();
		int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		int count = 0;

		for (int[] position : positions) {
			count++;
			int index = position[0] * n + position[1];
			rootArray[index] = index;   // create disjoint set

			for (int[] d : direction) {
				int i = d[0] + position[0];
				int j = d[1] + position[1];

				if (i >= 0 && j >= 0 && i < m && j < n && rootArray[i * n + j] != -1) {
					// get neighbor's root
					int nRoot = getRoot(rootArray, i * n + j);
					if (nRoot != index) {
						rootArray[nRoot] = index; // set previos root's root
						count--;   // merged, so one less island
					}
				}
			}

			result.add(count);
		}

		return result;
    }

	 int getRoot(int[] arr, int i) {
		 if (arr[i] != i) {
			 arr[i] = arr[arr[i]];
			 return getRoot(arr, arr[i]);
		 } else {
			 return i;
		 }
	 }
 }
