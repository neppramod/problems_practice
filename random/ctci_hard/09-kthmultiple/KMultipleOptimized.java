import java.util.*;

public class KMultipleOptimized
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        System.out.printf("Kth multiple of %d is %d\n", k, kthMultiple(k));
    }


    private static int kthMultiple(int k)
    {
        Queue<Integer> q3 = new LinkedList<>();
        Queue<Integer> q5 = new LinkedList<>();
        Queue<Integer> q7 = new LinkedList<>();

        q3.add(1); // add first value to queue

        int val = Integer.MAX_VALUE;

        for (int i = 0; i < k; i++) {
            int v3 = q3.size() > 0 ? q3.peek() : Integer.MAX_VALUE;
            int v5 = q5.size() > 0 ? q5.peek() : Integer.MAX_VALUE;
            int v7 = q7.size() > 0 ? q7.peek() : Integer.MAX_VALUE;


            val = Math.min(v3, Math.min(v5, v7));
            if (val == v3) {
                q3.poll();
                q3.add(val * 3);
                q5.add(val * 5);
                q7.add(val * 7);
            } else if (val == v5) {
                q5.poll();
                q5.add(val * 5);
                q7.add(val * 7);
            } else {
                q7.poll();
                q7.add(val * 7);
            }
        }

        return val;
    }
}
