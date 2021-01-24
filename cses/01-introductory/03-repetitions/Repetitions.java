import java.util.*;

public class Repetitions {
    public static void main(String[] args) {
	    Repetitions sol = new Repetitions();
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(sol.maxRepetitions(s));
	}
	
    /* we have to find the repetitions, as we go 
	   Use lastChar to track last char, if cur char is not equal to lastChar,
	   get count till now to maximize it
	 */

	int maxRepetitions(String s) {
		if (s.length() == 1) {
			return 1;
		}

		Character lastChar = null;
		int count = 0;
		int max = 0;
		int n = s.length();
		
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (lastChar != null && c == lastChar) {
				count++;
			} else {
				max = Math.max(max, count);
				count = 1;
			}

			lastChar = c;
		}

		max = Math.max(max, count);

		return max;
	}
}
