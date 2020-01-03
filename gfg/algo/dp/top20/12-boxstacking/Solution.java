import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Box[] arr = new Box[4];
        arr[0] = new Box(4, 6, 7);
        arr[1] = new Box(1, 2, 3);
        arr[2] = new Box(4, 5, 6);
        arr[3] = new Box(10, 12, 32);

        System.out.println(maxStackHeight(arr));


    }

    static class Box implements Comparable<Box>{
        int h, w, d, area;

        public Box(int h1, int w1, int d1) {
            h = h1;
            w = w1;
            d = d1;
            area = w * d;
        }

        public int compareTo(Box o) {
            return o.area - area;
        }
    }

    static int maxStackHeight(Box[] arr) {
        int n = arr.length;
        Box[] rot = new Box[n*3];

        for (int i = 0; i < n; i++) {
            Box b = arr[i];
            rot[3 * i] = new Box(b.h, b.w, b.d);
            rot[3 * i + 1] = new Box(b.w, b.d, b.h);
            rot[3 * i + 2] = new Box(b.d, b.h, b.w);
        }

        Arrays.sort(rot);

        int count = 3 * n;
        int[] dp = new int[count];

        for (int i = 0; i < count; i++) {
            dp[i] = rot[i].h;
        }

        int best = 0;
        for (int i = 0; i < count; i++) {
            Box cur = rot[i];
            for (int j = 0; j < i; j++) {
                Box prev = rot[j];
                if (cur.w < prev.w && cur.d < prev.d) {
                    dp[i] = Math.max(dp[i], dp[j] + cur.h);
                    best = Math.max(best, dp[i]);
                }
            }
        }
        return best;
    }
}
