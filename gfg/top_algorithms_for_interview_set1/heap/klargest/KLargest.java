import java.util.*;

public class KLargest
{
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    static void kLargest(int[] arr, int k)
    {
        int n = arr.length;
        for (int i = 0; i < k; i++) {
            minHeap.add(arr[i]);
        }

        for (int i = k; i < n; i++) {
            if (arr[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }

        // if sorting is required poll k times
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }
    }

    public static void main(String[] args)
    {
        int[] arr = { 11, 3, 2, 1, 15, 5, 4,
                      45, 88, 96, 50, 45 };
        int k = 3;
        kLargest(arr, k);
    }
}
