package myprob;

import java.util.*;

/**
	[7,5,3,8,9,2,4]
	[7, 5, 3, 8] [9, 2, 4]
	[7, 5] [3, 8]     	[9, 2] [4]
	[7] [5]    [3] [8]          	[9] [2]    [4]
	[5,7]     [3,8]         [2, 9] [4]
	[3, 5, 7, 8]         [2, 4, 9]
	[2, 3, 4, 5, 7, 8, 9]

*/

public class MergeSort
{
	void mergesort(int[] array)
	{
		int[] helper = new int[array.length];
		mergesort(array, helper, 0, array.length - 1);
	}
	
	void mergesort(int[] array, int[] helper, int low, int high)
	{
		if (low < high) {			
			int mid = (low + high) / 2;
			mergesort(array, helper, low, mid);
			mergesort(array, helper, mid + 1, high);
			merge(array, helper, low, mid, high);				
		}
	}
	
	void merge(int[] array, int[] helper, int low, int mid, int high)
	{
		System.out.println(Arrays.toString(array));
		
		for (int i = low; i <= high; i++) {
			helper[i] = array[i];
		}
		
		int lowhelper = low;
		int highhelper = mid + 1;
		int current = low;
		
		while (lowhelper <= mid && highhelper <= high) {
			if (helper[lowhelper] <= helper[highhelper]) {
				array[current] = helper[lowhelper];
				lowhelper++;
			} else {
				array[current] = helper[highhelper];
				highhelper++;
			}
			current++;
		}
		
		// copy remaining lefthalf to array
		// right array is already in correctly adjusted
		int remaining = mid - lowhelper;
		for (int i = 0; i <= remaining; i++) {
			array[current + i] = helper[lowhelper + i];
		}
	}
	
	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		int[] array = {3, 9, 4, 8, 6, 2, 1};
		mergeSort.mergesort(array);
		System.out.println(Arrays.toString(array));
	}
}
