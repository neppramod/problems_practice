public class FixedPointInArray
{
    int fixedPoint(int[] array)
    {
	for (int i = 0; i < array.length; i++) {
	    if (array[i] == i) {
		return i;
	    }
	}

	return -1;	    
    }

    public static void main(String[] args)
    {
	FixedPointInArray fpIA = new FixedPointInArray();
	//int[] arr = {-10, -5, 0, 3, 7};
	//int[] arr = {0, 2, 5, 8, 17};
	int[] arr = {-10, -5, 3, 4, 7, 9};
	System.out.println(fpIA.fixedPoint(arr));
    }	
}
