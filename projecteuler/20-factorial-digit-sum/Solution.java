import java.util.*;
import java.math.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = 100;
        BigDecimal bd = new BigDecimal(1);
        for (int i = 2; i <= 100; i++) {
            bd = bd.multiply(new BigDecimal(i + ""));
        }

        String bdStr = bd.toString();
        int sum = 0;
        for (char ch : bdStr.toCharArray()) {
            sum += (ch - '0');
        }

        System.out.println(sum);
    }
}
