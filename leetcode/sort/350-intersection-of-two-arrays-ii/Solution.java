import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr1 = {4, 9, 5};
        int[] arr2 = {9,4,9,8,4};

        int[] arr = intersection(arr1, arr2);
        System.out.println(Arrays.toString(arr));



    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums1) {
            if (!map.containsKey(n)) {
                map.put(n, 1);
            } else {
                map.put(n, map.get(n) + 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int n : nums2) {
            if (map.containsKey(n)) {
                list.add(n);
                if (map.get(n) == 1) {
                    map.remove(n);
                } else {
                    map.put(n, map.get(n) - 1);
                }
            }
        }

        int[] arr = new int[list.size()];
        int i = 0;
        for (int n : list) {
            arr[i] = n;
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
