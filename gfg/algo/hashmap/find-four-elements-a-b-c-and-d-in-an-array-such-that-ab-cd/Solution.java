import java.util.*;

public class Solution
{
    class Pair
    {
        int first,second;
        Pair(int f, int s) { first = f; second = s; }
    }

    void findPairs(int[] arr) {
        HashMap<Integer, Pair> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (!map.containsKey(sum)) {
                    map.put(sum, new Pair(arr[i], arr[j]));
                } else {
                    Pair pair = map.get(sum);
                    System.out.printf("%d %d %d %d", arr[i], arr[j], pair.first, pair.second);
                    System.exit(0);
                }
            }
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Solution solution = new Solution();
        int arr[] = {3, 4, 7, 1, 2, 9, 8};
        solution.findPairs(arr);
    }
}
