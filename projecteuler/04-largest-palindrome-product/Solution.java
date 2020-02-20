import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int result = largestPalindrome3Digits();

        System.out.println(result);

        boolean isPalindrome = isPalindrome(906609);
        System.out.println(isPalindrome);

    }

    static int largestPalindrome3Digits()
    {
        int max = 0;
        for (int i = 999; i >= 100; i--) {
            for (int j = 999; j >= 100; j--) {
                if (i == 993 && j == 913) {
                    System.out.println("Found: " );
                }
                int product = i * j;
                if (isPalindrome(product)) {
                    max = Math.max(max, product);
                }
            }
        }
        return max;
    }

    static boolean isPalindrome(int num)
    {
        String numVal = String.valueOf(num);
        int i = 0, j = numVal.length() - 1;
        while (i < j) {
            if (numVal.charAt(i) != numVal.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
