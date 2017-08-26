import java.util.*;

public class ChangAndBitwiseOr
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[] nums = new int[N];

            for (int j = 0; j < N; j++) {
                nums[j] = sc.nextInt();
            }

            int output = 0;
            if (N > 0)
                output = nums[0];
            
            for (int j = 1; j < N; j++)
                output |= nums[j];
            
            System.out.println(output);
        }
    }
}