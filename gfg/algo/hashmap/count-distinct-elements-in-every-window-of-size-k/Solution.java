import java.util.*;

public class Solution
{


    static void printDistinctElements(int[] arr, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
                count++;
            }
        }

        System.out.println(count);

        for (int i = k; i < arr.length; i++) {
            int outsideElementCount = map.get(arr[i-k]);
            if (outsideElementCount == 1) {
                map.remove(arr[i-k]);
                count--;
            } else {
                map.put(arr[i-k], map.get(arr[i-k]) - 1);
            }

            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
                count++;
            }

            System.out.println(count);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;

        printDistinctElements(arr, k);

    }
}
