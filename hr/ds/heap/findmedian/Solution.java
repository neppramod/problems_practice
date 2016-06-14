import java.util.*;

public class Solution
{
    public static void printmedian(int[] arr)
    {

        if (arr == null || arr.length == 0)
            return;

        Queue<Integer> min = new PriorityQueue<>();
        Queue<Integer> max = new PriorityQueue<>(50, 
                                                 Collections.reverseOrder());

        min.add(arr[0]);
        double median = arr[0];

        
        System.out.printf("%.1f\n", median);
        if (arr.length == 1)
            return;

        int minSize = 1;
        int maxSize = 0;

        for (int i = 1; i < arr.length; i++) {
            int element = arr[i];

            if (element > median) {
                min.add(element);
            } else {
                max.add(element);
            }

            minSize = min.size();
            maxSize = max.size();
            
            if (minSize >= maxSize + 1) {
                max.add(min.poll());
                minSize--;
                maxSize++;
            } else if (maxSize >= minSize + 1) {
                min.add(max.poll());
                minSize++;
                maxSize--;
            }

            //System.out.println(min);
            //System.out.println(max);

            if (minSize == maxSize) {                
                median = ((double)(min.peek() + max.peek()))/2.0;
            } else if (minSize > maxSize) {
                median = min.peek();
            } else {
                median = max.peek();
            }
            System.out.printf("%.1f\n", median);
        }
    }

    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        //int[] arr = {94455,20555,20535,53125,73634,148};
        printmedian(arr);

        /*
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        printmedian(arr);
        */
    }
}
