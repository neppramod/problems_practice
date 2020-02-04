import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr1 = {1,2,2,1};
        int[] arr2 = {2,2};

        int[] arr = intersection(arr1, arr2);
        System.out.println(Arrays.toString(arr));



    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int n : nums1) {
            if(!set1.contains(n)) {
                set1.add(n);
            }
        }

        HashSet<Integer> set2 = new HashSet<>();
        for (int n : nums2) {
            if (set1.contains(n) && !set2.contains(n)) {
                set2.add(n);
            }
        }

        int[] arr = new int[set2.size()];
        int i = 0;
        for (int n : set2) {
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
