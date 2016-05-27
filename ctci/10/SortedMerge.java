import java.util.*;

public class SortedMerge
{
    static void merge(int[] A, int[] B)
    {
	if (A == null || B == null || A.length == 0 || B.length == 0)
	    return;

	int i = 0;
	int j = 0;

	while (j < B.length) {

	    while (A[i] < B[j]) {
		i++;
	    }

	    rightshift(A, i);
	    A[i] = B[j];
	    j++;
	}	
    }

    static void rightshift(int[] A, int i)
    {
	int j = A.length - 1;

	while (A[j] == Integer.MIN_VALUE)
	    j--;
	j++;  // fix the index

	while (j > i) {
	    A[j] = A[j-1];
	    j--;
	}
    }

    public static void main(String[] args)
    {
	int[] A = new int[10];
	Arrays.fill(A, Integer.MIN_VALUE);

	A[0] = 1;
	A[1] = 3;
	A[2] = 5;
	A[3] = 7;
	A[4] = 8;
	A[5] = 9;

	int[] B = {2, 4, 6};
	merge(A, B);

	System.out.println(Arrays.toString(A));
    }
}
