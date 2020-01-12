import java.util.*;

/*

when i = 0
[a, b] = [nums[2 * 0], nums[2 * 0 + 1]]
=> [nums[0], nums[1]]
=> [1 element with value 2]

when i = 1
nums[2 * 1], nums[2 * 1 + 1]
nums[2], nums[3]

3 => 4s

 */

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = {1, 2, 3, 4};
        System.out.println(Arrays.toString(decompressRLElist(arr)));

    }

    public static int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        int N = nums.length;

        for (int i = 0; i < N; i++) {
            int aI = 2 * i;
            int bI = 2 * i + 1;

            if (bI >= N) {
                break;
            }

            int a = nums[aI];
            int b = nums[bI];

            //System.out.printf("%d, %d\n", a, b);
            while(a > 0) {
                    list.add(b);
                    a--;
            }


        }
        int[] vals = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            vals[i] = list.get(i);
        }

        return vals;
    }
}
