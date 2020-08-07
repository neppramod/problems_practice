import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> threeSum = threeSum(arr);

        for (List<Integer> l : threeSum) {
            System.out.println(l);
        }

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> threeSum = new ArrayList<>();

        Arrays.sort(nums);
        int N = nums.length;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                int curSum = nums[i] + nums[j];
                int binIndex = binarySearch(nums, j+1, i-1, -curSum);
                if (binIndex != -1) {
                    List l = Arrays.asList(nums[j], nums[binIndex], nums[i]);
                    if (!threeSum.contains(l)) {
                        threeSum.add(Arrays.asList(nums[j], nums[binIndex], nums[i]));
                    }
                }
            }
        }

        return threeSum;
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
