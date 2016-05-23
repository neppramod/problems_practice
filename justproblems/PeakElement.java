import java.util.*;

public class PeakElement
{
    public int peekElement(int[] array)
    {
	if (array.length < 2)
	    throw new RuntimeException("Array cannot be of size less than 2");
	
	for(int i = 1; i < array.length - 1; i++) {
	    if (array[i-1] < array[i] && array[i] > array[i+1]) {
		return array[i];
	    }
	}

	if (array[0] > array[1])
	    return array[0];
	else if (array[array.length-1] > array[array.length-2])
	    return array[array.length-1];

	return -1;
    }

    // if middle element is less than left there has to be peek on left
    // if middle element is less than right there has to be a peek on right
    public int peekElementUsingBST(int[] array, int left, int right)
    {

	int mid = (right - left) / 2 + left;
	if ((mid == 0 || array[mid-1] < array[mid]) &&
	    (mid == right -1 || array[mid-1] > array[mid])) {

	    return array[mid];
	} else if (mid > 0 && array[mid-1] > array[mid]) {
	    return peekElementUsingBST(array, left, mid-1);
	} else {
	    return peekElementUsingBST(array, mid + 1, right);
	}	    
    }

    public static void main(String[] args)
    {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int[] array = new int[N];
	
	for (int i = 0; i < N; i++) {
	    array[i] = sc.nextInt();
	}

	System.out.println(new PeakElement().peekElement(array));
	System.out.println(new PeakElement().peekElementUsingBST(array, 0, array.length - 1));
    }
}
