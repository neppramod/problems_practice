import java.util.*;

public class KthLargest
{
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static int kthLargest(int e, int k)
    {
        if (minHeap.size() < k) {
            minHeap.add(e);
        } else {
            if (e > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(e);
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args)
    {
        int[] arr ={10, 20, 11, 70, 50, 40, 100, 5};
        for (int i = 0; i < arr.length; i++) {
            p(kthLargest(arr[i], 3));
        }
    }

    private static void p(int number)
    {
        System.out.println(number);
    }
}
