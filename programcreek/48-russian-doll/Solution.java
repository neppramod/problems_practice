import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[][] envelopes = {{1, 2}, {3, 2}, {4, 5}, {6, 4}, {5, 5}, {8, 9}, {8, 7}, {9, 12}};
		int result = sol.maxEnvelopes(envelopes);
		System.out.println(result);
		System.out.println("Second: " + sol.maxEnvelopes2(envelopes));
    }
    
    public int maxEnvelopes(int[][] envelopes) {
		if (envelopes == null || envelopes.length == 0) {
			return 0;
		}

		Arrays.sort(envelopes, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] != b[0]) {
					return a[0] - b[0];
				} else {
					return a[1] - b[1];
				}
			}
		});

		int max = 1;
		int[] arr = new int[envelopes.length];
		for (int i = 0; i < envelopes.length; i++) {
			arr[i] = 1;
			for (int j = i-1; j >= 0; j--) {
				if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
					arr[i] = Math.max(arr[i], arr[j] + 1);
				}
			}
			max = Math.max(max, arr[i]);
		}

		return max;
	}

	// using binary search
	public int maxEnvelopes2(int[][] envelopes) {
		if (envelopes == null || envelopes.length == 0) {
			return 0;
		}

		// first sort using height in increasing order, then sort by width in decreasing order

		Arrays.sort(envelopes, new Comparator<int[]>(){
			public int compare(int[] a, int[] b) {
				if (a[0] != b[0]) {
					return a[0] - b[0];
				} else {
					return b[1] - a[1];
				}
			}	
		});

		List<Integer> list = new ArrayList<>();
		for (int[] arr : envelopes) {
			int target = arr[1];

			if (list.isEmpty() || target > list.get(list.size()-1)) {
				list.add(target);
			} else {
				int j = list.size()-1;
				int i = 0;

				while (i < j) {
					int m = i + (j-i)/2;

					if (list.get(m) < target) {
						i = m + 1;
					} else {
						j = m;
					}
				}
				list.set(j, target);
			}
		}

		return list.size();
	}
}
