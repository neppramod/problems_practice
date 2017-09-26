import java.util.*;
import java.math.*;

public class FCTRL2
{
    public static BigInteger fact(int n) {
        BigInteger res = new BigInteger(1+"");
        for (int i = 2; i <= n; i++) {
            res = res.multiply(new BigInteger(i+""));
        }
        return res;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            System.out.println(fact(n).toString());
        }
    }
}
