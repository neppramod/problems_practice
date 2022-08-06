import java.util.*;

/*
  Here, since character at 0 is multipled by that many zeros, we need to call recursion first
  and handle current character only after that.

  Recursion does not return until i becomes 0, and after that the generated numer (at index 0) is multiplied by 10
  and subsequence character is added, and in next iteration this sum is multiplied by 10 and so on.
 */

public class Atoi {
    public static void main(String[] args) {
	    Atoi sol = new Atoi();
		String s = "12345";
		System.out.println(sol.atoi(s));	   
	}

	public int atoi(String s) {
		return atoi(s, s.length() - 1);
	}


	private int atoi(String s, int i) {
		if (i == 0) {
			return s.charAt(i) - '0';
		} else {
			return 10 * atoi(s, i - 1) + s.charAt(i) - '0';
		}
	}
}





