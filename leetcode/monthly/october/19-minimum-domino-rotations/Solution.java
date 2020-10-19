import java.util.*;
 
public class Solution
{
    public static void main(String[] args) {
        Solution sol = new Solution();
		int[] a = { 1, 2, 1, 1, 1, 2, 2, 2 };
		int[] b = { 2, 1, 2, 2, 2, 2, 2, 2 };
		int result = sol.minDominoRotations(a, b);
		System.out.println(result);
    }
    
    public int minDominoRotations(int[] A, int[] B) {
        if (A == null || B == null || A.length != B.length) {
			return -1;
		}

		int swapCountA = getSwapCount(A, B);
		int swapCountB = getSwapCount(B, A);

//		System.out.println("Swap Count: A: " + swapCountA + ", B: " + swapCountB);

		if (swapCountA == -1 && swapCountB == -1) {
			return -1;
		} else if (swapCountA == -1) {
			return swapCountB;
		} else if (swapCountB == -1) {
			return swapCountA;
		} else {
			return Math.min(swapCountA, swapCountB);
		}
    }

	int getSwapCount(int[] arr1, int[] arr2) {
		int count = 0;

		int aMajority = getMajority(arr1);
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != aMajority) {
				if (arr2[i] == aMajority) {
					count++;
				} else {
					return -1;
				}
			} 
		}

		return count;
	}

	int getMajority(int[] arr) {
		int majority = -1;
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
				if (majority == -1) {
					majority = arr[i];
				}
			} else {
				int prevCount = map.get(arr[i]);
				map.put(arr[i], prevCount + 1);

				int curMaj = map.get(majority);
				if (prevCount + 1 > curMaj) {
					majority = arr[i];
				}
			}
		}

		return majority;
	}
}
