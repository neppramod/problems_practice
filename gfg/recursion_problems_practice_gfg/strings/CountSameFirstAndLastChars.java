import java.util.*;

/*
  Recursive solution to count substrings with same first and last characters

  We are given a string S, we need to find count of all contiguous substrings starting and ending with same character.

  Examples : 

  Input  : S = "abcab"
  Output : 7
  There are 15 substrings of "abcab"
  a, ab, abc, abca, abcab, b, bc, bca
  bcab, c, ca, cab, a, ab, b
  Out of the above substrings, there 
  are 7 substrings : a, abca, b, bcab, 
  c, a and b.

  Input  : S = "aba"
  Output : 4
  The substrings are a, b, a and aba
  
  We will use same technique as before, start, end
  However, here we at each iteration we check the values from i = start to end-1
  And call recursion only once for start + 1, instead of i + 1

  i+1 would generate a lot of duplicates

  Here we only want to move 1 character to right and do same thing with that substring
  i.e. print each substring starting from that character to the end at each recursion

  
*/

public class CountSameFirstAndLastChars {
    public static void main(String[] args) {
	    CountSameFirstAndLastChars sol = new CountSameFirstAndLastChars();
        String s1 = "abcab";
        sol.printCountSubstringSameFirstAndLastChars(s1);
        String s2 = "aba";
        sol.printCountSubstringSameFirstAndLastChars(s2);
	}

    int count = 0;

    public void printCountSubstringSameFirstAndLastChars(String s) {
        count = 0;
        setCountSubstringSameFirstAndLastChars(s, 0, s.length());
        System.out.println(count);
    }

    private void setCountSubstringSameFirstAndLastChars(String s, int start, int end) {
        if (start >= end) {
            return;
        } else {
            // Generate all substrings and check them
            for (int i = start; i < end; i++) {
                //System.out.println("Str: " + s.substring(start, i + 1));
                if (isDuplicate(s, start, i)) {
                    count++;
                }
            }

            // new substring starts from start + 1
            setCountSubstringSameFirstAndLastChars(s, start + 1, end);
        }
    }

    private boolean isDuplicate(String s, int start, int end) {
        return s.charAt(start) == s.charAt(end);
    }
    
}
