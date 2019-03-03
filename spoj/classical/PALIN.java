import java.util.*;
import java.math.*;

public class PALIN
{
    static String getpalindrome(String s)
    {
        if (s.length == 1) return s;

        String firstHalfString = s.substring(0, s.length/2);


        String secondHalfString = s.substring(s.length/2, s.length);
        if (secondHalfString.length() > firstHalf)
            secondHalfString = secondHalfString.substring(1);

        BigInteger firstHalf = new BigInteger(firstHalfString);
        BigInteger secondHalf = new BigInteger(secondHalfString);

        StringBuilder finalSB = new StringBuilder();
        if (firstHalf.compareTo(secondHalf) > 0) {
            finalSB.append(firstHalf);
            finalSB.append()
                }

        int length = sn.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append("9");
        }
        BigInteger max = new BigInteger(sb.toString());

        for (BigInteger bi = add1; bi.compareTo(max) <= 0; bi = bi.add(BigInteger.ONE)) {
            String s1 = bi.toString();
            StringBuilder sr = new StringBuilder(s1).reverse();
            if (s1.equals(sr.toString())) return bi;

        }

        // invalid
        return n;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            String s = sc.next();
            System.out.println(getpalindrome(s));
        }
    }
}
