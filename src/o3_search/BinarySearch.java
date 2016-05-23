package o3_search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {2,3,6,9,12,15,19,23,45};
        System.out.println("Found at index: " + binarySearch(array, 0, array.length - 1, 19));
    }

    private static int binarySearch(int[] array, int first, int last, int v)
    {
        if (last < first) {
            return -1;
        }

        int mid = (first + last) / 2;

        if (v == array[mid]) {
            return mid;
        } else if (v < array[mid]) {
            return binarySearch(array, first, mid-1, v);
        } else {
            return binarySearch(array, mid+1, last, v);
        }
    }
}
