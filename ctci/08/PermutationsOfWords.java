import java.util.*;

public class PermutationsOfWords
{
    static ArrayList<String> getPermutations(String word)
    {
	if (word == null)
	    return null;

	ArrayList<String> permutations = new ArrayList<>();

	// base case
	if (word.length() == 0) {
	    permutations.add("");
	    return permutations;
	}

	// We can now get rest of words and build all possible string permutations
	char curChar = word.charAt(0);
	String rem = word.substring(1);
	ArrayList<String> words = getPermutations(rem);

	for (String str : words) {
	    for (int i = 0; i <= str.length(); i++) {   // str we build is 1 more than current length
		String newWord = addChar(str, curChar, i);

		// if you want to check for duplicates
		// if not remove the check
		if (!permutations.contains(newWord))
		    permutations.add(newWord);
	    }
	}

	return permutations;
    }

    static String addChar(String str, char c, int i)
    {
	String firstHalf = str.substring(0, i);
	String secondHalf = str.substring(i);
	return firstHalf + c + secondHalf;
    }

    public static void main(String[] args)
    {
	String word = "adcd";
	System.out.println(getPermutations(word));
    }
}
