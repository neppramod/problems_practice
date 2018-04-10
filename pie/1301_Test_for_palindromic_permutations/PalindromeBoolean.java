import java.util.*;

/*
  WAP to test whether the letter forming a string can be permuted to form a palindromeboolean

  ----
  Create boolean array of size 26
  1. if arr[c-'a'] == true, set to false else set to true
  2. Count all array and if size of true is more than 1 break and return false

  Assuming all lower case
*/

public class PalindromeBoolean
{
    public static boolean isPalindrome(String str)
    {
        if (str == null) return false;

        char[] cstr = str.toCharArray();
        boolean[] arr = new boolean[26]; // english alphabet size

        for (int i = 0; i < cstr.length; i++) {
            if (arr[cstr[i]-'a'] == false)
                arr[cstr[i] - 'a'] = true;
            else
                arr[cstr[i] - 'a'] = false;
        }

        return isPalindrome(arr);
    }

    private static boolean isPalindrome(boolean[] arr)
    {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == true) count++;
            if (count > 1) return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        System.out.println(isPalindrome(args[0]));
    }
}
