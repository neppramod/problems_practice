public class BinarySearchRotated
{
	static int binSearch(int[] arr, int low, int high, int k)
	{
		if (low <= high) {
			int mid = (low + high) >>> 1;

			if (arr[mid] == k) {
				return mid;
			} else if (arr[low] < k) {
				return binSearch(arr, k, low, mid-1);
			} else {
				return binSearch(arr, k, mid+1, high);
			}
		}

		return -1;
	}

	public static void main(String[] args)
	{
		int[] arr = {5, 6, 7, 8, 1, 2, 3};
		System.out.println(binSearch(arr, 0, arr.length-1, 6));
	}
}
