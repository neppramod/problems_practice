package year2021.january2021.day01;


public class PalindromePermutation {

	/*
	  Although the problem does not specify I assume we could fit everything in an array of 512 length integer. Count each character in s, and now count number of odd frequencies. If the count is 0 or 1 return true, else false
	 */
	public boolean canPermutePalindrome(String s) {
        if (s == null) {
			return false;
		}

		if (s.length() == 0) {
			return true;
		}

		int[] frequency = new int[1024];

		for (char c : s.toCharArray()) {
			frequency[c]++;
		}

		int countOfOdd = 0;

		for (int i = 0; i < 1024; i++) {
			if (frequency[i] % 2 == 1) {
				countOfOdd++;
			}
		}

		return countOfOdd == 0 || countOfOdd == 1;
    }
}
