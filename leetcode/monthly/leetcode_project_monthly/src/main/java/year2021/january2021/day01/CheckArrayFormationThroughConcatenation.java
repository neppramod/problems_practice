package year2021.january2021.day01;


import java.util.*;

public class CheckArrayFormationThroughConcatenation {

		/*
	  Input: arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
	Output: true
	Explanation: Concatenate [91] then [4,64] then [78]
	
	Since values in each array are distinct, we don't need to worry about duplicates.
	
	Since the size of both array is not more than 200 each we can use O(n^2) solution. However, for easy search, I tend to use map, so that we can easily search values.

	For elements in pieces, we add each element to the array index in pieces

	E.g. [78: 0, 4: 1, 64: 1, 91: 2]

	i = 0, while i < n (n is size in first array)

	current element = arr[i] = 91. Look for arr[i] in map, map.get(arr[i]) = 2

	if pieceIndex = map.get(arr[i]) == null, return false, as we cannot search anymore
	
	else, for (int num : pieces[pieceIndex])
	     if (num == arr[i])i++;
		 else return false;

    keep on doing this, until i == n, if i == n, return true, else return false
	 */
	
	public boolean canFormArray(int[] arr, int[][] pieces) {
        if (arr == null || pieces == null) {
			return false;
		}

		int n = arr.length;
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < pieces.length; i++) {
			for (int p : pieces[i]) {
				map.put(p, i);
			}
		}

		int i = 0;
		while (i < n) {
			int cur = arr[i];

			if (map.get(cur) == null) {
				return false;
			}

			int pieceIndex = map.get(cur);
			for (int num : pieces[pieceIndex]) {
				if (num == arr[i]) {
					i++;
				} else {
					return false;
				}
			}
		}

		return i == n;
    }
}
