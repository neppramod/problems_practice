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
    
    public static int searchWithDuplicateValues(int[] array, int start, int end) {
		if (end < start) {
			return -1;
		}
		
		int midIndex = (start + end) / 2;
		int midValue = array[midIndex];
		if (midValue == midIndex) {
			return midIndex;
		}
		
		int left = searchWithDuplicateValues(array, start, Math.min(midValue, midIndex-1));
		if (left >= 0)
			return left;
	
		return searchWithDuplicateValues(array, Math.max(midValue, midIndex+1), end);
		
	}
	
	public static int magicFast(int[] array, int start, int end) {
		if (end < start) {
			return -1;
		}
		int midIndex = (start + end) / 2;
		int midValue = array[midIndex];
		if (midValue == midIndex) {
			return midIndex;
		}
		/* Search left */
		int leftIndex = Math.min(midIndex - 1, midValue);
		int left = magicFast(array, start, leftIndex);
		if (left >= 0) {
			return left;
		}
		
		/* Search right */
		int rightIndex = Math.max(midIndex + 1, midValue);
		int right = magicFast(array, rightIndex, end);
		
		return right;
	}

    public static void main(String[] args)
    {
		int[] array = {-7, -3, -1, 0, 3, 5};
		System.out.println(search(array, 0, array.length - 1));
		System.out.println(searchWithDuplicateValues(array, 0, array.length - 1));
		System.out.println(magicFast(array, 0, array.length - 1));
    }
}
