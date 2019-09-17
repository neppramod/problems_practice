import java.util.*;

public class SmallestRange
{
    static void printSmallestRangeNaive(int[][] arr, int n, int k) {

        int[] ptr = new int[k];   // used to track how many elements from each list have been used, if index reaches k, we are done

        Arrays.fill(ptr, 0);

        int minimum_range = Integer.MAX_VALUE;
        int min_element = Integer.MAX_VALUE;
        int max_element = Integer.MIN_VALUE;
        boolean flag = false;
        int index_to_move = -1;

        while(true) {
            int current_min_element = Integer.MAX_VALUE;
            int current_max_element = Integer.MIN_VALUE;

            for (int i = 0; i < k; i++) {
                if (ptr[i] == n) {  // we have reached end of one of the list
                    flag = true;
                    break;  // break for loop
                } else if (ptr[i] < n && arr[i][ptr[i]] < current_min_element) {
                    index_to_move = i;
                    current_min_element = arr[i][ptr[i]];
                } else if (ptr[i] < n && arr[i][ptr[i]] > current_max_element) {
                    current_max_element = arr[i][ptr[i]];
                }
            }

            if (flag) {
                break;   // break while loop
            }

            // move ptr[i] for index_to_move to next index. This is the index of minimum element among all k arrays for current index
            ptr[index_to_move]++;

            // update minimum_range
            if (current_max_element - current_min_element < minimum_range) {
                minimum_range = current_max_element - current_min_element;

                // make these global min and max element
                min_element = current_min_element;
                max_element = current_max_element;
            }
        }

        System.out.printf("Smallest range is [%d, %d]\n", min_element, max_element);
    }

    private static class MinHeapNode implements Comparable<MinHeapNode>
    {
        int element;    // element to be stored
        int i;          // index of the list from which element is taken
        int j;          // index of next element to be picked from the list row i

        public int compareTo(MinHeapNode n)
        {
            return element - n.element;
        }
    }

    // This function takes an k sorted lists in the form of
    // 2D array as an argument. It finds out smallest range
    // that includes elements from each of the k lists.
    static void printSmallestRangeMinHeap(int[][] arr, int N, int k)
    {

        // Create a min heap with k heap nodes. Every heap node
        // has first element of ith list
        int range = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int start=0, end=0;

        PriorityQueue<MinHeapNode> minHeap = new PriorityQueue<>();
        MinHeapNode[] nodes = new MinHeapNode[k];
        for (int i = 0; i < k; i++) {
            nodes[i] = new MinHeapNode();
            nodes[i].element = arr[i][0];      // store first element of the list
            nodes[i].i = i;                    // index of the list
            nodes[i].j = 1;                    // index of next element

            // store max element
            if (nodes[i].element > max) {
                max = nodes[i].element;
            }

            minHeap.add(nodes[i]);
        }

        while(true) {
            MinHeapNode root = minHeap.poll();

            // update min
            min = root.element;

            // update range
            if (range > max - min + 1) {
                range = max - min + 1;
                start = min;
                end = max;
            }

            // Find the next element that will replace current root of the heap, it will be next element of same list as current root
            if (root.j < N) {
                root.element = arr[root.i][root.j];   // next element on same list
                root.j = root.j + 1;

                // update max
                if (root.element > max) {
                    max = root.element;
                }
            } else {
                break;    // break if we have reached end of any list
            }

            minHeap.add(root);
        }

        System.out.printf("Smallest range from Min Heap is [%d, %d]", start, end);
    }

    public static void main(String[] args)
    {
        int arr[][] = {
            {4, 7, 9, 12, 15},
            {0, 8, 10, 14, 20},
            {6, 12, 16, 30, 50}
        };

        printSmallestRangeNaive(arr, 5, arr.length);
        printSmallestRangeMinHeap(arr, 5, arr.length);
    }
}
