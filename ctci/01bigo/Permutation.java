import java.util.*;

public class Permutation
{
    static ArrayList<String> result = new ArrayList<>();
    
    public static void permutation(String str)
    {
	permutation(str, "");
    }

    private static void permutation(String str, String prefix)
    {
	if (str == null || prefix == null)
	    return;

	if (str.length() == 0) {
	    result.add(prefix);
	} else {
	    for (int i = 0; i < str.length(); i++) {
		char curChar = str.charAt(i);
		String remainder = str.substring(0, i) + str.substring(i+1);
		permutation(remainder, prefix + curChar);
	    }
	}
	    
    }

    public static void main(String[] args)
    {
	permutation("abcd");
	Collections.sort(result);
	System.out.println(result);
    }
}
