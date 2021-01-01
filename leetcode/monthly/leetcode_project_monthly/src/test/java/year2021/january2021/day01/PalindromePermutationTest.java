package year2021.january2021.day01;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class PalindromePermutationTest {

	@Test
	public void testExamples() {
		PalindromePermutation palindromePermutation = new PalindromePermutation();
		assertThat(palindromePermutation.canPermutePalindrome("code"), is(false));
		assertThat(palindromePermutation.canPermutePalindrome("aab"), is(true));
		assertThat(palindromePermutation.canPermutePalindrome("carerac"), is(true));
		assertThat(palindromePermutation.canPermutePalindrome("AaBb//a"), is(false));
	}

	
}
