import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //int[] arr = {1,1,-1,-1,3};
        //int target = -1;



         int[] arr = {87,6,-100,-19,10,-8,-58,56,14,-1,-42,-45,-17,10,20,-4,13,-17,0,11,-44,65,74,-48,30,-91,13,-53,76,-69,-19,-69,16,78,-56,27,41,67,-79,-2,30,-13,-60,39,95,64,-12,45,-52,45,-44,73,97,100,-19,-16,-26,58,-61,53,70,1,-83,11,-35,-7,61,30,17,98,29,52,75,-73,-73,-23,-75,91,3,-57,91,50,42,74,-7,62,17,-91,55,94,-21,-36,73,19,-61,-82,73,1,-10,-40,11,54,-81,20,40,-29,96,89,57,10,-16,-34,-56,69,76,49,76,82,80,58,-47,12,17,77,-75,-24,11,-45,60,65,55,-89,49,-19,4};
        int target = -275;

        int threeSum = threeSumClosest(arr, target);
        //System.out.println(binarySearch(arr, 1, 3, -4));

        System.out.println(threeSum);
    }


    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int N = nums.length;
        int threeSum = 1000000000;
        int diff = Integer.MAX_VALUE;

        for (int i = 2; i < N; i++) {
            for (int j = 0; j < i; j++) {
                int curSum = nums[i] + nums[j];
                int binIndex = binarySearch(nums, j+1, i-1, target - curSum);
                //System.out.printf("%d, %d, %d\n", j, binIndex, i);
                if (binIndex != -1) {
                    int sum = nums[j] + nums[binIndex] + nums[i];

                    //System.out.printf("%d, %d, %d: %d\n", nums[j], nums[binIndex], nums[i], sum);

                    if (Math.abs(target - sum) < Math.abs(threeSum - target)) {
                        threeSum = sum;
                    }
                }
            }
        }

        return threeSum;
    }


    // look towards the one that has least difference
    static int binarySearch(int[] arr, int l, int r, int x) {

        if (l > r) {
            return -1;
        }
        if (l == r) {
            return l;
        } else if (l + 1 == r) {
            int diff1 = Math.abs(x - arr[l]);
            int diff2 = Math.abs(arr[r] - x);
            if (diff1 < diff2) {
                return l;
            } else {
                return r;
            }
        }

        int m = (l + r) / 2;
        if (arr[m] == x) {
            return m;
        } else if (arr[m] < x) {
            return binarySearch(arr, m, r, x);
        } else {
            return binarySearch(arr, l, m, x);
        }

    }
}
