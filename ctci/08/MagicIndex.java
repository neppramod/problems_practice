public class MagicIndex
{
    public static int search(int[] array, int low, int high)
    {
	if (high < low)
	    return -1;

	int mid = (low + high) / 2;

	if (mid > array[mid])
	    return search(array, mid + 1, high);
	else if (mid < array[mid])
	    return search(array, mid, mid - 1);
	else
	    return mid;
    }

    public static void main(String[] args)
    {
	int[] array = {-7, -3, -1, 0, 3, 5};
	System.out.println(search(array, 0, array.length - 1));
    }
}
