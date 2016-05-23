import java.util.*;

class ReverseSortedArray
{
	// reverse in min_max
    public static void reverse(int[] array)
    {
	int n = array.length - 1;
	int mid = array.length / 2;

	for (int i = 0; i < mid; i++) {
	    	// swap
	    	int tmp = array[i];
	    	array[i] = array[n-i];
	    	array[n-i] = tmp;
	}
    }
    
    public static void main(String[] args) {
	int[] array = {3, 7, 9, 10, 12, 18};
	reverse(array);
	System.out.println(Arrays.toString(array));
    }
}
