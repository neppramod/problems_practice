import java.util.*;

public class MergeKSorted
{
    static class MinHeapNode implements Comparable<MinHeapNode>
    {
        int element;
        int i; // index of array from which it is picked
        int j; // index of next element to be picked from array

        public MinHeapNode(int el, int i1, int j1)
        {
            element = el;
            i = i1;
            j = j1;
        }

        public int compareTo(MinHeapNode n)
        {
            if (element < n.element) {
                return -1;
            } else if (element > n.element) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    static PriorityQueue<MinHeapNode> minHeap = new PriorityQueue<>();

    static void mergeKSortedArrays(int[][] arr)
    {
        int k = arr.length;
        int n = 0;
        for (int i = 0; i < k; i++) {
            n += arr[i].length;
            minHeap.add(new MinHeapNode(arr[i][0], i, 1));
        }

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            MinHeapNode root = minHeap.poll();
            result[i] = root.element;

            // Find the next element that will replace current root of heap. The next element belongs to same array as current root
            if (root.j < arr[root.i].length) {
                root.element = arr[root.i][root.j++];
            } else {  // If root was last element of its array
                root.element =Integer.MAX_VALUE;
            }

            minHeap.add(root);
        }

        System.out.println(Arrays.toString(result));
    }

    public static void main(String args[]){
        int[][] arr= {{2, 6, 12, 34},
                      {1, 9, 20, 1000, 2001, 2004},
                      {23, 34, 90, 2000}};

        System.out.println("Merged array is :");

        mergeKSortedArrays(arr);
    }
}
