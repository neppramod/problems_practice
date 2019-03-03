import java.math.*;
import java.util.*;

public class CLTZ
{
    static BigInteger[] bI = new BigInteger[2000];
    static int calc(BigInteger n)
    {
        if (n.equals(new BigInteger("0"))) return 0;
        if (n.equals(new BigInteger("1"))) return 1;

        bI[1] = new BigInteger(n + "");
        for (int i = 2; i < bI.length; i++) {
            BigInteger prev = bI[i-1];
            BigDecimal mod = new BigDecimal(prev.mod(new BigInteger("2")));
            BigDecimal first = new BigDecimal("2.5").multiply(mod).add(new BigDecimal("0.5"));
            BigDecimal firstMult = first.multiply(new BigDecimal(prev));
            BigDecimal value = firstMult.add(mod);

            BigInteger valueInt = value.toBigInteger();
            if (valueInt.equals(new BigInteger("1"))) return i;

            bI[i] = valueInt;

            if (bI[i].compareTo(bI[i-1]) > 0)
                return i-1;

        }

        return 0;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String next = sc.next();
            BigInteger n = new BigInteger(next);
            System.out.println(calc(n));
        }
    }
}
