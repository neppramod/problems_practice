import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


            String s = sc.next();

            System.out.println(getMaxEvenStringLength(s));

    }

    private static int getMaxEvenStringLength(String s)
    {
        int N = s.length();

        int ans = 0;

        for (int i = 0; i < N-1; i++) {
            int l = i;
            int r = i+1;

            int lSum = 0, rSum = 0;
            while (l >= 0 && r < N) {
                lSum += Character.getNumericValue(s.charAt(l));
                rSum += Character.getNumericValue(s.charAt(r));
                int length = r-l+1;
                if (lSum == rSum && length > ans) ans = length;

                l--; r++;
            }
        }

        return ans;
    }
}
