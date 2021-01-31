import java.util.*;

public class Solution
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = "babad";
        String result = longestPalindrome(s);

        System.out.println(result);

    }

    public static String longestPalindrome(String s) {
        char[] sc = s.toCharArray();
        int n = sc.length;
        int maxlength = 0;
        String result = "";
        for (int i = 0; i < n; i++) {
            for (int j = n-1; j >= i; j--) {
                if (isPalindrome(sc, i, j) && (j-i+1 > maxlength)) {
                    result = s.substring(i, j+1);
                    maxlength = j-i+1;
                }
            }
        }

        return result;
    }

    static boolean isPalindrome(char[] sc, int i, int j) {
        while (i < j) {
            if (sc[i] != sc[j]) {
                return false;
            }
            i++; j--;
        }
        return true;
    }

    static void pA1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%3d", arr[i]);
        }
        System.out.println();
    }

    static void pA2(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            pA1(arr[i]);
        }
    }
}
