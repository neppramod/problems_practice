import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = "a";
        String t = "a";
        int maxCost = 3;
        int result = getMax(s, t, maxCost);
        System.out.println(result);
    }

    static int getMax(String s, String t, int maxCost)
    {
        int sum = 0;
        int count = 0;
        int max = 0;
        int n = s.length();
        int start = 0;
        for (int i = 0; i < n; i++) {
            int cur = Math.abs(s.charAt(i) - t.charAt(i));

            /*
               sum = 2
             */

            if (cur + sum <= maxCost) {
                sum += cur;

                //System.out.println("I: " + i);
                max = Math.max(max, i+1 - start);
            } else {
                while (cur + sum > maxCost) {
                    sum -= Math.abs(s.charAt(start) - t.charAt(start));
                    start++;
                }
                sum += cur;
                max = Math.max(max, i+1 - start);

            }
        }

        return max;
    }
}
