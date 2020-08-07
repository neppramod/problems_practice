import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = {1, 0, -1, 0, -2, 2};
        int target = 0;

        List<List<Integer>> fourSum = fourSum(arr, target);

        for (List<Integer> l : fourSum) {
            System.out.println(l);
        }

    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> fourSum = new ArrayList<>();

        Arrays.sort(nums);
        int N = nums.length;

        for (int i = 3; i < N; i++) {
            for (int j = 0; j < i; j++) {

                for (int k = j + 2; k < i; k++) {
                    int curSum = target - (nums[j] + nums[k] + nums[i]);

                    int bin = binarySearch(nums, j+1, k-1, curSum);
                    if (bin != -1) {
                        List l = Arrays.asList(nums[j], nums[bin], nums[k], nums[i]);
                        if (!fourSum.contains(l)) {
                            fourSum.add(l);
                        }
                    }
                }
            }
        }

        return fourSum;
    }

    static int binarySearch(int[] arr, int i, int j, int x) {

        while (i <= j) {
            int m = i + (j-i) / 2;
            if (arr[m] == x) {
                return m;
            } else if (arr[m] < x) {
                i = m+1;
            } else {
                j = m-1;
            }
        }

        return -1;
    }

}
