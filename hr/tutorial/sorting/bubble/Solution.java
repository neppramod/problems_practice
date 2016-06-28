import java.util.*;

public class Solution 
{
	private static void printArray(String s, int[] x){
       System.out.print(s + " Array: "); 
       for(int i : x){
          System.out.print(i + " ");
       }
       System.out.println();
	}

	public static void bubbleSort(int[] A)
	{
		printArray("Initial", A);
		for (int i = A.length-1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (A[j] > A[j+1]) {
					swap(A, j, j+1);
				}
				printArray("Current", A);
			}
		}
	}

	static void swap(int[] A, int i , int j)
	{
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}

	public static void main(String[] args)
	{
		int[] unsorted = {1, 5, 2, 4, 3};
		bubbleSort(unsorted);
	}
}
