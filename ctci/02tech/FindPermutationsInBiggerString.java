import java.util.*;

public class FindPermutationsInBiggerString
{
    static ArrayList<String> permutations(String b, String s)
    {
	ArrayList<String> results = new ArrayList<String>();
	
	for (int i = 0; i < b.length() - s.length() + 1; i++) {	    
	    if (existsIn(b.charAt(i), s) &&
		isPermutation(b.substring(i, i+s.length()), s)) {
		results.add(b.substring(i, i+s.length()));
	    }
	}

	return results;
    }

    static boolean isPermutation(String s1, String s2)
    {
	char x = 0;
	for (int i = 0; i < s1.length(); i++) {
	    x^= s1.charAt(i);
	    x^= s2.charAt(i);
	}

	return x == 0 ? true: false;
    }

    static boolean existsIn(char c, String sc)
    {
	for (int i = 0; i < sc.length(); i++) {
	    if (sc.charAt(i) == c)
		return true;
	}

	return false;
    }

    public static void main(String[] args)
    {
	System.out.println(permutations("cbabadcbbabbcbabaabccbabc", "abbc"));
    }
}
