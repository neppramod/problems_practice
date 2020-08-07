import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        int[] arr = {17,18,5,4,6,1};
        System.out.println(Arrays.toString(replaceElements(arr)));
    }

    public static int[] replaceElements(int[] arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        int N = arr.length;
        queue.add(arr[N-1]);
        arr[N-1] = -1;

        for (int i = N-2; i >= 0; i--) {
            int top = queue.peek();
            int cur = arr[i];
            arr[i] = top;
            queue.add(cur);
        }

        return arr;
    }

}
