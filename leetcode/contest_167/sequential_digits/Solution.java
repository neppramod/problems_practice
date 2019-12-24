import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long low = sc.nextLong();
        long high = sc.nextLong();
        System.out.println(sequentialDigits(low, high));

    }

    static public List<Long> sequentialDigits(long low, long high) {
        long low1 = low/10;
        long high1 = Math.min(high, 123456789);

        long num = low1;

        List<Long> list = new ArrayList<>();
        while (num < high1) {
            num = getSequence(num);
            //System.out.println(num);
            if (num >= low && num <= high) {
                list.add(num);
            }

        }

        return list;
    }

    static long getSequence(long num) {
        int numberOfDigits = (int)Math.log10(num) + 1;

        long tenPow = (long)Math.pow(10, numberOfDigits-1);
        long firstDigit = num/tenPow;

        StringBuilder sb = new StringBuilder();
        if (9 - firstDigit < numberOfDigits) {
            for (int i = 0; i <= numberOfDigits; i++) {
                sb.append(i+1);
            }
        } else {
            firstDigit = firstDigit+1;
            for (int i = 0; i < numberOfDigits; i++) {
                sb.append(firstDigit);
                firstDigit++;
            }
        }

        return Long.valueOf(sb.toString());
    }


}


/*
  t:
  8511
  23553
 */
