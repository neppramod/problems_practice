import java.util.*;
import java.math.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BigDecimal bd = new BigDecimal("2");
        BigDecimal ans = bd.pow(1000);
        int s = sum(ans);
        System.out.println(s);
    }

    static int sum(BigDecimal num)
    {
        String st = num.toString();
        int ans = 0;
        for (char ch : st.toCharArray()) {
            ans += (ch - '0');
        }

        return ans;
    }
}
