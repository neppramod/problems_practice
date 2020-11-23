import java.util.*;

/*
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;
*/


public class CheckTwoStringArraysEquivalent {

	public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
		if (word1 == null || word2 == null) {
			return false;
		}

		//Arrays.sort(word1);
		//Arrays.sort(word2);

		String s1 = getConcatenatedString(word1);
		String s2 = getConcatenatedString(word2);

		return s1.equals(s2);
	}

	private String getConcatenatedString(String[] words) {
		StringBuilder sb = new StringBuilder();
		for (String w : words) {
			sb.append(w);
		}

		return sb.toString();
	}


    public static void main(String[] args) {
	    CheckTwoStringArraysEquivalent sol = new CheckTwoStringArraysEquivalent();

		// expected true
		String[] word1 = {"jbboxe","yshcrtanrtlzyyp","vudsssnzuef","lde"};
		String[] word2 = { "jbboxeyshcrtanrt", "lzyypvudsssnzueflde" };

		System.out.println(sol.arrayStringsAreEqual(word1, word2));

	   
	}
	

}
