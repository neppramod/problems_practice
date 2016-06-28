public class MagicIndexBinary
{
    int binSearch(int[] arr)
    {
        int low = 0, high = arr.length-1;
        return binSearch(arr, low, high);
    }

    int binSearch(int[] arr, int low, int high)
    {
        if (high < low)
            return -1;

        int mid = (low + high) / 2;
        if (arr[mid] == mid) {
            return mid;
        }

        
        int leftIndex = Math.min(mid-1, arr[mid]);
        int left = binSearch(arr, low, leftIndex);
        if (left >= 0)
            return left;
        
        int rightIndex = Math.max(mid+1, arr[mid]);
        int right = binSearch(arr, rightIndex, high);
        
        return right;

    }

    public static void main(String[] args)
    {
        MagicIndexBinary mib = new MagicIndexBinary();
        int[] array = {-7, -3, -1, 0, 3, 5};
        System.out.println(mib.binSearch(array));
        System.out.println(mib.binSearch(new int[]{-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13}));
        System.out.println(mib.binSearch(new int[]{-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13}));

    }
}
