import java.util.*;

public class PalindromePermutation14
{
    public static boolean palindromePermutation(String str)
    {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                continue;
            
            if (!map.containsKey(str.charAt(i) + "")) {
                map.put(str.charAt(i) + "", 1);
            } else {
                map.remove(str.charAt(i) + "");
            }
        }

        if (map.size() > 1) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args)
    {
        System.out.println(palindromePermutation("tact coa"));
        System.out.println(palindromePermutation("tacp coa"));
    }
}
