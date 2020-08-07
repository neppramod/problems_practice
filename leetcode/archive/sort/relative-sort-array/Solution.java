import java.util.*;

public class Solution
{
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};

        int[] result = relativeSortArray(arr1, arr2);

        System.out.println(Arrays.toString(result));

    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], 0);
        }

        List<Integer> notFoundList = new ArrayList<>();

        for (int i = 0; i < arr1.length; i++) {
            if (map.containsKey(arr1[i])) {
                map.put(arr1[i], map.get(arr1[i]) + 1);
            } else {
                notFoundList.add(arr1[i]);
            }
        }

        int[] arr = new int[arr1.length];
        int i = 0;

        for (int j = 0; j < arr2.length; j++) {
            int k = map.get(arr2[j]);

            while (k > 0) {
                arr[i] = arr2[j];
                i++;
                k--;
            }
        }

        // rest in ascending order
        Collections.sort(notFoundList);

        for (int l : notFoundList) {
            arr[i] = l;
            i++;
        }

        return arr;

    }


    static void pA1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%3d", arr[i]);
        }
        System.out.println();
    }

    static void pA2(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            pA1(arr[i]);
        }
    }
}
