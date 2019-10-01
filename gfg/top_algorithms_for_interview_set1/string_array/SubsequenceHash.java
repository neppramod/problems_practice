import java.util.*;

public class SubsequenceHash
{
    static HashSet<String> set = new HashSet<>();
    static long counter = 0;

    static void subsequence(String str)
    {
        // iterate over the entire string
        for (int i = 0; i < str.length(); i++) {
            // iterate from end of the string to generate substrings
            for (int j = str.length(); j > i; j--) {


                String sub_str = str.substring(i, j);

                if (!set.contains(sub_str)) {
                    set.add(sub_str);
                }

                // drop kth character in sub_str and if it is not in the set recur
                for (int k = 1; k < sub_str.length(); k++) {
                    counter++;
                    StringBuilder sb = new StringBuilder(sub_str);

                    // drop character from string
                    sb.deleteCharAt(k);
                    if (!set.contains(sb.toString())) {
                        subsequence(sb.toString());
                    }

                }
            }
        }
    }

    public static void main(String[] args)
    {
        String str = "0000001111011011110000";
        subsequence(str);
        System.out.println(set.size());
        System.out.println("Counter: " + counter);
    }
}
