public class MaxSubArray
{
    public int maxSubArray(int[] nums)
    {
        int N = nums.length;
        int[] sum = new int[N+1];
        int max = nums[0];

        for (int i = 1; i <= N; i++) {
            sum[i] = Math.max(nums[i-1], sum[i-1] + nums[i-1]);
            max = Math.max(sum[i], max);
        }


        return max;
    }

    public static void main(String[] args)
    {
        MaxSubArray soln = new MaxSubArray();
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(soln.maxSubArray(arr));
    }
}
