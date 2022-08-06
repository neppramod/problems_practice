import java.util.*;

/*
  Given a string, print all possible palindromic partitions
  E.g. nitin -> n i t i n, n iti n, nitin

  Here we will generate substring of different size, and check if that is palindrome
  Size of each palindrome word will lead to start for next word
 */
public class PrintAllPossiblePalindromicPartitions {
    public static void main(String[] args) {
	    PrintAllPossiblePalindromicPartitions sol = new PrintAllPossiblePalindromicPartitions();
		String s = "nitin";
		sol.printPossiblePartitions(s);
	}
	
    public void printPossiblePartitions(String s) {
		List<String> tmp = new ArrayList<>();
		printPossiblePartitions(s, 0, s.length(), tmp);
	}

	private void printPossiblePartitions(String s, int start, int end, List<String> tmp) {
		if (start >= end) {
			System.out.println(tmp);
		} else {
			for (int i = start; i < end; i++) {
				if (isPalindrome(s, start, i)) {
					tmp.add(s.substring(start, i + 1));
					printPossiblePartitions(s, i + 1, end, tmp);
					tmp.remove(tmp.size() - 1);
				}
			}
		}
	}

	private boolean isPalindrome(String s, int l, int r) {
		while (l < r) {
			if (s.charAt(l) != s.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}

		return true;
	}
}
