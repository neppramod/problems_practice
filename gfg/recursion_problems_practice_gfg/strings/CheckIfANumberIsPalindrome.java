import java.util.*;

/*
  Here, we will use log10 to get power of 10s and create a divisor using pow of 10
  This we we can get the left digit with num / div and right with num % 10
  Now we need to reduce the number 1 less from both left and right
  To remove left we need to subtract left * div E.g.
  523215 - 5 * 100000 = 23215

  To take out the right 5, we need to divide it by 10
  For next iteration, div is now 2 00s less
 */

public class CheckIfANumberIsPalindrome {
    public static void main(String[] args) {
	    CheckIfANumberIsPalindrome sol = new CheckIfANumberIsPalindrome();
		int num = 12321;
		sol.printIsPalindrome(num);
	}
	
    public void printIsPalindrome(int num) {
		int p = (int)Math.log10(num);
		int div = (int) Math.pow(10, p);
		printIsPalindrome(num, div);
	}

	private void printIsPalindrome(int num, int div) {
		if (num < 10) {
			System.out.println("True");
		} else {
			int l = num / div;
			int r = num % 10;
			if (l != r) {
				System.out.println("False");
				return;
			} else {
				printIsPalindrome((num - l * div) / 10, div / 100);  
			}
		}
	}
}
