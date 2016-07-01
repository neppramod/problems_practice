// Maximum of all sub array of size k

import java.util.*;
public class MaxOfSubArray
{
    static void printMax(int[] arr, int k)
    {
        Queue<Integer> queue = new PriorityQueue<>(50, Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            queue.add(arr[i]);
        }

        for (int i = 0; i <= arr.length-k; i++) {
            System.out.print(queue.peek() + " ");
								
            int element = queue.peek();
            if (element == arr[i]) {
                queue.poll();
            }

			if (i < arr.length-k)
	            queue.add(arr[i+k]);	
        }
    }

    public static void main(String[] args)
    {
        int[] arr = {3, 9, 7, 2, 8, 5, 4};
        int k = 3;
        printMax(arr, k);
    }
}

