import java.util.*;

public class NearlySorted
{
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    static void sortNearlySorted(int[] arr, int k)
    {
        int n = arr.length;

        // insert first k+1 elements into minHeap, we assume k < n
        for (int i = 0; i < k+1; i++) {
            minHeap.add(arr[i]);
        }

        int index = 0; // current min
        for (int i = k+1; i < n; i++) {
            arr[index++] = minHeap.poll();   // extract minimum element from heap and put it in array
            minHeap.add(arr[i]);            // add new element into minHeap
        }

        // Extract remaining k elements from heap
        while (!minHeap.isEmpty()) {
            arr[index++] = minHeap.poll();
        }
    }

    public static void main(String[] args)
    {
        int arr[] = { 2, 6, 3, 12, 56, 8 };
        sortNearlySorted(arr, 3);


        System.out.println(Arrays.toString(arr));
    }
}
