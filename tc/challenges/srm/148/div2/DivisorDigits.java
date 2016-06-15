public class DivisorDigits
{
    public int howMany(int number)
    {
        String numberStr = number + "";
        String[] numberStrArr = numberStr.split("");
        int count = 0;

        for (int i = 0; i < numberStrArr.length; i++) {
            int divisor = Integer.parseInt(numberStrArr[i]);

            if (divisor > 0 && number % divisor == 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args)
    {
        DivisorDigits dd = new DivisorDigits();
        System.out.println(dd.howMany(3027));
    }
}
