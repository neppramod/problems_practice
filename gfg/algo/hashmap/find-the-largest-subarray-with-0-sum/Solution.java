import java.util.*;

public class Solution
{

    private static int max_subarray(int[] arr) {
        int max_length = 0;
        long sum = 0;

        HashMap<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (max_length == 0 && arr[i] == 0) max_length = 1;

            Integer prev = map.get(sum);

            if (prev != null) {
                max_length = (int)Math.max(max_length, i-prev);
            } else {
                map.put(sum, i);
            }
        }

        return max_length;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        int max_length = max_subarray(arr);
        System.out.println("Length: '" + max_length + "'");
    }
}
