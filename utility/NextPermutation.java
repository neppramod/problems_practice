import java.util.*;

public class NextPermutation {
    public static void main(String[] args) {
	    NextPermutation sol = new NextPermutation();
		int[] nums = {5, 2, 4, 3, 2, 1};
		for (int i = 0; i < 27; i++) {
			sol.nextPermutation(nums);
			System.out.println(Arrays.toString(nums));			
		}

	}

	/**
	 * Set next permutation of nums, which rearranges nums into lexicographically next greater
	 * permutation. If such an arrangement is not possible, it sorts in ascending order
	 *
	 * Scan from right and find the first element where element at i is greater than i -1
	 * mark i-1, if mark is -1, the element is already sorted in descending order
	 * reverse elements from 0 to n-1 (sort elements in ascending order), otherwise
	 * find an element on right greater than element at mark, swap each of them
	 * reverse elements from mark + 1 to n-1
	 * E.g 5 2 4 3 2 1
	 * Here mark = 1 element 2 (after 5)
	 * element on right greater than 2 is at 3 (3)
	 * swap 2 and 3
	 * 5 3 4 2 2 1
	 * reverse all the elements from mark + 1 to n-1
	 * 5 3 1 2 2 4
	 * This is correct because number just greater than 524321 is 531224 lexcicographically not 534221
	 */
    void nextPermutation(int[] nums) {
		if (nums == null || nums.length == 1) {
			return;
		}

		int n = nums.length;
		int mark = -1;

		for (int i = n-1; i > 0; i--) {
			if (nums[i] > nums[i-1]) {
				mark = i-1;
				break;
			}
		}

		if (mark == -1) {
			reverse(nums, 0, n-1);
		} else {
			// find greater element than mark on right
			for (int i = n-1; i > mark; i--) {
				if (nums[i] > nums[mark]) {
					swap(nums, i, mark);
					reverse(nums, mark + 1, n-1);
					break;
				}
			}
		}
	}

	void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	void reverse(int[] nums, int i, int j) {
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}
}
